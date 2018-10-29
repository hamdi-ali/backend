package com.wa.resource;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wa.domain.Group;
import com.wa.domain.learner.Learner;
import com.wa.service.GroupService;

@RestController
@RequestMapping("/group")
public class GroupResource {
	
	@Autowired 
	private GroupService groupService;
	
	@RequestMapping(value="/groupList", method=RequestMethod.GET)
	public List<Group> getGroupList(){
		return groupService.findAll();
	}
	
	@RequestMapping(value="/learnerListByGroupId/{idGroup:[\\d]}", method=RequestMethod.GET)
	public Set<Learner> getLearnersByGroupId(@PathVariable("idGroup") Long idGroup){
		System.out.println("**********  "+idGroup+"  ***************");
		return groupService.findOne(idGroup).getLearners();
	}
	
	@RequestMapping(value="/findGroup/{idGroup:[\\d]}", method=RequestMethod.GET)
	public Group getLearnerById(@PathVariable("idGroup") Long idGroup){
		return groupService.findOne(idGroup);
	}
	
	@RequestMapping(value="/add")
	public ResponseEntity addGroupPost(@RequestBody Group group){
		
		if(groupService.findByName(group.getName())!=null){
			return new ResponseEntity("Name Exists",HttpStatus.BAD_REQUEST);
		}
		groupService.save(group);
		return new ResponseEntity("Group Added Successffuly", HttpStatus.OK);
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public ResponseEntity removeGroupPost(@RequestBody String id)throws IOException
	{
		groupService.removeOne(Long.parseLong(id)); 
		return new ResponseEntity("Remove Success!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity updateSkillPost(@RequestBody Group group)
	{
		Group localGroup=groupService.findByName(group.getName());
		if(localGroup!=null && group.getGroupId()!=localGroup.getGroupId()){
			return new ResponseEntity("Name Exists",HttpStatus.BAD_REQUEST);
		}
		groupService.save(group);
		return new ResponseEntity("Group updated Successffuly", HttpStatus.OK);
	}
}
