/**
 * 
 */
package com.aelion.suivi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aelion.suivi.entities.SkillEntity;
import com.aelion.suivi.repositories.SkillsRepository;
import com.aelion.suivi.services.exception.NotPermittedException;

/**
 * @author Aelion
 *
 */
@Service
public class SkillsService implements ICrud<SkillEntity>{

	@Autowired
	private SkillsRepository skillRepository;
	
	@Override
	public SkillEntity add(SkillEntity t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SkillEntity[] add(SkillEntity[] ts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SkillEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<?> delete(SkillEntity t) throws NotPermittedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SkillEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SkillEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
