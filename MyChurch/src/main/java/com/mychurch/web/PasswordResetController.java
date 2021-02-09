package com.mychurch.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mychurch.security.constraint.FieldMatchValidator;
import com.mychurch.web.dto.PasswordResetDto;

@Controller
@RequestMapping("/reset-password")
public class PasswordResetController {
	
//	@Autowired
//	@Qualifier("fieldMatchValidator")
//	private Validator validator;
//	
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}
	
	@ModelAttribute("passwordResetForm")
	public PasswordResetDto passwordReset() {
		return new PasswordResetDto();
	}
	
	@GetMapping
	public String showPasswordReset(Model model) {
		return "reset-password";
	}
	
	@PostMapping
	public String handlePasswordReset(@ModelAttribute("passwordResetForm")
									  @Valid PasswordResetDto form,BindingResult result) {
		if (result.hasErrors()){
			return "reset-password";
		}

		return "redirect:/login?resetSuccess";
	}

}
