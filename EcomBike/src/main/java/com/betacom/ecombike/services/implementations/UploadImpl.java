package com.betacom.ecombike.services.implementations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.betacom.ecombike.exceptions.EcomBikeException;
import com.betacom.ecombike.services.interfaces.IUploadServices;
import  com.betacom.ecombike.models.Prodotto;
import  com.betacom.ecombike.repositories.IProdottoRepository;
import  com.betacom.ecombike.services.interfaces.IMessaggioServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UploadImpl implements IUploadServices{

	private final Path uploadPath;
	private final  IMessaggioServices msgS;
	private final IProdottoRepository prodR;
	
	
	public UploadImpl(@Value("${app.upload.dir:uploads}") String uploadDir,  // valore per default della value
			IMessaggioServices msgS, IProdottoRepository prodR ) {
	        this.uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize(); // transform relative path in absolute  path
	        this.msgS = msgS;
	        this.prodR = prodR;
	        init();
	    }	
	
	private void init() {
		try {
			if (Files.notExists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
		} catch (IOException e) {
			throw new RuntimeException(msgS.get("upload_create"));
		}
	}
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public String saveImage(MultipartFile file, Integer id) throws Exception {
		log.debug("saveImage {}", id);
		
		Assert.isTrue(!file.isEmpty(),() -> msgS.get("upload_empty")); // control file loaded
		
        String original = file.getOriginalFilename();
        String extension = "";
        String originalName = original.trim().replaceAll("\\s+", "_"); // normalize file name
 
        log.debug("originalName: {}" , originalName);
        
        extension = Optional.ofNullable(originalName)         // search extension file 
                .filter(name -> name.contains("."))
                .map(name -> name.substring(name.lastIndexOf(".")))
                .orElse("");

        // Build unique name
        String uniqueName =  originalName.substring(0, originalName.lastIndexOf(".")) + "-" +  UUID.randomUUID().toString() + extension;

        Path destinationFile = uploadPath.resolve(uniqueName);
        
        try {
            Files.copy(file.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);
            Prodotto v = prodR.findById(id)
            	.orElseThrow(() -> new EcomBikeException(msgS.get("prodotto_ntfnd")));
            
            if (v.getImage() != null) {
	            removeImage(v.getImage());
            }
            
            v.setImage(uniqueName);
            
        } catch (IOException e) {
            throw new RuntimeException(msgS.get("upload_save_error"));
        }
    
        return uniqueName;
	}

	@Override
	public void removeImage(String filename) throws Exception {
		Path filePath = uploadPath.resolve(filename).normalize();
        Files.deleteIfExists(filePath);
	}

	@Override
	public String buildUrl(String filename) {
		if (prodR.safeExistsByImage(this.uploadPath, filename)) {
			return ServletUriComponentsBuilder.fromCurrentContextPath()  // recupera la parte iniziale dell URL // localhost:8080/
	                .path("/images/")    // il prefisse sarebbe image
	                .path(filename)                 // il nome del file
	                .toUriString();
		}
		
		throw new EcomBikeException("Immagine non trovata: " + filename);
	}
}
