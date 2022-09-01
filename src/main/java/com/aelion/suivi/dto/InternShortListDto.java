/**
 * 
 */
package com.aelion.suivi.dto;

import java.util.Date;

import com.aelion.suivi.entities.InternEntity;

/**
 * @author Aelion
 *
 */
public class InternShortListDto {
	//attributs
	public Long id;
	public String name;
	public String firstName;
	public Date birthDate;
	
	//methodes
	public InternShortListDto transform(InternEntity intern) {
		//mapping: on met les attributs d'un dans un autre
		this.id = intern.getId();
		this.name = intern.getName();
		this.firstName = intern.getFirstName();
		this.birthDate = intern.getBirthdate();
		
		//retourne l'objet meme
		return this;
	}

}
