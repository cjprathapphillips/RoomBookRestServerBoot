package com.roombooker.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Prathap Phillips
 *
 */
/** Interface to respond with HttpStatus REST responce for a successful and fail Operation */
public interface RoomBookStautusResponce {
	
	/**
	 * @param roombook
	 * @return
	 */
	public static ResponseEntity<HttpStatus> returnRoomBookerStatus(Object roombook){
		if(roombook!=null)
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		else 
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		

		
	}

}
