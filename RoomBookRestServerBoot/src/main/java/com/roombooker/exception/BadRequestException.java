package com.roombooker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author Prathap Phillips
 *
 */

/** Exception to handle any error due to validation */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad Request")
public class BadRequestException extends Exception {
	private static final long serialVersionUID = 1L;
	public BadRequestException() {   }

}
