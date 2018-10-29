package com.wa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wa.domain.learner.Learner;

/*
@Entity
@Table(name = "level")

public class Level implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LevelPK levelPK;

    private int level;
    private int score;
    //private Date date;
    
    @JsonIgnore
	@ManyToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name = "skill_id",referencedColumnName="skill_id",nullable=false,insertable=false,updatable=false)
	private Skill skill;
    
    @JsonIgnore
	@ManyToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name = "learner_id",referencedColumnName="learner_id",nullable=false,insertable=false,updatable=false)
	private Learner learner;
    
    

    public Level() {
    }

    public Level(LevelPK levelPK) {
        this.levelPK = levelPK;
    }

    public Level(LevelPK levelPK, int level, int score) {
        this.levelPK = levelPK;
        this.level = level;
        this.score = score;
    }

    public Level(long learnerId, long skillId, Date date) {
        this.levelPK = new LevelPK(learnerId, skillId,date);
    }

    public LevelPK getLevelPK() {
        return levelPK;
    }

    public void setLevelPK(LevelPK levelPK) {
        this.levelPK = levelPK;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (levelPK != null ? levelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Level)) {
            return false;
        }
        Level other = (Level) object;
        if ((this.levelPK == null && other.levelPK != null) || (this.levelPK != null && !this.levelPK.equals(other.levelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Level[ levelPK=" + levelPK + " ]";
    }
    
}*/
