package com.wa.domain;

import java.io.Serializable;
import java.util.Date; 
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wa.domain.learner.Learner;


@Entity
@Table(name = "`group`")
public class Group implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id", nullable = false)
	private Long groupId;
	
	private String name;
	private Date entryDate;
	private Date exitDate;
	
	@OneToMany(mappedBy="group",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private  Set<Learner> learners=new HashSet<Learner>();

	public Group() {
	}

	public Group(Long groupId) {
	  this.groupId = groupId;
	}

	public Group(Long groupId, String name) {
	  this.groupId = groupId;
	  this.name = name;
	}

	public Long getGroupId() {
	   return groupId;
	}

	public void setGroupId(Long groupId) {
	   this.groupId = groupId;
	}

	public String getName() {
	   return name;
	}

	public void setName(String name) {
	   this.name = name;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	public Set<Learner> getLearners() {
		return learners;
	}

	public void setLearners(Set<Learner> learners) {
		this.learners = learners;
	}

	@Override
	public int hashCode() {
	    int hash = 0;
	    hash += (groupId != null ? groupId.hashCode() : 0);
	    return hash;
	}

	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof Class)) {
	        return false;
	    }
	    Group other = (Group) object;
	    if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
	        return false;
	    }
	     return true;
	}

	    @Override
	    public String toString() {
	        return "entities.Class[ classId=" + groupId + " ]";
	    }
}
