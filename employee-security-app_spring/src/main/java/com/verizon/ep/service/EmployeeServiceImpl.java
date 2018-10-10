package com.verizon.ep.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.ep.dao.EmployeeRepository;
import com.verizon.ep.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Employee getEmployeeById(long empId) {
		// TODO Auto-generated method stub
          Employee employee=null;
		
		/*if(contactRepository.existsById(contactId))
		{
			contact=contactRepository.findById(contactId).get();
		}*/
		Optional<Employee> optEmployee = employeeRepository.findById(empId);
		if(optEmployee.isPresent())
		{
			employee = optEmployee.get();
		}
		
			return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public boolean deleteEmployee(long empId) {
		// TODO Auto-generated method stub
		boolean isDeleted=false;
		if(employeeRepository.existsById(empId))
		{
		employeeRepository.deleteById(empId);
		isDeleted= true;
		}
		return isDeleted;
	}

	@Override
	public boolean existsByEmpName(String empName) {
		// TODO Auto-generated method stub
		return employeeRepository.existsByEmpName(empName);
	}

	@Override
	public Employee findByEmpName(String empName) {
		// TODO Auto-generated method stub
		System.out.println(employeeRepository.findByEmpName(empName));
		return employeeRepository.findByEmpName(empName);
	}

	@Override
	public Employee findAllByDept(String dept) {
		// TODO Auto-generated method stub
		System.out.println(employeeRepository.findAllByDept(dept));
		return employeeRepository.findAllByDept(dept);
	}
	
	
	

}
