package com.aits.employeedemo;
 
 
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.Optional;
 

 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.aits.employeedemo.entity.Employee;
import com.aits.employeedemo.exception.EmployeeNotFound;
import com.aits.employeedemo.exception.HikeIsMore;
import com.aits.employeedemo.repo.EmployeeRepository;
import com.aits.employeedemo.service.EmployeeService;
 
class EmployeeServiceTest {
 
    @InjectMocks
    private EmployeeService employeeService;
 
    @Mock
    private EmployeeRepository employeeRepository;
 
    @BeforeEach
    void setUp() {
       MockitoAnnotations.openMocks(this);
    }
 
    @Test
    public void testInsertEmployee() {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("John");
        emp.setSalary(3000);
 
      when(employeeRepository.save(emp)).thenReturn(emp);

      assertDoesNotThrow(() -> employeeService.insert(emp));
    }
 
    @Test
    void testUpdateSalarySuccess() {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("John");
        emp.setSalary(3000);
 
       when(employeeRepository.findById(1)).thenReturn(Optional.of(emp));
        when(employeeRepository.save(emp)).thenReturn(emp);
 
        Employee updatedEmp = employeeService.updateSalary(500, 1);
 
        
        
        Assertions.assertEquals(3500, updatedEmp.getSalary());
        assertEquals("John", updatedEmp.getName());
        assertEquals(1, updatedEmp.getId());
    }
 
    @Test
    void testUpdateSalary_EmployeeNotFound() {
        when(employeeRepository.findById(1)).thenReturn(Optional.empty());
 
        Exception ex = assertThrows(EmployeeNotFound.class, () -> employeeService.updateSalary(500, 1));
        assertEquals("emp not found with id", ex.getMessage());
    }
 
    @Test
    void testUpdateSalary_HikeMoreThanAllowed() {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("John");
        emp.setSalary(3000);
 
        when(employeeRepository.findById(1)).thenReturn(Optional.of(emp));
 
        Exception ex = assertThrows(HikeIsMore.class, () -> employeeService.updateSalary(1500, 1));
        assertEquals("Hike is very high", ex.getMessage());
    }
    
    
    
}