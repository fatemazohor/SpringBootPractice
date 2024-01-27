package com.example.employee.restController;

import com.example.employee.model.Employees;
import com.example.employee.repository.Iemployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeRestController {

    @Autowired
    private Iemployee iemployeeRepo;

    @GetMapping("/emp")
    public List<Employees> allEmp(){
        return iemployeeRepo.findAll();
    }

    @PostMapping("/emp")
    public Employees saveEmp(@RequestBody Employees employees){
        return iemployeeRepo.save(employees);
    }

    @PutMapping("/emp/{id}")
    public ResponseEntity<String> editEmp(@PathVariable("id") int id, @RequestBody Employees emp){
         boolean exist = iemployeeRepo.existsById(id);

         if (exist){
             Employees employees=iemployeeRepo.findById(id).get();
             employees.setEname(emp.getEname());
             employees.setContact(emp.getContact());
             employees.setEmail(emp.getEmail());
             employees.setGender(emp.getGender());
             employees.setAddress(emp.getAddress());
             iemployeeRepo.save(emp);
             return new ResponseEntity<>("Employee Updated", HttpStatus.OK);
         }
         return new ResponseEntity<>("Employee not exist",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/emp/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable("id") int id){
        boolean exist= iemployeeRepo.existsById(id);

        if (exist){
            iemployeeRepo.deleteById(id);

            return new ResponseEntity<>("Employee Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee doesn't exist",HttpStatus.BAD_REQUEST);
    }

}
