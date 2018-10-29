package com.wa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;


@Embeddable
public class TrainingSkillPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="training_id")
	private long trainingId;
	
	@Column(name="skill_id")
	private long skillId;
	
	public TrainingSkillPK() {
		super();
	}	

	public TrainingSkillPK(long trainingId, long skillId) {
		super();
		this.skillId = skillId;
		this.trainingId = trainingId;
	}

	public long getSkillId() {
		return skillId;
	}

	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}

	public long getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(long trainingId) {
		this.trainingId = trainingId;
	}
}
