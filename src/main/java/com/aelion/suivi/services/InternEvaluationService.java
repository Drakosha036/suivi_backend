/**
 * 
 */
package com.aelion.suivi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aelion.suivi.entities.InternEvaluationEntity;
import com.aelion.suivi.repositories.InternEvaluationRepository;
import com.aelion.suivi.services.exception.NotPermittedException;

/**
 * @author Aelion
 *
 */
@Service
public class InternEvaluationService implements ICrud<InternEvaluationEntity>{

	@Autowired
	private InternEvaluationRepository internEvaluationRepository;
	
	@Override
	public InternEvaluationEntity add(InternEvaluationEntity t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternEvaluationEntity[] add(InternEvaluationEntity[] ts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(InternEvaluationEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<?> delete(InternEvaluationEntity t) throws NotPermittedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InternEvaluationEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<InternEvaluationEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
