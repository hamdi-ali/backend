package com.wa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wa.domain.Skill;
import com.wa.repository.FormationRepository;
import com.wa.repository.SkillRepository;
import com.wa.service.SkillService;

@Transactional
@Service
public class SkillServiceImpl implements SkillService{
	
	@Autowired 
	private SkillRepository skillRepository;
	
	@Autowired 
	private FormationRepository formationRepository;
	
	@Override
	public List<Skill> findAll() {
		return  skillRepository.findAll();
	}

	@Override
	public Skill save(Skill skill) {
		
		Skill localSkill = new Skill();
		localSkill.setName(skill.getName());
		localSkill.setDescription(skill.getDescription());
		localSkill=skillRepository.save(localSkill);
		skill.setSkillId(localSkill.getSkillId());
		System.out.println(skill.getFormations().size());
		skill.getFormations().forEach(formation->{
			formation.setSkill(skill);
		});
		return skillRepository.save(skill);
	}

	@Override
	public void removeOne(Long id) {
		skillRepository.delete(id);
	}
	
	@Override
	public Skill findByName(String name){
		return skillRepository.findByName(name);
	}

	@Override
	public Skill findOne(Long id) {
		return skillRepository.findOne(id);
	}
	

}
