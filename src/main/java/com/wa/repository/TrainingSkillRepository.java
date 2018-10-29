package com.wa.repository;

import org.springframework.data.repository.CrudRepository;

import com.wa.domain.TrainingSkill;
import com.wa.domain.TrainingSkillPK;

public interface TrainingSkillRepository  extends CrudRepository<TrainingSkill,TrainingSkillPK>{

}
