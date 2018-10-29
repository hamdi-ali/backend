package com.wa.resource;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wa.domain.Skill;
import com.wa.domain.Training;
import com.wa.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillResource {
	
	@Autowired
	private SkillService skillService;
	
	@RequestMapping(value="/skillList", method=RequestMethod.GET)
	public List<Skill> getSkillList(){
		return skillService.findAll();
	}
	
	@RequestMapping(value="/findSkill/{idSkill:[\\d]}", method=RequestMethod.GET)
	public Skill getLearnerById(@PathVariable("idSkill") Long idSkill){
		return skillService.findOne(idSkill);
	}
	
	@RequestMapping(value="/add")
	public ResponseEntity addSkillPost(@RequestBody Skill skill){
		
		if(skillService.findByName(skill.getName())!=null){
			return new ResponseEntity("titleExists",HttpStatus.BAD_REQUEST);
		}
		skillService.save(skill);
		return new ResponseEntity("Skill Added Successffuly", HttpStatus.OK);
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public ResponseEntity removeSkillPost(@RequestBody String id)throws IOException
	{
		skillService.removeOne(Long.parseLong(id)); 
		return new ResponseEntity("Remove Success!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity updateSkillPost(@RequestBody Skill skill)
	{
		Skill localSkill=skillService.findByName(skill.getName());
		if(localSkill!=null && skill.getSkillId()!=localSkill.getSkillId()){
			return new ResponseEntity("Name Exists",HttpStatus.BAD_REQUEST);
		}
		skillService.save(skill);
		return new ResponseEntity("Skill updated Successffuly", HttpStatus.OK);
	}


}
