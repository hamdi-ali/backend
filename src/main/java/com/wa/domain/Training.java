package com.wa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="training")
public class Training implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="training_id", nullable = false, updatable=false)
	private Long trainingId;
	
	@NotEmpty
	private String name;
	private String description;
	private int duration;
	private String job;

	@OneToMany(fetch = FetchType.LAZY,mappedBy="training",cascade = CascadeType.ALL,orphanRemoval = true)
	private  Set<TrainingSkill> trainingSkills=new HashSet<TrainingSkill>();

	public Training(){
		super();
	}
	
	public Training(String name, String description, int duration, String job) {
		super();
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.job = job;
		this.trainingSkills = new HashSet<TrainingSkill>();
	}

	public Training(Long trainingId, String name, String description, int duration, String job,
			Set<TrainingSkill> trainingSkills) {
		super();
		this.trainingId = trainingId;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.job = job;
		this.trainingSkills = trainingSkills;
	}

	public String getName() {
		return name;
	}
	public Long getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Long trainingId) {
		this.trainingId = trainingId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Set<TrainingSkill> getTrainingSkills() {
		return trainingSkills;
	}
	public void setTrainingSkills(Set<TrainingSkill> trainingSkills) {
		this.trainingSkills = trainingSkills;
	}
	
	@Override
	public Training clone(){
		Training training=new Training();
		training.setTrainingId(trainingId);
		training.setName(name);
		training.setDuration(duration);
		training.setDescription(description);
		training.setJob(job);
		training.getTrainingSkills().addAll(trainingSkills);
		return training;
	}

}
