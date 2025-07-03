package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Spring Data JPA will automatically implement CRUD methods.
    // You can add custom query methods here if needed.
}