package com.wa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wa.domain.TypeFormation;

public interface TypeFormationRepository extends CrudRepository<TypeFormation, Long>{
	public List<TypeFormation> findAll();
}
