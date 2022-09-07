/**
 * 
 */
package com.aelion.suivi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.suivi.entities.POETypeEntity;
import com.aelion.suivi.services.POETypeService;

/**
 * @author Aelion
 *
 */

@RestController
@RequestMapping("/poetype")
public class POETypeController {

	@Autowired
	private POETypeService poeTypeService;
	
	@GetMapping()
	@CrossOrigin
	public List<POETypeEntity> findAll() {
		return this.poeTypeService.findAll();
	}
	
	@GetMapping("/{id}")
	@CrossOrigin
	public Optional<POETypeEntity> findOne(@PathVariable int id) {
		return this.poeTypeService.findOne( (long) id);
	}
	
	@PostMapping()
	public POETypeEntity add(@RequestBody POETypeEntity poeType) {
		return this.poeTypeService.add(poeType);
	}
}
