package employeems.springboot.controller;

import employeems.springboot.exception.ResourceNotFoundException;
import employeems.springboot.model.Employee;
import employeems.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id!"));
        return ResponseEntity.ok(employee);
    }

//    update employee rest api
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id!"));

        employee.setEmp_name(employeeDetails.getEmp_name());
        employee.setEmp_email(employeeDetails.getEmp_email());
        employee.setEmp_city(employeeDetails.getEmp_city());
        employee.setEmp_dob(employeeDetails.getEmp_dob());

        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

//    delete employee rest api

    @DeleteMapping ("/employees")
    public ResponseEntity <Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id!"));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
