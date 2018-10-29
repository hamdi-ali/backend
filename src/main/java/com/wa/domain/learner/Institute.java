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
@Table(name = "institute")
public class Institute implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "institute_id")
    private Long instituteId;
    
    @NotEmpty
    private String name;
    
    @OneToMany(mappedBy="institute",fetch=FetchType.LAZY)
  	@JsonIgnore
  	private  Set<Graduate> graduates=new HashSet<Graduate>();

    public Institute() {
    }

    public Institute(Long instituteId) {
        this.instituteId = instituteId;
    }

    public Institute(Long instituteId, String name) {
        this.instituteId = instituteId;
        this.name = name;
    }

    public Long getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Long instituteId) {
        this.instituteId = instituteId;
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
        hash += (instituteId != null ? instituteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institute)) {
            return false;
        }
        Institute other = (Institute) object;
        if ((this.instituteId == null && other.instituteId != null) || (this.instituteId != null && !this.instituteId.equals(other.instituteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Institute[ instituteId=" + instituteId + " ]";
    }
    
}
