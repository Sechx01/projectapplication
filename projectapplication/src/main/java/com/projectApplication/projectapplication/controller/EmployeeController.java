package com.projectApplication.projectapplication.controller;

import com.projectApplication.projectapplication.exception.ResourceNotFoundException;
import com.projectApplication.projectapplication.model.Employee;
import com.projectApplication.projectapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    //@RestController - creating REST endpoints applies @ResponseBody to each endpoint which causes responses in JSON Format.
    //@RestController allows for the use of @RequestMapping to expose methods and provide configuration for handling request in a RESTFUL manner
    //@RequestMapping - Expose methods to requests at a defined URL
    //@GetMapping - Maps methods to GET requests, which are used to fetch data.
    //@PutMapping - Maps methods to PUT requests, which are used to replace data in its entirety.
    //@PathVariable - Extracts values from the URL the request was sent to
    //@PostMapping - Maps methods to POST requests, which are used to send data
    //@RequestBody - used to convert data from JSON to a java object
    //@DeleteMapping - Maps methods to DELETE request, which are used to remove data.
    //@ResponseEntity - Allows for the creation of HTTP responses using java objects.
@CrossOrigin
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    //findAll() - Returns all the entities as a List.

    // build create employee REST API
    //save() - Persist an entity to the database
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    // build get employee by id REST API
    //findById() - takes in an id and attempts to return a matching entity as an Optional
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    //build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " +id));

        updateEmployee.setEmployeeFirstName(employeeDetails.getEmployeeFirstName());
        updateEmployee.setEmployeeLastName(employeeDetails.getEmployeeLastName());
        updateEmployee.setEmployeeEmailId(employeeDetails.getEmployeeEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    //build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
