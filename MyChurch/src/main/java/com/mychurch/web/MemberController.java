package com.mychurch.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mychurch.domain.Assembly;
import com.mychurch.domain.Family;
import com.mychurch.domain.Member;
import com.mychurch.repositories.AssemblyRepository;
import com.mychurch.repositories.FamilyRepository;
import com.mychurch.repositories.MemberRepository;
import com.mychurch.service.MemberService;

import net.minidev.json.annotate.JsonIgnore;

@Controller
public class MemberController {
	
	private Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private AssemblyRepository assemblyRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private FamilyRepository familyRepo;
	
	@Autowired
	private MemberService memberService;
	
	
	
	@GetMapping("/family")
	public String viewFamily(ModelMap model,ModelMap modelMem,ModelMap modelFam,Family family,HttpServletResponse response) {
		List<Assembly> assemblies = assemblyRepo.findAll();

		/*
		 * Optional<Member> memberOpt = memberRepo.findByFamilyId(familyId);
		 * Optional<Family> familyOpt = familyRepo.findById(familyId);
		 */
		model.put("assemblies", assemblies);
		if(family.getId()==null)
		modelFam.put("family", new Family());
		modelMem.put("member", new Member());
		
		 		return "family";
	}
	
	@GetMapping("/family/{familyId}")
		public String familyView(@PathVariable Long familyId,ModelMap model,ModelMap modelMem,ModelMap modelFam,Family family, HttpServletResponse response) {
		List<Assembly> assemblies = assemblyRepo.findAll();
		modelFam.put("member", new Member());
		model.put("assemblies", assemblies);
		Optional<Family> familyOpt=	familyRepo.findById(familyId);
		if(familyOpt.isPresent()) {
			modelFam.put("family", familyOpt.get());
			List<Member> familyMembersList=	memberRepo.findByIdWithFamily(familyId);
			
			modelMem.put("familyMembers", familyMembersList);
			
		}
		else return "redirect:/family";

		
		return "family";
		
	}
	
	@PostMapping("/family/{familyId}")
	public String familyMember(@PathVariable Long familyId,@Valid @ModelAttribute("member") Member member,BindingResult bindingResult, ModelMap modelFam, Family family) {

		if(bindingResult.hasErrors()) {
			modelFam.put("member", new Member());
			return "redirect:/family/"+familyId;
		}
		
		Optional<Family> familyOpt=	familyRepo.findById(familyId);
		if(familyOpt.isPresent()) {

			modelFam.put("family", familyOpt.get());
	//		System.out.println(member.getFamily());

			memberRepo.save(member);
			List<Assembly> assemblies = assemblyRepo.findAll();
			modelFam.put("member", new Member());
			modelFam.put("assemblies", assemblies);
			List<Member> familyMembersList=	memberRepo.findByIdWithFamily(familyId);
			
			modelFam.put("familyMembers", familyMembersList);

			
			return "family";
		}
		return "redirect:/family/"+familyId;
	}
	
	@PostMapping("/family")
	public String saveMembers(@Valid @ModelAttribute("member") Member member,BindingResult bindingResult, ModelMap model ,
			@Valid @ModelAttribute("family") Family family, BindingResult result){
//		ModelAndView modelAndView = new ModelAndView();
		if(bindingResult.hasErrors()||result.hasErrors()) {
			if(family.getId()==null) {model.put("family", new Family());}
			return "family";
		}
		else {
		System.out.println(member.getAssembly().getId());
		System.out.println(member);
		System.out.println(family);
	
		familyRepo.save(family);
		memberService.addMember(member, family);
		model.put("family", family);
	
		
		return "redirect:/family/"+family.getId();
		}
		
		
	}
	
	@GetMapping("/member")
	public String viewMember( ModelMap model,Family family) {
		model.put("family", new Family());
		return "member";
	}
	

	
	
	
	@GetMapping("/member/{familyId}")
	public String viewFamilyMembers(@PathVariable Long familyId, ModelMap model,@ModelAttribute Family family, BindingResult result) {
		if(result.hasErrors()) {
			return "member";
		}
		List<Member> familyMembersList=	memberRepo.findByIdWithFamily(familyId);
		model.put("members", familyMembersList);
		
		
//		if(familyMembersOpt.isPresent()) {
//			//model.put("members", familyMembersOpt.get());
//			familyMembersOpt.ifPresent((Member m)->{model.put("members", familyMembersOpt.get());});
//			
//		}
		return "member";
	}
	
	@PostMapping("/member/{familyId}")
	public String setFamilyMembers(@PathVariable Long familyId, ModelMap model) {
		
//		System.out.println(family.getId());
//		System.out.println("entering here");
		System.out.println(familyId);
		
		List<Member> familyMembersList=	memberRepo.findByIdWithFamily(familyId);
		model.put("members", familyMembersList);
		
		return "redirect:/member/"+familyId;
	}

}
