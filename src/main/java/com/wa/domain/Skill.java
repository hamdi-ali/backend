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

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.wa.domain.TrainingSkill;

@Entity
@Table(name="skill")
public class Skill implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="skill_id")
	private Long skillId;
	
	@NotEmpty
	private String name;
	private String description;
	
	
	@OneToMany(mappedBy="skill",fetch=FetchType.LAZY,cascade = CascadeType.ALL )
	private  Set<Formation> formations=new HashSet<Formation>();
	
	@OneToMany(mappedBy="training",fetch=FetchType.LAZY)
	@JsonIgnore
	private  Set<TrainingSkill> trainingSkills=new HashSet<TrainingSkill>();

	public Skill() {
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getName() {
		return name;
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

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	public Set<TrainingSkill> getTrainingSkills() {
		return trainingSkills;
	}

	public void setTrainingSkills(Set<TrainingSkill> trainingSkills) {
		this.trainingSkills = trainingSkills;
	}	
}
