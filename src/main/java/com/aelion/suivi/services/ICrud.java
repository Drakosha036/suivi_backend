/**
 * 
 */
package com.aelion.suivi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.aelion.suivi.services.exception.NotPermittedException;

/**
 * @author Aelion
 *
 */
//interface generic donc <T>
public interface ICrud<T> {
	//ajouter un item t de type T
	public T add(T t);
	//ajouter un tableau d'elements ts de type T[]
	public T[] add(T[] ts);
	public void update(T t);
	public ResponseEntity<?> delete(T t) throws NotPermittedException;
	public ResponseEntity<?> delete(Long id) throws Exception;
	//returner la list des objets de type T
	public List<T> findAll();
	//Optional return true si l'objet est trouve et false si l'objet n'existe pas
	//findOne return un objet recherche par id 
	public Optional<T> findOne(Long id);

}
