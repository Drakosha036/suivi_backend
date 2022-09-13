/**
 * 
 */
package com.aelion.suivi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.aelion.suivi.entities.SkillsEntity;
import com.aelion.suivi.services.exception.NotPermittedException;

/**
 * @author Aelion
 *
 */
public class SkillsService implements ICrud<SkillsEntity>{

	@Override
	public SkillsEntity add(SkillsEntity t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SkillsEntity[] add(SkillsEntity[] ts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SkillsEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<?> delete(SkillsEntity t) throws NotPermittedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SkillsEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SkillsEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
