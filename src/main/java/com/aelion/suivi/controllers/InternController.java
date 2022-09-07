/**
 * 
 */
package com.aelion.suivi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.suivi.dto.InternShortListDto;
import com.aelion.suivi.entities.InternEntity;
import com.aelion.suivi.services.InternService;
import com.aelion.suivi.services.exception.NotPermittedException;

/**
 * @author Aelion
 *
 */
@RestController	//decorateur por que la classe devient le controlleur
@RequestMapping("/intern") //chemin uri
public class InternController {
	
	//injection de dependence
	@Autowired
	private InternService internService;

	@GetMapping("/hello")
	//*ResponseEntity est une classe avec le type de retour string*/
	public ResponseEntity<String> greetings() {
		//retourne la methode ok de la clase
		return ResponseEntity.ok("Hello SpringBoot");
	}
	
	@GetMapping()
	@CrossOrigin
	public List<InternEntity> getAll() {
		return this.internService.findAll(); //returned as JSON
	}

	@GetMapping("/shortlist")
	public List<InternShortListDto> shortList() {
		return this.internService.shortList(); //ca retourne la liste de InternShortListDto ce qu'on attend
	}
	
	
	//dans la param de GetMapping on met objet id qui va retourner la valeur d id
	//route "/valeur"
	//appel a methode du service
	@GetMapping("/{id}")
	@CrossOrigin
	//a la place de Optional ici on va envoyer ResponseEntity<?>
	//pour enoyer le status
	public ResponseEntity<?> getOne(@PathVariable Long id) { //comment route va etre traite
		Optional<InternEntity> oInternEntity = this.internService.findOne(id);
		//si l'objet est trouve, retourner response 200, ok
		if (oInternEntity.isPresent()) {
			return ResponseEntity.ok(oInternEntity.get());
		}
		//si pas trouve renvoyer 404 not found
		return  ResponseEntity.notFound().build();
	}
	
	/**
	 * 
	 * @param intern
	 * @return doit returner status - 201 http status de creation successful
	 */
	@PostMapping()
	public InternEntity add(@RequestBody InternEntity intern) { //grace au requestbody on recuper lecontenu de la requete
		return this.internService.add(intern);
	}
	
	
	@DeleteMapping()
	@CrossOrigin
	//ResponseEntity<?> on sait pas quel type on va renvoyer
	public ResponseEntity<?> delete(@RequestBody InternEntity intern) { //n'oublier pas @RequestBody
		try {
			this.internService.delete(intern);
			return ResponseEntity.noContent().build();
		} catch (NotPermittedException e) {
			return e.send();
		}
		//utilise le methode static de ResponseEntity, il faut le build pour reconstuire l'objet
		//return ResponseEntity.noContent().build(); //pour RESTFul il faut renvoyer le status
	}
	
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody InternEntity intern) {
		this.internService.update(intern);
		return ResponseEntity.noContent().build(); //pas de contenu, donc on retourne la reponse sans contenu
	}
	
	
	@GetMapping("/asiterable")
	public Iterable<InternEntity> findAll() {
		return this.internService.internsAsIterable();
	}
	
	@GetMapping("/byname/{name}")
	public List<InternEntity> findByName(@PathVariable String name) {
		System.out.println(name);
		return this.internService.findByName(name);
	}
	
	@GetMapping("/byfirstname/{firstName}") 
	public List<InternEntity> findByFirstName(@PathVariable String firstName) {
		System.out.println(firstName);
		return this.internService.findByFirstName(firstName);
	}
	
	@GetMapping("/byemail")
	public ResponseEntity<?> internByMail(@RequestParam() String email) {
		Optional<InternEntity> entity = this.internService.internByMail(email);
		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		}
		return  ResponseEntity.notFound().build();
	}
	
	
}
