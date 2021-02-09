package com.mychurch.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mychurch.domain.Family;
import com.mychurch.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {


	Optional<Member> findByFamilyId(Long familyId);
	
	@Query("select m from Member m where m.family.id=:id")
	List<Member> findByIdWithFamily(Long id);

	

	
//	@Query("insert into ")
//	Member saveFamilyMember(Member member,Family family);


}
