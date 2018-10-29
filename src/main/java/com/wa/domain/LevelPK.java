package com.wa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/*
@Embeddable
public class LevelPK implements Serializable {

	/*private static final long serialVersionUID = 1L;
	@Column(name = "learner_id")
    private long learnerId;
	
    @Column(name = "skill_id")
    private long skillId;
    private Date date;

    public LevelPK() {
    }

    public LevelPK(long learnerId, long skillId, Date date) {
        this.learnerId = learnerId;
        this.skillId = skillId;
        this.date=date;
    }

    public long getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(long learnerId) {
        this.learnerId = learnerId;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (int) learnerId;
        hash += (int) skillId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LevelPK)) {
            return false;
        }
        LevelPK other = (LevelPK) object;
        if (this.learnerId != other.learnerId) {
            return false;
        }
        if (this.skillId != other.skillId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LevelPK[ learnerId=" + learnerId + ", skillId=" + skillId + " ]";
    }
    
}*/
