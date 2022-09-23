/**
 * 
 */
package com.aelion.suivi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Aelion
 *
 */
@Entity
@Table(name="module")
public class ModuleEntity {
	
	@Id
	private Long id;
	
	private String title;
	private String description;
	
	

}
