package com.wa.domain;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="training_resource")
public class TrainingResource implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
	@Column(name="training_resource_id")
	private Long trainingResourceId;
	
	@NotEmpty
	private String title;
	private int coefficient;
	private String description;
	private String url;
	private String type;

	public TrainingResource() {
	}

	public TrainingResource(Long id, String title, int coefficient, String description, String url, String type) {
		super();
		this.trainingResourceId = id;
		this.title = title;
		this.coefficient = coefficient;
		this.description = description;
		this.url = url;
		this.type = type;
	}

	public Long getTrainingResourceId() {
		return trainingResourceId;
	}

	public void setTrainingResourceId(Long trainingResourceId) {
		this.trainingResourceId = trainingResourceId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setPonderation(int coefficient) {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
