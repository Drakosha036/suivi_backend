/**
 * 
 */
package com.aelion.suivi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Aelion
 *
 */
@Entity
@Table(name="evaluation_intern")
public class InternEvaluationEntity {

	@Id
	private Long id; //dans la BD la colonne id n'est pas neccesaire
	
	@Column(nullable=false) //valeur obligatoire
	private int note;
	
	private String comment;
	
	@ManyToOne()
	@JoinColumn(name="intern_id") //colonne de jointure c'est intern_id
	private InternEntity intern;
	
	@ManyToOne()
	@JoinColumn(name="skill_id")
	private SkillEntity skill;
	
}
