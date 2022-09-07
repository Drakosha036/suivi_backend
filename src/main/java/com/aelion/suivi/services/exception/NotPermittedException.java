/**
 * 
 */
package com.aelion.suivi.services.exception;

import org.springframework.http.ResponseEntity;

/**
 * @author Aelion
 *
 */
public class NotPermittedException extends Exception implements HttpErrorInterface {

	
	public NotPermittedException(String message) {
		super(message); //suchage de constructeur - on appele classe mere
	}
	@Override
	public ResponseEntity<String> send() {
		return ResponseEntity.unprocessableEntity().build();
	}

}
