package com.wa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.wa.domain.Training;
import com.wa.domain.TrainingSkill;
import com.wa.domain.TrainingSkillPK;
import com.wa.repository.TrainingRepository;
import com.wa.repository.TrainingSkillRepository;
import com.wa.service.TrainingService;

@Transactional
@Service
public class TrainingServiceImpl implements TrainingService{
	
	@Autowired
	private TrainingRepository trainingRepository;
	
	@Autowired
	private TrainingSkillRepository  trainingSkillRepository;

	@Override
	public List<Training> findAll() {
		return this.trainingRepository.findAll();
	}

	@Override
	public Training save(Training training) {
		Training localTraining =trainingRepository.save(new Training(training.getName(), training.getDescription(), training.getDuration(),training.getJob()));
		training.setTrainingId(localTraining.getTrainingId());
		training.getTrainingSkills().forEach(ts->{
			if(ts.getSkill()!=null){
			ts.setId(new TrainingSkillPK(localTraining.getTrainingId(),ts.getSkill().getSkillId()));
			trainingSkillRepository.save(ts);
			}
		});
		return trainingRepository.save(localTraining);
	}
	
	@Override
	public Training update(Training training) {
		
		Training localTraining=trainingRepository.findOne(training.getTrainingId());
		localTraining.getTrainingSkills().clear();
		training.getTrainingSkills().forEach(ts->{
			if(ts.getSkill()!=null){
			ts.setId(new TrainingSkillPK(localTraining.getTrainingId(),ts.getSkill().getSkillId()));
			addSkillToTraining(localTraining.getTrainingId(),ts.getSkill().getSkillId(),ts);
			}
		});
		return trainingRepository.save(training);
	}
	
	void addSkillToTraining(Long idTraining,Long idSkill,TrainingSkill ts){
		ts.setId(new TrainingSkillPK(idTraining,idSkill));
		trainingSkillRepository.save(ts);
	}
	
	@Override
	public void removeOne(Long id) {
		this.trainingRepository.delete(id);
	}

	@Override
	public Training findByName(String name) {
		return this.trainingRepository.findByName(name);
	}
	
	@Override
	public Training findOne(Long id) {
		return this.trainingRepository.findOne(id);
	}

}
