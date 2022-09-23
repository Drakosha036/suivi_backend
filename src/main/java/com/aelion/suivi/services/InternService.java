/**
 * 
 */
package com.aelion.suivi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aelion.suivi.dto.InternInputDto;
import com.aelion.suivi.dto.InternShortListDto;
import com.aelion.suivi.entities.InternEntity;
import com.aelion.suivi.entities.POEEntity;
import com.aelion.suivi.repositories.InternRepository;
import com.aelion.suivi.repositories.POERepository;
import com.aelion.suivi.services.exception.NotPermittedException;

/**
 * @author Aelion
 *
 */
@Service
public class InternService implements ICrud<InternEntity> {

	//instance de InternRepository
	//private FakeInternRepository internRepository = new FakeInternRepository();
	
	@Autowired //DI
	private InternRepository internRepository; //spring instancie l'objet au moment d'execution
	
	
	@Autowired
	private POERepository poeRepository;
	
	/**
	 * INSERT INTO intern (name, firstname, ..., address) VALUES (...)
	 */
	@Override
	public InternEntity add(InternEntity t) {
		return this.internRepository.save(t);
	}

	@Override
	public InternEntity[] add(InternEntity[] ts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(InternEntity t) {		
		this.internRepository.save(t);
	}

	@Override
	public ResponseEntity<?> delete(InternEntity t) throws NotPermittedException {
		try {
			this.internRepository.delete(t);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new NotPermittedException(e.getMessage());
		}
	}

	@Override
	public List<InternEntity> findAll() {
		// findAll() retourne Iterable, donc il faut cast/convertir pour que ca devient List 
		return (List<InternEntity>) this.internRepository.findAll();
	}

	//appelle le repository pour le methode
	@Override
	public Optional<InternEntity> findOne(Long id) {
		return this.internRepository.findById(id);
	}

	@Override
	public ResponseEntity<?> delete(Long id) throws NotPermittedException {
		try {
			this.internRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new NotPermittedException("Intern with id : " + id + " cannot be deleted" );
		}
	}
	
	/**
	 * 
	 * @return A List of InternShortListDto objects
	 */
	public List<InternShortListDto> shortList() {
		//methode find all retourne un Iterable, donc on le cast en ArrayList
		// et on stock le resultat dans une variable itEntity de type ArrayList de InternEntity
		ArrayList<InternEntity> itEntity = (ArrayList<InternEntity>) this.internRepository.findAll();
		
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
		return this.internRepository.findAll();
	}
	
	public List<InternEntity> findByName(String name) {
		return this.internRepository.findByName(name);
	}
	
	public List<InternEntity> findByFirstName(String firstName) {
		return this.internRepository.findByFirstName(firstName);
	}
	
	//public Optional<InternEntity> internByMail(String email) {
	//	return this.internRepository.internByMail(email);
	//}
	
	public ResponseEntity<?> byEmail(String email) {
		ResponseEntity response = null;
		InternEntity entity = this.internRepository.internByMail(email);
		
		if (entity == null) {
			return new ResponseEntity(HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.FORBIDDEN);
	}

	public InternEntity addInternAndPoes(InternInputDto internDto) {
		InternEntity intern = new InternEntity();
		intern.setAddress(internDto.address);
		intern.setBirthdate(internDto.birthDate);
		intern.setEmail(internDto.email);
		intern.setFirstName(internDto.firstName);
		intern.setName(internDto.name);
		intern.setPhoneNumber(internDto.phoneNumber);
		
		//Persist intern
		this.internRepository.save(intern);
		
		//Persist POEs with the new Intern
		internDto.poes.forEach(inputPoe -> {
			//chercher intern dans le POE
				Optional<POEEntity> oPoe = this.poeRepository.findById(inputPoe.getId());
				if (oPoe.isPresent()) {
					POEEntity poe = oPoe.get();
					poe.addIntern(intern);
					this.poeRepository.save(poe);
				}
			});
		return intern;
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
