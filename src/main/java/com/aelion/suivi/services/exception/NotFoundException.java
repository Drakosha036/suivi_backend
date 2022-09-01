/**
 * 
 */
package com.aelion.suivi.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Aelion
 *
 */
public class NotFoundException extends Exception implements HttpErrorInterface {
	//constructeur de classe vide
	public NotFoundException() {
		//instancier la classe a partir de classe mere
		super();
	}
	
	//constructeur avec message
	public NotFoundException(String message) {
		super(message);
	}
	
	//methode
	public ResponseEntity<String> send() {
		// si try echoue on catch l'exception
		//return ResponseEntity.notFound().build(); // renvoie les entetes de http status, ex le 404 not found
		return new ResponseEntity<String>(this.getMessage(), HttpStatus.NOT_FOUND);
	}
 }
