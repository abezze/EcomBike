package com.betacom.ecombike.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.betacom.ecombike.exceptions.EcomBikeException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Utils {

	public static LocalDate stringToDate(String date) throws Exception{
		try {
			log.debug("Date:" + date);
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");		
			return LocalDate.parse(date, formater);
			
		} catch (DateTimeParseException e) {
			throw new EcomBikeException("Data invalida.");
		}
	}
}
