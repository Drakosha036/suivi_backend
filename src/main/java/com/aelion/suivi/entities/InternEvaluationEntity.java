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
	//C'eest comme ca la table d'associations sera cree:
	@JoinColumn(name="intern_id") //colonne de jointure c'est intern_id
	private InternEntity intern;
	
	@ManyToOne()
	@JoinColumn(name="skill_id")
	private SkillEntity skill;
	
	/**
	 * @return the note
	 */
	public int getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(int note) {
		this.note = note;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the intern
	 */
	public InternEntity getIntern() {
		return intern;
	}

	/**
	 * @param intern the intern to set
	 */
	public void setIntern(InternEntity intern) {
		this.intern = intern;
	}

	/**
	 * @return the skill
	 */
	public SkillEntity getSkill() {
		return skill;
	}

	/**
	 * @param skill the skill to set
	 */
	public void setSkill(SkillEntity skill) {
		this.skill = skill;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
}
