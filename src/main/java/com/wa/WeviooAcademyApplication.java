package com.wa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wa.config.SecurityUtility;
import com.wa.domain.TypeFormation;
import com.wa.domain.User;
import com.wa.domain.learner.Degree;
import com.wa.domain.learner.Institute;
import com.wa.domain.security.Role;
import com.wa.service.DegreeService;
import com.wa.service.InstituteService;
import com.wa.service.TypeFormationService;
import com.wa.service.UserService;

@SpringBootApplication
public class WeviooAcademyApplication implements CommandLineRunner{

	@Autowired 
	private UserService userService;
	
	@Autowired 
	private DegreeService degreeService;
	
	@Autowired 
	private InstituteService instituteService;
	
	@Autowired 
	private TypeFormationService typeFormationService;
	
	public static void main(String[] args) {
		SpringApplication.run(WeviooAcademyApplication.class, args);
	}
	
	@Override
	public void run (String... args) throws Exception
	{
		typeFormationService.save(new TypeFormation(1L,"Cours&Tutoriaux"));
		typeFormationService.save(new TypeFormation(2L,"Workshop"));
		typeFormationService.save(new TypeFormation(3L,"Quiz"));
		typeFormationService.save(new TypeFormation(4L,"Mini-projet"));
		typeFormationService.save(new TypeFormation(5L,"Challenge"));
		
		/**************************************************************************************/
		
		instituteService.save(new Institute(1L,"Faculté des Sciences de Tunis (FST)"));
		instituteService.save(new Institute(2L,"École nationale des sciences de l\'informatique (ENSI)"));
		instituteService.save(new Institute(3L,"Institut supérieur d\'informatique (ISI)"));
		instituteService.save(new Institute(4L,"Institut Supérieur des Arts Multimédia de la Manouba (ISAMM)"));
		instituteService.save(new Institute(4L,"Ecole Supérieure Privée d'Ingénierie et de Technologies(ESPRIT)"));
		
		/**************************************************************************************/

		degreeService.save(new Degree(1l,"Diplôme d\'ingénieur "));
		degreeService.save(new Degree(2l,"licence"));
		degreeService.save(new Degree(3l,"Master professionnel"));
		degreeService.save(new Degree(4l,"Master recherche"));
		degreeService.save(new Degree(5l,"Doctorat"));
		
		/**************************************************************************************/
		User user1=new User();
		user1.setId(1);
		user1.setFirstName("Admin1");
		user1.setLastName("Admin1");
		user1.setUsername("admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user1.setEmail("admin@gmail.com");
		
		//userService.createUser(user1);
		userService.save(user1);
		
		User user2=new User();
		user2.setId(2);
		user2.setFirstName("Moniteur");
		user2.setLastName("Moniteur");
		user2.setUsername("monitor");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("monitor"));
		user2.setEmail("monitor@gmail.com");
		
		//userService.createUser(user2);
		userService.save(user2);
		
		User user3=new User();
		user3.setId(3);
		user3.setFirstName("Moniteur");
		user3.setLastName("Moniteur");
		user3.setUsername("m");
		user3.setPassword(SecurityUtility.passwordEncoder().encode("m"));
		user3.setEmail("hamdi.ali.enicar@gmail.com");
		
		//userService.createUser(user2);
		userService.save(user3);
		
		User user4=new User();
		user4.setId(4);
		user4.setFirstName("Opereator");
		user4.setLastName("Operator");
		user4.setUsername("operator");
		user4.setPassword(SecurityUtility.passwordEncoder().encode("operator"));
		user4.setEmail("operator@gmail.com");
		
		//userService.createUser(user3);
		userService.save(user4);
		
		User user5=new User();
		user5.setId(4);
		user5.setFirstName("hamdi");
		user5.setLastName("ali");
		user5.setUsername("ha");
		user5.setPassword(SecurityUtility.passwordEncoder().encode("ha"));
		user5.setEmail("ha@gmail.com");
		
		//userService.createUser(user5);
		userService.save(user5);
		
		Role role1 =new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_ADMIN");
		
		userService.saveRole(role1);
		
		Role role2 =new Role();
		role2.setRoleId(2);
		role2.setName("ROLE_MONITOR");
		
		userService.saveRole(role2);
		
		Role role3 =new Role();
		role3.setRoleId(3);
		role3.setName("ROLE_LEARNER"); 
		
		userService.saveRole(role3);
		
		userService.addRoleToUser("admin", "ROLE_ADMIN");
		userService.addRoleToUser("monitor", "ROLE_MONITOR");
		userService.addRoleToUser("m", "ROLE_MONITOR");
		//userService.addRoleToUser("operator", "ROLE_OPERATOR");
	}
}
