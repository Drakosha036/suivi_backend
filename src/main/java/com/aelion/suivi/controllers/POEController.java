/**
 * 
 */
package com.aelion.suivi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.suivi.dto.POEShortListDto;
import com.aelion.suivi.entities.POEEntity;
import com.aelion.suivi.services.POEService;
import com.aelion.suivi.services.exception.NotFoundException;

/**
 * @author Aelion
 *
 */
@RestController
@RequestMapping("/poe") //le racine des routes
public class POEController {
	
	@Autowired
	private POEService poeService;
	
	
	@GetMapping()
	public List<POEEntity> getAll() {
		return this.poeService.findAll();	
	}
	
	@GetMapping("/shortpoe")
	public List<POEShortListDto> shortPOE() {
		return this.poeService.shortListPOE();
	}
	
	
	
	/*
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) { //comment route va etre traite
		Optional<POEEntity> oPOEEntity = this.poeService.findOne(id);
		//si l'objet est trouve, retourner response 200, ok
		if (oPOEEntity.isPresent()) {
			return ResponseEntity.ok(oPOEEntity.get());
		}
		//si pas trouve renvoyer 404 not found
		return (ResponseEntity<?>) ResponseEntity.notFound().build();
	}
	*/
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) throws Exception {
		try { 
			//on essaye d'executer ce code
			return ResponseEntity.ok(this.poeService.getOne(id));
		} catch (NotFoundException e) {
			//on utilise la methode de la classe NotFoundException
			return e.send(); //retourne la reponse
		}
	}
	
	@PostMapping()
	public POEEntity add(@RequestBody POEEntity poe) { //grace au @RequestBody on recuper lecontenu de la requete
		return this.poeService.add(poe);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		try {
			this.poeService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<String>("Id was not provided", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
	
	/* exemple de JL on mettra uri /poe/1 et pas le raw JSON
	@DeleteMapping("/{id}")
	ResponseEntity<?> delete(@PathVariable int id) {
		return null;
	}
	*/
	
	@PutMapping()
	public  ResponseEntity<?> update(@RequestBody POEEntity poe) {
		this.poeService.update(poe);
		//pas de contenu, donc on retourne la reponse sans contenu
		return ResponseEntity.noContent().build();
	}
	
	
}
