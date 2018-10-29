package com.wa.resource;
import java.util.List;
import java.io.IOException;
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
import com.wa.service.TrainingService;


@RestController
@RequestMapping("/training")
public class TrainingResource {
	
	@Autowired
	private TrainingService trainingService;
	
	@RequestMapping(value="/trainingList", method=RequestMethod.GET)
	public List<Training> getTrainingList(){
		return trainingService.findAll();
	}
	
	@RequestMapping(value="/findTraining/{idTraining:[\\d]}", method=RequestMethod.GET)
	public Training getLearnerById(@PathVariable("idTraining") Long idTraining){
		return trainingService.findOne(idTraining);
	}
	
	@RequestMapping(value="/add")
	public ResponseEntity addTrainingPost(@RequestBody Training training){
		
		if(trainingService.findByName(training.getName())!=null){
			return new ResponseEntity("titleExists",HttpStatus.BAD_REQUEST);
		}
		trainingService.save(training);
		return new ResponseEntity("Training Added Successffuly", HttpStatus.OK);
	}
	
	@RequestMapping(value="/update")
	public ResponseEntity updateTrainingPost(@RequestBody Training training){
		
		Training localTraining=trainingService.findByName(training.getName());
		if(localTraining!=null && training.getTrainingId()!=localTraining.getTrainingId()){
			return new ResponseEntity("titleExists",HttpStatus.BAD_REQUEST);
		}
		trainingService.update(training);
		return new ResponseEntity("Training updated Successffuly", HttpStatus.OK);
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public ResponseEntity removeTrainingPost(@RequestBody String id)throws IOException
	{
		trainingService.removeOne(Long.parseLong(id)); 
		return new ResponseEntity("Remove Success!", HttpStatus.OK);
	}
}
