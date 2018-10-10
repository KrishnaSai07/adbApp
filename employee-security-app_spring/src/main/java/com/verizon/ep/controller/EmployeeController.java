package com.verizon.ep.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.ep.model.Employee;
import com.verizon.ep.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/anon/EmployeeList")
	public ModelAndView handleContactList() {
		return new ModelAndView("Anony", "employee", empService.getAllEmployees());
	}
	
	
	
	@GetMapping("/EmployeeList")
	public ModelAndView handleContactList1() {
		return new ModelAndView("clistPage", "employee", empService.getAllEmployees());
	}
	
	@GetMapping("admin/admin/EmployeeList")
	public ModelAndView handleContactList2() {
		return new ModelAndView("clistPage", "employee", empService.getAllEmployees());
	}
	
	@GetMapping("/user/user/EmployeeList")
	public ModelAndView handleContactList3() {
		return new ModelAndView("clistOnlyPage", "employee", empService.getAllEmployees());
	}

	@GetMapping("/admin/admin/addEmployee")
	public ModelAndView handleNewContact() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addEmployeePage");
		mv.addObject("employee", new Employee());
		return mv;

	}

	@PostMapping("/admin/admin/addEmployee")
	public ModelAndView handleAddContact(@ModelAttribute("employee") @Valid Employee emp,
			BindingResult validationResults) {
		ModelAndView mv = new ModelAndView();

		if (empService.existsByEmpName(emp.getEmpName())) {
			validationResults.rejectValue("empName","error.employee", "Employee already exists");
		}
		if (validationResults.hasErrors()) {
			mv.setViewName("addEmployeePage");
			mv.addObject("employee", emp);
		} 

	    else {
			empService.addEmployee(emp);
			mv.setViewName("redirect:/EmployeeList");

		}
		return mv;

	}
	
	@GetMapping("/findEmployee")
	public String handleSearchContact()
	{
		return "searchPage";
	}
	
	@GetMapping("admin/admin/findEmployee")
	public String handleSearchContactAdmin()
	{
		return "searchPage";
	}
	
	@GetMapping("user/user/findEmployee")
	public String handleSearchContactUser()
	{
		return "searchPage";
	}
	
	@PostMapping("admin/admin/findEmployee")
	public ModelAndView handleDoSearchContact(
			@RequestParam("srhValue") String searchValue,
			@RequestParam("field") String byField
			)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("searchPage");
		mv.addObject("pageTitle","Results for"+byField+"="+searchValue);
		switch(byField)
		{
		case "dept":
			mv.addObject("results",empService.findAllByDept(searchValue));
			break;
		case "name":
			mv.addObject("result",empService.findByEmpName(searchValue));
			break;
		
		}
		
		return mv;
	}
	

	@PostMapping("user/user/findEmployee")
	public ModelAndView handleDoSearchContact1(
			@RequestParam("srhValue") String searchValue,
			@RequestParam("field") String byField
			)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("searchPage");
		mv.addObject("pageTitle","Results for"+byField+"="+searchValue);
		switch(byField)
		{
		case "dept":
			mv.addObject("results",empService.findAllByDept(searchValue));
			break;
		case "name":
			mv.addObject("result",empService.findByEmpName(searchValue));
			break;
		
		}
		
		return mv;
	}

}
