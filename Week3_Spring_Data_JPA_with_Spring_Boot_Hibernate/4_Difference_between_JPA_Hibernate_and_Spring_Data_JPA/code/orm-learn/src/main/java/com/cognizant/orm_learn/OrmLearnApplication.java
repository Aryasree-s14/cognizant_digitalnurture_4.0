package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    public static void main(String[] args) {
        // Start the Spring application
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        // Get the EmployeeService bean from the Spring context
        EmployeeService employeeService = context.getBean(EmployeeService.class);

        // Create a new employee object
        Employee employee = new Employee("John", "Doe", 65000.0);

        // Use the service to save the employee to the database
        Employee savedEmployee = employeeService.addEmployee(employee);

        System.out.println("--- Employee Saved ---");
        System.out.println(savedEmployee);
    }
}