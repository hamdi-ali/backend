package com.wa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wa.domain.learner.Institute;
import com.wa.service.InstituteService;

@RestController
@RequestMapping("/institute")
public class InstituteResource {
	
	@Autowired 
	private InstituteService instituteService;
	
	@RequestMapping(value="/instituteList", method=RequestMethod.GET)
	public List<Institute> getInstituteList(){
		return instituteService.findAll();
	}

}
