package com.mychurch.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mychurch.domain.Family;
import com.mychurch.domain.Member;
import com.mychurch.repositories.FamilyRepository;
import com.mychurch.repositories.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private FamilyRepository familyRepo;
	

	
	
	public Member addMember(Member member,Family family) {
		
		member.setFamily(family);
		family.getMembers().add(member);
	//	memberRepo.save(member);
		familyRepo.save(family);

						
		return member;
	}
	

	

	
	public Optional<Member> viewMembers(Long familyId) {
		Optional<Member> familyMembers=	memberRepo.findByFamilyId(familyId);
		return familyMembers;
	}

}
