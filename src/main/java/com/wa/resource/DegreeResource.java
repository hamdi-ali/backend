package com.wa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wa.domain.learner.Degree;
import com.wa.service.DegreeService;

@RestController
@RequestMapping("/degree")
public class DegreeResource {

	@Autowired 
	private DegreeService degreeService;
	
	@RequestMapping(value="/degreeList", method=RequestMethod.GET)
	public List<Degree> getDegreeList(){
		return degreeService.findAll();
	}
}
