/**
 * 
 */
package com.aelion.suivi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelion.suivi.entities.POETypeEntity;
import com.aelion.suivi.repositories.POETypeRepository;



/**
 * @author Aelion
 *
 */
@Service
public class POETypeService implements ICrud<POETypeEntity>{

	@Autowired
	private POETypeRepository poeTypeRepository;
	
	@Override
	public POETypeEntity add(POETypeEntity t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public POETypeEntity[] add(POETypeEntity[] ts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(POETypeEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(POETypeEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<POETypeEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<POETypeEntity>) this.poeTypeRepository.findAll();
	}

	@Override
	public Optional<POETypeEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return this.poeTypeRepository.findById(id.intValue()); //intValue convertit long en int
	}
	
}