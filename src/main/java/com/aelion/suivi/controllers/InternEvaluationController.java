/**
 * 
 */
package com.aelion.suivi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aelion.suivi.services.InternEvaluationService;

/**
 * @author Aelion
 *
 */
@Controller
public class InternEvaluationController {
	
	@Autowired
	private InternEvaluationService internEvaluationService;
	

}
