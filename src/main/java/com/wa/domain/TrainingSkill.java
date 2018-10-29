package com.wa.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="training_skill")
public class TrainingSkill implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TrainingSkillPK id;
	
	private int expectedLevel;
	private int requiredLevel;
	private int coefficient;
	private int orderNum;
	
	@JsonIgnore
	@ManyToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name = "training_id",referencedColumnName="training_id",nullable=false,insertable=false,updatable=false)
	private Training training;
	
	@ManyToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name = "skill_id",referencedColumnName="skill_id",nullable=false,insertable=false,updatable=false)
	private Skill skill;
	

	public TrainingSkill() {
		super();
	}

	public TrainingSkillPK getId() {
		return id;
	}

	public void setId(TrainingSkillPK id) {
		this.id = id;
	}

	public int getExpectedLevel() {
		return expectedLevel;
	}

	public void setExpectedLevel(int expectedLevel) {
		this.expectedLevel = expectedLevel;
	}

	public int getRequiredLevel() {
		return requiredLevel;
	}

	public void setRequiredLevel(int requiredLevel) {
		this.requiredLevel = requiredLevel;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	} 
	
	
	
}
