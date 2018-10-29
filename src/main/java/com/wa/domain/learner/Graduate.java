package com.wa.domain.learner;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "graduate")
public class Graduate implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="graduate_id")
	private Long graduateId;
	
	@ManyToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name = "institute_id",referencedColumnName="institute_id")
	private Institute institute;

	@ManyToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name = "degree_id",referencedColumnName="degree_id")
	private Degree degree;
	
	@OneToMany(mappedBy="graduate",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private  Set<Learner> learners=new HashSet<Learner>();
	
	@Column(nullable=false)
	private int year_graduate;
	
    public Graduate() {
    	super();
    }

	public Graduate(Long graduateId, Institute institute, Degree degree, Set<Learner> learners, int year_graduate) {
		super();
		this.graduateId = graduateId;
		this.institute = institute;
		this.degree = degree;
		this.learners = learners;
		this.year_graduate = year_graduate;
	}



	public Graduate(Long graduateId, Degree degree, Institute institute, int year_graduate) {
		super();
		this.graduateId = graduateId;
		this.degree = degree;
		this.institute = institute;
		this.year_graduate = year_graduate;
	}



	public Long getGraduateId() {
		return graduateId;
	}


	public void setGraduateId(Long graduateId) {
		this.graduateId = graduateId;
	}


	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

	public int getYear_graduate() {
		return year_graduate;
	}

	public void setYear_graduate(int year_graduate) {
		this.year_graduate = year_graduate;
	}
	
}
