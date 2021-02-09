package com.mychurch.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mychurch.domain.Family;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Integer> {

public	Optional<Family> findById(Long familyId);


}
