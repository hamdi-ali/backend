package com.wa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wa.domain.learner.Graduate;
import com.wa.domain.learner.GraduatePK;
import com.wa.domain.learner.Learner;
import com.wa.repository.DegreeRepository;
import com.wa.repository.GraduateRepository;
import com.wa.repository.GroupRepository;
import com.wa.repository.InstituteRepository;
import com.wa.repository.LearnerRepository;
import com.wa.repository.RoleRepository;
import com.wa.service.LearnerService;
import com.wa.service.UserService;

@Transactional
@Service
public class LearnerServiceImpl implements LearnerService{
	
	@Autowired
	private LearnerRepository learnerRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired 
	private UserService userService;

	@Override
	public List<Learner> findAll() {
		return learnerRepository.findAll();
	}
	
	@Override
	public Learner findOne(Long learnerId){
		return learnerRepository.findOne(learnerId);
	}

	@Override
	public Learner save(Learner learner) {
		learner.setUsername(learner.getLastName()+learner.getFirstName());
		learner.initRoles();
		learner=learnerRepository.save(learner);
		userService.addRoleToUser(learner.getUsername(),"ROLE_LEARNER");
		return learner;
	}

	@Override
	public void removeOne(Long id) {
		learnerRepository.delete(id);
	}

	@Override
	public Learner findByCin(long cin) {
		return learnerRepository.findByCin(cin);
	}

}
