/**
 * 
 */
package com.aelion.suivi.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aelion.suivi.entities.InternEntity;

/**
 * @author Aelion
 *
 */
//dans la repository il y a des donnees / connexion avec la BD
public final class FakeInternRepository {
	//attributs
	//on utilise List et pas ArrayList pour generaliser, si on change new ArrayList par un autre type de list,application continuera fonctionner
	private List<InternEntity> interns = new ArrayList<>();
	
	
	
	//constructeur
	public FakeInternRepository() {
		//appeller le methode private pour ajouter deux interns dans la liste
		this.populate();
	}
	
	//getter
	public List<InternEntity> getInterns() {
		return this.interns;
	}
	
	public InternEntity add(InternEntity intern) {
		this.interns.add(intern);
		return intern;
	}
	
	public void delete(InternEntity intern) {
		this.interns.remove(intern);
	}
	
	//setter
	private void populate() {
		//instantiation d'un objet INternEntit
		InternEntity intern = new InternEntity();
		//initialisation
		//intern.setId(1L); //specifier type Long
		intern.setName("Aubert");
		intern.setFirstName("Jean-Luc");
		intern.setEmail("jla.webprojet@gmail.com");
		intern.setPhoneNumber("(+33) 6 06 06 06 06");
				
		//ajouter  intern dans la list d'interns
		this.interns.add(intern);
		
		//creer deuxieme intern
		intern = new InternEntity();
		//intern.setId(2L);
		intern.setName("Kostina");
		intern.setFirstName("Sasha");
		intern.setEmail("sasha@gmail.com");
		intern.setPhoneNumber("(+33) 6 06 06 06 06");
		
		this.interns.add(intern);
	}
	
	/*
	public InternEntity findOne(Long id) {
		//parcourir le tableau d'interns et retourner l'intern avec id recherche s'il exist
		// for intern in interns
		for (InternEntity intern : this.interns) {
			if (intern.getId() == id ) {
				return intern;
			}
		}
		return null;
	}
	*/
	
	//ici interroge le list, sinon bd
	public Optional<InternEntity> findOne(Long id) {
		for (InternEntity intern : this.interns) {
			if (intern.getId() == id) {
				return Optional.of(intern);
			}
		}
		return Optional.empty();
	}
	
	
}
