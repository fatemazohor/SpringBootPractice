package com.example.EmailSend.restcontroller;

import com.example.EmailSend.model.Department;
import com.example.EmailSend.model.Employee;
import com.example.EmailSend.repository.IDepartmentRepository;
import com.example.EmailSend.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeRestController {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IDepartmentRepository departmentRepo;

    @GetMapping("")
    public List<Employee> allEmployee(){

       return employeeRepository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

        String dName=employee.getDepartment().getDName();
        Department department = departmentRepo.findBydName(dName);

        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(savedEmployee);

    }

}
