package com.demo.springboot.cruddemo.dao;

import com.demo.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// we have passed the Entity Type and Primary Key, so spring will give crud implementation
// no need for DAO impl class
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
