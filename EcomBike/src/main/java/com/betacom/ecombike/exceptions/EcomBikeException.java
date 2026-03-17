package com.betacom.ecombike.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EcomBikeException  extends RuntimeException{

	public EcomBikeException() {
		super();
	}

	public EcomBikeException(String message) {
		log.debug(message);
		super(message);
	}

}
