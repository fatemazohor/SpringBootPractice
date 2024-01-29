package com.example.EmailSend.restcontroller;

import com.example.EmailSend.model.Department;
import com.example.EmailSend.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin("http://localhost:4200/")
public class DepartmentRestController {
    @Autowired
    IDepartmentRepository departmentRepo;


    @GetMapping("/department")
    public List<Department> allDep(){

        return departmentRepo.findAll();
    }
    @PostMapping("/department")
    public  Department saveDepartment(@RequestBody Department department){

        return departmentRepo.save(department);
    }

    @DeleteMapping("/department/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        boolean exist=departmentRepo.existsById(id);
        if(exist){
            departmentRepo.deleteById(id);
            return  new ResponseEntity<>("Department is deleted", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Department is not exist", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/department/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Department department){
        boolean exist=departmentRepo.existsById(id);

        if(exist){
            Department department1=departmentRepo.getById(id);
            department1.setDName(department.getDName());
            department1.setId(id);
            departmentRepo.save(department);
            return  new ResponseEntity<>("Department is Updated", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Department is not Exist", HttpStatus.BAD_REQUEST);


    }



}
