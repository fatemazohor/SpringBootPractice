package com.fatema.jwtSecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/demo")
    public ResponseEntity<String> demo(){
        return ResponseEntity.ok("Hello from secured URL");
    }
    @GetMapping("/admin")
    public ResponseEntity<String> adminOnly(){
        return ResponseEntity.ok("Hello from Admin only URL");
    }
}
