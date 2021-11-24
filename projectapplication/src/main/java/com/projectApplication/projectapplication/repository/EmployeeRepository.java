package com.projectApplication.projectapplication.repository;

import com.projectApplication.projectapplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //@JpaRepository all the basic CRUD functionality are inherited
    //Create a custom methods

}
