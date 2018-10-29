package com.wa.resource;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wa.domain.learner.Learner;
import com.wa.service.LearnerService;

@RestController
@RequestMapping("/learner")
public class LearnerResource {
	
	@Autowired 
	private LearnerService learnerService;
	
	@RequestMapping(value="/learnerList", method=RequestMethod.GET)
	public List<Learner> getLearnerList(){
		return learnerService.findAll();
	}
	
	@RequestMapping(value="/findLearner/{idLearner:[\\d]}", method=RequestMethod.GET)
	public Learner getLearnerById(@PathVariable("idLearner") Long idLearner){
		return learnerService.findOne(idLearner);
	}
	
	
	@RequestMapping(value="/add")
	public ResponseEntity<Learner> addLeanerPost(@RequestBody Learner learner){
		if(learnerService.findByCin(learner.getCin())!=null){
			return new ResponseEntity("CinExists",HttpStatus.BAD_REQUEST);
		}
		learner=learnerService.save(learner);
		return new ResponseEntity(learner, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity updateLearnerPost(@RequestBody Learner learner)
	{
		Learner localLearner=learnerService.findByCin(learner.getCin());
		//System.out
		if(localLearner!=null && learner.getId()!=localLearner.getId()){
			return new ResponseEntity("Name Exists",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(learnerService.save(learner), HttpStatus.OK);
	}
	
	// surcharge de la methode update
	/*@RequestMapping(value="/update", method=RequestMethod.POST)
	public Learner updateBookPost(@RequestBody Learner learner) {
		return learnerService.save(learner);
	}*/	
	
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public ResponseEntity removeTrainingResourcePost(@RequestBody String id)throws IOException
	{
		learnerService.removeOne(Long.parseLong(id)); 
		return new ResponseEntity("Remove Success!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/add/image", method=RequestMethod.POST)
	public ResponseEntity upload(@RequestParam("id") Long id,
			HttpServletResponse response, HttpServletRequest request){
		
		try {
			Learner learner = learnerService.findOne(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id+".png";
			
			
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/learner/"+fileName)));
			stream.write(bytes);
			stream.close();
			
			return new ResponseEntity("Upload Success!", HttpStatus.OK);
			} catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
		}
	}


	@RequestMapping(value="/update/image", method=RequestMethod.POST)
	public ResponseEntity updateImagePost(@RequestParam("id") Long id,
			HttpServletResponse response, HttpServletRequest request){
		
		try {
			Learner learner = learnerService.findOne(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id+".png";
			
			Files.delete(Paths.get("src/main/resources/static/image/learner/"+fileName));
			
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/learner/"+fileName)));
			stream.write(bytes);
			stream.close();
			
			return new ResponseEntity("Upload Success!", HttpStatus.OK);
			} catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
		}
	}

}
