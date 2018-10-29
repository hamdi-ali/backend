package com.wa.domain;

import static javax.persistence.GenerationType.AUTO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="type_formation")
public class TypeFormation {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
	@Column(name="type_formation_id")
	private Long typeFormationId;
	
	@NotEmpty
	private String name;
	
    @OneToMany(mappedBy="typeFormation",fetch=FetchType.LAZY,cascade = CascadeType.ALL )
	@JsonIgnore
	private  Set<Formation> formations=new HashSet<Formation>();

	public TypeFormation() {
		super();
	}

	public TypeFormation(Long typeFormationId, String name) {
		super();
		this.typeFormationId = typeFormationId;
		this.name = name;
		this.formations = formations;
	}

	public Long getTypeFormationId() {
		return typeFormationId;
	}

	public void setTypeFormationId(Long typeFormationId) {
		this.typeFormationId = typeFormationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}
   
}
