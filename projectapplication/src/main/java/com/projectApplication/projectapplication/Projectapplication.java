package com.projectApplication.projectapplication;

import com.projectApplication.projectapplication.model.Employee;
import com.projectApplication.projectapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Projectapplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Projectapplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setEmployeeFirstName("David");
		employee.setEmployeeLastName("Stan");
		employee.setEmployeeEmailId("davidstan@yahoo.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setEmployeeFirstName("Kelly");
		employee1.setEmployeeLastName("Rowland");
		employee1.setEmployeeEmailId("krolland@yahoo.com");
		employeeRepository.save(employee1);

		Employee employee2 = new Employee();
		employee2.setEmployeeFirstName("Kevin");
		employee2.setEmployeeLastName("Dorang");
		employee2.setEmployeeEmailId("kdorang@yahoo.com");
		employeeRepository.save(employee2);

	}
}
