package com.wa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wa.domain.Formation;
import com.wa.domain.TypeFormation;
import com.wa.service.FormationService;
import com.wa.service.TypeFormationService;

@RestController
@RequestMapping("/formation")
public class FormationResource {
	
	@Autowired
	private FormationService formationService;
	
	@Autowired 
	private TypeFormationService typeFormationService;
	
	@RequestMapping(value="/formationList", method=RequestMethod.GET)
	public List<Formation> getSkillList(){
		return formationService.findAll();
	}
	
	@RequestMapping(value="/typesList", method=RequestMethod.GET)
	public List<TypeFormation> getTypesList(){
		return typeFormationService.findAll();
	}
}
