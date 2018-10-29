package com.wa.service;

import java.util.List;

import com.wa.domain.TypeFormation;

public interface TypeFormationService {
	
	List<TypeFormation> findAll();
	
	TypeFormation save(TypeFormation typeFormation);
}
