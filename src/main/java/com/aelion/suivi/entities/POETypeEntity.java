/**
 * 
 */
package com.aelion.suivi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Aelion
 *
 */
@Entity
@Table(name="poe_type")
public class POETypeEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=50)
	private String title;
	
	//relation enverse a utiliser avec grand precausion
	@OneToMany()
	private List<POEEntity> poes = new ArrayList<>(); //instancier pour que poes devient un objet, pour eviter NUllPointerException 

	/**
	 * @return the poes
	 */
	public List<POEEntity> getPoes() {
		return poes;
	}
	
	//ajouter poe a ce list de poes
	public void addPoe(POEEntity poeEntity) {
		this.poes.add(poeEntity);
	}
	
	//delete poe de ce List de poes
	public void removePoe(POEEntity poeEntity) {
		this.poes.remove(poeEntity);
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
	
}
