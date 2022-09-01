/**
 * 
 */
package com.aelion.suivi.dto;

import com.aelion.suivi.entities.POEEntity;

/**
 * @author Aelion
 *
 */
public class POEShortListDto {
	public Long id;
	public String name;
	
	public POEShortListDto transform(POEEntity poe) {
		this.id = poe.getId();
		this.name = poe.getName();
		
		return this;
	}
}
