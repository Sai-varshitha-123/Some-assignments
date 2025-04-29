package com.aits.employeedemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aits.employeedemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
