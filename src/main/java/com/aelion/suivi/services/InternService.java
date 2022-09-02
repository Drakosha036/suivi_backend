/**
 * 
 */
package com.aelion.suivi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aelion.suivi.dto.InternShortListDto;
import com.aelion.suivi.entities.InternEntity;
import com.aelion.suivi.repositories.InternRepository;

/**
 * @author Aelion
 *
 */
@Service
public class InternService implements ICrud<InternEntity> {

	//instance de InternRepository
	//private FakeInternRepository internRepository = new FakeInternRepository();
	
	@Autowired //DI
	private InternRepository repository; //spring instancie l'objet au moment d'execution
	
	/**
	 * INSERT INTO intern (name, firstname, ..., address) VALUES (...)
	 */
	@Override
	public InternEntity add(InternEntity t) {
		return this.repository.save(t);
	}

	@Override
	public InternEntity[] add(InternEntity[] ts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(InternEntity t) {		
		this.repository.save(t);
	}

	@Override
	public void delete(InternEntity t) {
		this.repository.delete(t);
	}

	@Override
	public List<InternEntity> findAll() {
		// findAll() retourne Iterable, donc il faut cast/convertir pour que ca devient List 
		return (List<InternEntity>) this.repository.findAll();
	}

	//appelle le repository pour le methode
	@Override
	public Optional<InternEntity> findOne(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public void delete(Long id) {
	}
	
	/**
	 * 
	 * @return A List of InternShortListDto objects
	 */
	public List<InternShortListDto> shortList() {
		//methode find all retourne un Iterable, donc on le cast en ArrayList
		// et on stock le resultat dans une variable itEntity de type ArrayList de InternEntity
		ArrayList<InternEntity> itEntity = (ArrayList<InternEntity>) this.repository.findAll();
		
		//Need to map InternEntity to InternShortListDto
		ArrayList<InternShortListDto> dto = new ArrayList<>();
		//on parcourt tous les elements
		for (InternEntity entity : itEntity) {
			//creer un nouveau objet transforme 
			InternShortListDto transformed = new InternShortListDto();
			//add l'objet transforme dans dto
			dto.add(transformed.transform(entity));
		}
		return dto;
	}
	
	public Iterable<InternEntity> internsAsIterable() {
		return this.repository.findAll();
	}
	
	public List<InternEntity> findByName(String name) {
		return this.repository.findByName(name);
	}
	
	public List<InternEntity> findByFirstName(String firstName) {
		return this.repository.findByFirstName(firstName);
	}
	
	public Optional<InternEntity> internByMail(String email) {
		return this.repository.internByMail(email);
	}
	
	/*
	 * public ResponseEntity<?> internByMail(String email) {
	 * InternEntity entity = this.internService.internByMail(email);
		if (entity == null) {
			return ResponseEntity.notFound().build();;
		}
		return  ResponseEntity.ok(entity);
	 * }
	 */

}
