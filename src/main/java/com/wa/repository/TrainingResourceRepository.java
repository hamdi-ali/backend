package com.wa.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wa.domain.TrainingResource;

@Repository
public interface TrainingResourceRepository extends CrudRepository<TrainingResource,Long>{

	List<TrainingResource> findAll();
	
	TrainingResource findByTitle(String title);

}
