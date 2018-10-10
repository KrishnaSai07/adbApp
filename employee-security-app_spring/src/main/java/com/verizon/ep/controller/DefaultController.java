package com.verizon.ep.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
	
	@GetMapping({"","/","/home"})
	public ModelAndView showHome()
	{
		ModelAndView mv = new ModelAndView("home");
		
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(! (auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated())
		{
			 mv.addObject("currentUserName",auth.getName());
			 
		}*/
		return mv;
	}
	@GetMapping("admin/login")
	public ModelAndView showLoginPage()
	{
		return new ModelAndView("loginPage");
	}
	
	
	
	@GetMapping("/loginUser")
	public ModelAndView showLoginPage2()
	{
		return new ModelAndView("loginPageUser");
	}
	
	@GetMapping("/admin/home")
	public ModelAndView showLoginPage1()
	{
		return new ModelAndView("index");
	}
	
	@GetMapping("/user/home")
	public ModelAndView showLoginPage5()
	{
		return new ModelAndView("userPage");
	}
	
	@GetMapping("/user/loginUser")
	public ModelAndView showLoginPage3()
	{
		return new ModelAndView("loginPageUser");
	}
	
	
	

}
