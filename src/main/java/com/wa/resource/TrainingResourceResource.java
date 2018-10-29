package com.wa.resource;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wa.domain.TrainingResource;
import com.wa.service.TrainingResourceService;

@RestController
@RequestMapping("/trainingResource")
public class TrainingResourceResource {
	
	@Autowired 
	private TrainingResourceService trainingResourceService;
	
	@RequestMapping(value="/trainingResourceList", method=RequestMethod.GET)
	public List<TrainingResource> getTrainingResourceList(){
		return trainingResourceService.findAll();
	}
	
	@RequestMapping(value="/add")
	public ResponseEntity addTrainingResourcePost(@RequestBody TrainingResource trainingResource){
		
		if(trainingResourceService.findByTitle(trainingResource.getTitle())!=null){
			return new ResponseEntity("titleExists",HttpStatus.BAD_REQUEST);
		}
		trainingResourceService.save(trainingResource);
		return new ResponseEntity("Training Resource Added Successffuly", HttpStatus.OK);
	}

	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public ResponseEntity removeTrainingResourcePost(@RequestBody String id)throws IOException
	{
		trainingResourceService.removeOne(Long.parseLong(id)); 
		return new ResponseEntity("Remove Success!", HttpStatus.OK);
	}


	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity updateTrainingResourcePost(@RequestBody TrainingResource trainingResource)
	{ 
		TrainingResource tr=trainingResourceService.findByTitle(trainingResource.getTitle());
		if(tr!=null && tr.getTrainingResourceId()!=trainingResource.getTrainingResourceId()){
			return new ResponseEntity("titleExists",HttpStatus.BAD_REQUEST);
		}
		trainingResourceService.save(trainingResource);
		return new ResponseEntity("Training Resource updated Successffuly", HttpStatus.OK);
	}

}
