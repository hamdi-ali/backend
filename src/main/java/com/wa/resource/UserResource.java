package com.wa.resource;

import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.weaver.bcel.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wa.config.SecurityConfig;
import com.wa.config.SecurityUtility;
import com.wa.domain.TrainingResource;
import com.wa.domain.User;
import com.wa.domain.security.Role;
import com.wa.service.UserService;
import com.wa.utility.MailConstructor;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired 
	private UserService userService;
	
	@Autowired 
	private MailConstructor mailConstructor;
	
	@Autowired 
	private JavaMailSender mailSender;
	
	@RequestMapping("/getCurrentUser")
	public User getCurrentUser(Principal principal){
		String username=principal.getName();
		User user =new User();
		if(username!=null){
		user=userService.findByUsername(username);
		}
		return user;	
	}
	
	
	@RequestMapping(value="/newUser",method=RequestMethod.POST)
	public ResponseEntity newUser(HttpServletRequest request,@RequestBody HashMap<String,String> mapper)throws Exception{
		String username=mapper.get("username");
		String userEmail=mapper.get("email");
		
		String firstName = mapper.get("firstName");
		String lastName = mapper.get("lastName");
		//String password = mapper.get("password");
		
		
		if(userService.findByUsername(username)!=null){
			return new ResponseEntity("usernameExists",HttpStatus.BAD_REQUEST);
		}
		
		if(userService.findByEmail(userEmail)!=null){
			return new ResponseEntity("emailExists",HttpStatus.BAD_REQUEST);
		}
		
		User user=new User();
		user.setUsername(username);
		user.setEmail(userEmail);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		String password=SecurityUtility.randomPassword();
		String encryptedPassword=SecurityUtility.passwordEncoder().encode(password);
		
		user.setPassword(encryptedPassword);
		
		SimpleMailMessage email=mailConstructor.constructNewUserEmail(user,password);
		mailSender.send(email);
		
		return new ResponseEntity("User Added Successffuly", HttpStatus.OK);	
	}
	
	@RequestMapping(value="/forgetPassword",method=RequestMethod.POST)
	public ResponseEntity forgetPasswordPost(HttpServletRequest request,@RequestBody HashMap<String,String> mapper)throws Exception{
		
		String email=mapper.get("email"); 
		
		User user=userService.findByEmail(email);
		
		if(user==null){
			return new ResponseEntity("Email not found",HttpStatus.BAD_REQUEST);
		}
		

		
		String password=SecurityUtility.randomPassword();
		String encryptedPassword=SecurityUtility.passwordEncoder().encode(password);
		
		user.setPassword(encryptedPassword);
		userService.save(user);
		
		SimpleMailMessage newEmail=mailConstructor.constructNewUserEmail(user,password);
		mailSender.send(newEmail);
		
		return new ResponseEntity("Email sent!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateUserInfo",method=RequestMethod.POST)
	public ResponseEntity profileInfo(@RequestBody HashMap<String,Object> mapper)throws Exception{
		
		int id=(Integer) mapper.get("id");
		String email=(String) mapper.get("email");
		String username=(String) mapper.get("username");
		String firstName=(String) mapper.get("firstName");
		String lastName=(String) mapper.get("lastName");
		String newPassword=(String) mapper.get("newPassword");
		String currentPassword=(String) mapper.get("currentPassword");
		
		User currentUser=userService.findByUserId((long) id);
		
		if(currentUser==null){
			throw new Exception("User not found!");
		}
		
		if(userService.findByEmail(email)!=null){
			if(userService.findByEmail(email).getId()!=currentUser.getId()){
				return new ResponseEntity("Email not found!",HttpStatus.BAD_REQUEST);
			}
		}
		

		if(userService.findByUsername(username)!=null){
			if(userService.findByUsername(username).getId()!=currentUser.getId()){
				return new ResponseEntity("Username not found!",HttpStatus.BAD_REQUEST);
			}
		}
		
		SecurityConfig securityConfig=new SecurityConfig();
		
		BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
		String dbPassword = currentUser.getPassword();
		
		if(null != currentPassword)
		if(passwordEncoder.matches(currentPassword, dbPassword)) {
			if(newPassword != null && !newPassword.isEmpty() && !newPassword.equals("")) {
				currentUser.setPassword(passwordEncoder.encode(newPassword));
			}
			currentUser.setEmail(email);
		} else {
			return new ResponseEntity("Incorrect current password!", HttpStatus.BAD_REQUEST);
		}
		
		currentUser.setUsername(username);
		currentUser.setLastName(lastName);
		currentUser.setFirstName(firstName);
		currentUser.setEmail(email);
		userService.save(currentUser);
		return new ResponseEntity("Update success",HttpStatus.OK);
	}
	
	
}
