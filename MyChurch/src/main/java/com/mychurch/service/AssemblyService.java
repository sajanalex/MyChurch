package com.mychurch.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mychurch.domain.Assembly;
import com.mychurch.repositories.AssemblyRepository;

@Service
public class AssemblyService {
	
	@Autowired
	private AssemblyRepository assemblyRepo;
	
	public Optional<Assembly> findById(Integer assemblyId) {
		return assemblyRepo.findById(assemblyId);
	}

}
