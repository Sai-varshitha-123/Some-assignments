package com.aits.employeedemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.aits.employeedemo.entity.Employee;
import com.aits.employeedemo.repo.EmployeeRepository;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepoTest {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	void testSaveAndFindById()
	{
		Employee emp=new Employee();
		emp.setName("raghu");
		emp.setSalary(10000);
		
		Employee emp1=employeeRepository.save(emp);
		
		Assertions.assertEquals("raghu",emp1.getName());
		Assertions.assertEquals(10000,emp1.getSalary());
	}

}
