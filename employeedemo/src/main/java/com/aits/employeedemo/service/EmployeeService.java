package com.aits.employeedemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.employeedemo.entity.Employee;
import com.aits.employeedemo.exception.EmployeeNotFound;
import com.aits.employeedemo.exception.HikeIsMore;
import com.aits.employeedemo.repo.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	public Employee insert(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp);
	}
	@Transactional
	public Employee updateSalary(double hike,int id) throws EmployeeNotFound,HikeIsMore{
		// TODO Auto-generated method stub
		//exceptions 
		//id might not exist
		// i might increase the salary greater than 1000
		Employee emp=employeeRepository.findById(id).orElseThrow(
				()->new EmployeeNotFound("emp not found with id")
				);
		if(hike>1000)
		{
			throw(new HikeIsMore("Hike is very high"));
		}
		
		emp.setSalary(emp.getSalary()+hike);
		employeeRepository.save(emp);
		return emp;
	}
	
	public List<Employee> getEmployees()
	{
		return employeeRepository.findAll();
	}
	

	//business logic
	
}
