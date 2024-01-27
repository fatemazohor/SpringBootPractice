package com.example.employee.services;

import com.example.employee.model.Employees;
import com.example.employee.repository.Iemployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements UserDetailsService{


    private Iemployee iemployeeRepo;
    public EmployeeService(Iemployee iemployeeRepo){
        this.iemployeeRepo=iemployeeRepo;
    }

//    public  void saveEmp(Employees employees){
//        repo.save(employees);
//    }
//
//    public List<Employees> getAllEmp(){
//        List<Employees> employeesList=repo.findAll();
//        return employeesList;
//    }
//
//    public void deleteEmp(int id){
//        repo.deleteById(id);
//    }
//
//    public Employees findEmp(int id){
//        Employees emp=repo.findById(id).get();
//        return emp;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employees employees=iemployeeRepo.findByEmail(username);

        return User
                .builder()
                .username(employees.getEmail())
                .password(employees.getPassword())
                .roles(employees.getRoles().stream().map(
                        role -> role
                                .getName())
                        .toArray(String[]::new))
                .build();

    }
}
