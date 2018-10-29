package com.wa.domain.learner;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wa.domain.Group;
import com.wa.domain.Training;
import com.wa.domain.User;

@Entity
@DiscriminatorValue("learner")
public class Learner extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date birthDate;
    private Date entryDate;
    private Date exitDate;
    private long phone;
    private String address;
    private int totalScore;
    private int ranking;
    
    @JsonIgnore
	@Transient
	private MultipartFile image;
    
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Group group;
    
    @JoinColumn(name = "training_id", referencedColumnName = "training_id")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Training training;
   
    
    @JoinColumn(name = "graduate_id", referencedColumnName = "graduate_id")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Graduate graduate;
   
    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "learner",cascade = CascadeType.ALL)
    private Set<Evaluation> evaluations;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "learner",cascade = CascadeType.ALL)
    private Collection<Level> levels;*/
    @JsonIgnore
    //@Transient
    private String trainingName;
    @JsonIgnore
    //@Transient
    private String groupName;
    
    public Learner() {
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    @JsonIgnore
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}
	@JsonIgnore
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
    
	
	
	
	/*
	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public Collection<Level> getLevels() {
		return levels;
	}

	public void setLevels(Collection<Level> levels) {
		this.levels = levels;
	}*/

	@JsonIgnore
	public String getTrainingName() {
		return training.getName();
	}

	public Graduate getGraduate() {
		return graduate;
	}

	public void setGraduate(Graduate graduate) {
		this.graduate = graduate;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	@JsonIgnore
	public String getGroupName() {
		return group.getName();
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
    
}
