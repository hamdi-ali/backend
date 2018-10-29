package com.wa.domain.learner;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

@Entity
@Table(name = "degree")
public class Degree implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "degree_id")
    private Long degreeId;
    
    @NotEmpty
    private String name;
    
    @OneToMany(mappedBy="degree",fetch=FetchType.LAZY)
	@JsonIgnore
	private  Set<Graduate> graduates=new HashSet<Graduate>();

    public Degree() {
    }

    public Degree(Long degreeId) {
        this.degreeId = degreeId;
    }
    
    public Degree( String name) {
        this.name = name;
    }

    public Degree(Long degreeId, String name) {
        this.degreeId = degreeId;
        this.name = name;
    }

    public Long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Long degreeId) {
        this.degreeId = degreeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Graduate> getGraduates() {
		return graduates;
	}

	public void setGraduates(Set<Graduate> graduates) {
		this.graduates = graduates;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (degreeId != null ? degreeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Degree)) {
            return false;
        }
        Degree other = (Degree) object;
        if ((this.degreeId == null && other.degreeId != null) || (this.degreeId != null && !this.degreeId.equals(other.degreeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Degree[ degreeId=" + degreeId + " ]";
    }
    
}