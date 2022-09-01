/**
 * 
 */
package com.aelion.suivi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.aelion.suivi.dto.POEShortListDto;
import com.aelion.suivi.entities.POEEntity;
import com.aelion.suivi.repositories.POERepository;
import com.aelion.suivi.services.exception.NotFoundException;

/**
 * @author Aelion
 *
 */
@Service
public class POEService implements ICrud<POEEntity>{
	
	@Autowired
	private POERepository poeRepository;

	@Override
	public POEEntity add(POEEntity t) {
		// TODO Auto-generated method stub
		return this.poeRepository.save(t);
	}

	@Override
	public POEEntity[] add(POEEntity[] ts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(POEEntity t) {
		this.poeRepository.save(t);
		
	}

	@Override
	public void delete(POEEntity t) {
		this.poeRepository.delete(t);
	}

	@Override
	public List<POEEntity> findAll() {
		//retourne la liste de poes
		return (List<POEEntity>) this.poeRepository.findAll();
	}

	@Override
	public Optional<POEEntity> findOne(Long id) {		
		return this.poeRepository.findById(id);
	}
	
	public POEEntity getOne(Long id) throws Exception {
		Optional<POEEntity> oEntity = this.poeRepository.findById(id);
		
		if(oEntity.isPresent()) {
			return oEntity.get();
		} else {
			throw new NotFoundException("the POE with " + id + " not found");
		}
		
	}

	@Override
	public void delete(Long id) throws Exception { //throws Exception c'est la classe generic, donc on peut throws Exception ou NotFoundException, c'est pareil
		Optional<POEEntity> oEntity = this.findOne(id);
		if (oEntity.isPresent()) {
			try {
				this.poeRepository.deleteById(id);
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException();
			}
		} else {
			throw new NotFoundException("POE with id : " + id + " was not found!");
		}
		
		//this.poeRepository.deleteById(id);
		
		/* casting Long to int
		 * int intId = id.intValue();
		 * this.poeRepository.deleteById(intId);*/
	}

	public List<POEShortListDto> shortListPOE() {
		ArrayList<POEEntity> poeEntity = (ArrayList<POEEntity>) this.poeRepository.findAll();

		ArrayList<POEShortListDto> dto = new ArrayList<>();
		
		for (POEEntity entity : poeEntity) {
			POEShortListDto transformed = new POEShortListDto();
			dto.add(transformed.transform(entity));
		}
		return dto;
	}
	

}
