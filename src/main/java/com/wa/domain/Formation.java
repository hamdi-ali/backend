package com.wa.domain;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="formation")
public class Formation {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
	@Column(name="formation_id")
	private Long formationId;
	
	@NotEmpty
	private String label;
	private int coefficient;
	private String description;
	private String url;
	private int orderNum;
	private int level;
	private int numberOfHours;
	
	@JoinColumn(name = "type_formation_id", referencedColumnName = "type_formation_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private TypeFormation typeFormation;
	
	@JoinColumn(name = "skill_id", referencedColumnName = "skill_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Skill skill;
	
	@Transient
	private String typeFormationName;

	public Long getFormationId() {
		return formationId;
	}

	public void setFormationId(Long formationId) {
		this.formationId = formationId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public TypeFormation getTypeFormation() {
		return typeFormation;
	}

	public void setTypeFormation(TypeFormation typeFormation) {
		this.typeFormation = typeFormation;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public String getTypeFormationName() {
		return this.typeFormation.getName();
	}

	public void setTypeFormationName(String typeFormationName) {
		this.typeFormationName = typeFormationName;
	}

	public int getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}
	
	

}
