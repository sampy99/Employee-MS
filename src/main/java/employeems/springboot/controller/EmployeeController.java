package employeems.springboot.controller;

import employeems.springboot.model.Employee;
import employeems.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//this is controller class which is basically connect with the database

@CrossOrigin(origins = "http://localhost:3000")
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
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

//    get employee by id using rest api
    @GetMapping("/employees/id")
    public Employee getEmployeeById(long id){

    }
}
