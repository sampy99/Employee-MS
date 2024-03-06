package employeems.springboot.controller;

import employeems.springboot.model.Employee;
import employeems.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//this is controller class which is basically connect with the database

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

//    we call here our repository, since it has all the logics of our programme
    @Autowired
    private EmployeeRepository employeeRepository;

//    create rest api for get all the employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

//    create rest api for add or create new employees
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
