package com.demo.springboot.cruddemo.EmployeeService;

import com.demo.springboot.cruddemo.dao.EmployeeRepository;
import com.demo.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// EmployeeServiceImpl implements EmployeeService meaning it must provide the actual implementations for
// the methods defined in the EmployeeService interface
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    // constructor
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id" + theId);
        }
        return theEmployee;
    }
    // It calls employeeRepository.save(theEmployee), which is provided by JpaRepository
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }
    // since we are modifying the db hence use Transactional

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
