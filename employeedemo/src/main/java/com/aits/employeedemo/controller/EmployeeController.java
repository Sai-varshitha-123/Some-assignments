package com.aits.employeedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.invoker.HttpServiceArgumentResolver;

import com.aits.employeedemo.entity.Employee;
import com.aits.employeedemo.service.EmployeeService;

@RestController
public class EmployeeController {
	// this class should communicate to the service class
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> insert(@RequestBody Employee emp)
	{
		//send the object to service layer
		Employee emp1=employeeService.insert(emp);
		return new ResponseEntity<>(emp,HttpStatus.CREATED);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateSal(@RequestParam double hike, @PathVariable int id)
	{
		Employee emp=employeeService.updateSalary(hike,id);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees()
	{
		return new ResponseEntity<>(employeeService.getEmployees(),HttpStatus.ACCEPTED);
	}
}
