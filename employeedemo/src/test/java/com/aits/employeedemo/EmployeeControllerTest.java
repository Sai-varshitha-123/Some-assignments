package com.aits.employeedemo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aits.employeedemo.controller.EmployeeController;
import com.aits.employeedemo.entity.Employee;
import com.aits.employeedemo.service.EmployeeService;

public class EmployeeControllerTest {
	@InjectMocks
	EmployeeController employeeController;
	
	@Mock
	EmployeeService employeeService;
	
	@BeforeEach
	void setUp()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testInsert()
	{
		Employee emp=new Employee();
		emp.setName("chandu");
		emp.setSalary(10000);
		
		Mockito.when(employeeService.insert(emp)).thenReturn(ResponseEntity<Employee>(emp,HttpStatus.OK));
		assertDoesNotThrow(()->employeeService.insert(emp));
		
	}
	
}
