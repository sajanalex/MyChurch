package com.mychurch.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mychurch.domain.Assembly;
import com.mychurch.repositories.AssemblyRepository;



@Controller
public class DashboardController {

	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String rootView() {
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String viewDashboard() {

		return "dashboard";
	}

}
