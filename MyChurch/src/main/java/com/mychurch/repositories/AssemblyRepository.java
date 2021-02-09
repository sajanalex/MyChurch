package com.mychurch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mychurch.domain.Assembly;
@Repository
public interface AssemblyRepository extends JpaRepository<Assembly, Integer> {

}
