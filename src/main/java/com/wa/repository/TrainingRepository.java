package com.wa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wa.domain.Training;

public interface TrainingRepository extends CrudRepository<Training,Long>{
	
	List<Training> findAll();
	
	Training findByName(String name);

}
