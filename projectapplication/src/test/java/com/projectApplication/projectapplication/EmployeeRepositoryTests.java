package com.projectApplication.projectapplication;

import com.projectApplication.projectapplication.model.Employee;
import com.projectApplication.projectapplication.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

    //AssertJ supports very readable assertions

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    //JUnit test for saveEmployee
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest(){

        Employee employee = Employee.builder()
                .employeeFirstName("Tiger")
                .employeeLastName("Woods")
                .employeeEmailId("tigerwoods@yahoo.com")
                .build();

        employeeRepository.save(employee);

        Assertions.assertThat(employee.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getEmployeeTest(){

        Employee employee = employeeRepository.findById(1l).get();

        Assertions.assertThat(employee.getId()).isEqualTo(1l);
    }

    @Test
    @Order(3)
    public void getListOfEmployeeTest() {

        List<Employee> employees = employeeRepository.findAll();

        Assertions.assertThat(employees.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEmployeeTest() {

        Employee employee = employeeRepository.findById(1l).get();

        employee.setEmployeeEmailId("pthomas247@yahoo.com");

        Employee employeeUpdated = employeeRepository.save(employee);

        Assertions.assertThat(employeeUpdated.getEmployeeEmailId()).isEqualTo("pthomas247@yahoo.com");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){

        Employee employee = employeeRepository.findById(1L).get();

        employeeRepository.delete(employee);

        Employee employee1 = null;

        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());

        if(optionalEmployee.isPresent()){
            employee1 = optionalEmployee.get();
        }

        Assertions.assertThat(employee1).isNull();

    }
}
