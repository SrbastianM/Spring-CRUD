package com.example.crud.controller;

import com.example.crud.entity.Employer;
import com.example.crud.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/employers")
public class EmployerController {
    @Autowired
    private EmployerService employerService;


    @GetMapping
    public List<Employer> getAll() {
        return employerService.getEmployers();
    }


    //  Return from the uri "api/v1/employerId" the record found with the pass id
    @GetMapping("/{employerId}")
    public Optional<Employer> getId(@PathVariable("employerId") Long employerId) {
        return employerService.getEmployer(employerId);
    }

    //    Return the creation for a user using the Entity data Struct
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Employer employer) {
        try {
            employerService.saveEmployer(employer);
            return ResponseEntity.status(HttpStatus.CREATED).body("Record successfully created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating the employer: " + e.getMessage());
        }
    }

    //    Delete a user using the id -> watch out the getId() method uses the same logic
    @DeleteMapping("/{employerId}")
    public ResponseEntity<String> delete(@PathVariable("employerId") Long employerId) {
        try {
            employerService.delete(employerId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Record successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting the record: " + e.getMessage());
        }
    }
}
