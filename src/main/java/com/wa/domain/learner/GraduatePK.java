package com.wa.domain.learner;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GraduatePK implements Serializable {

   
    @Column(name = "institute_id")
    private long instituteId;
   
    @Column(name = "degree_id")
    private long degreeId;
    
    public GraduatePK() {
    }

    public GraduatePK(long instituteId, long degreeId) {
        this.instituteId = instituteId;
        this.degreeId = degreeId;
    }

    public long getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(long instituteId) {
        this.instituteId = instituteId;
    }

    public long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(long degreeId) {
        this.degreeId = degreeId;
    }

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (int) instituteId;
        hash += (int) degreeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GraduatePK)) {
            return false;
        }
        GraduatePK other = (GraduatePK) object;
      
        if (this.instituteId != other.instituteId) {
            return false;
        }
        if (this.degreeId != other.degreeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GraduatePK[ instituteId=" + instituteId + ", degreeId=" + degreeId + " ]";
    }
    
}
