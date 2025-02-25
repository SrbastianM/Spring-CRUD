package com.example.crud.controller;

import com.example.crud.entity.Employer;
import com.example.crud.service.EmployerService;
import jakarta.validation.Valid;
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


    // This method saves in a list all the employers in the DB and return a 200 (ok) status will not have problem
    @GetMapping
    public ResponseEntity<List<Employer>> getAll() {
        try {
            List<Employer> employers = employerService.getEmployers();
            return ResponseEntity.ok(employers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    //  Return from the uri "api/v1/employerId" the record found with the pass id
    //  Note: The editor transform my if statement to this functional return line:38
    @GetMapping("/{employerId}")
    public ResponseEntity<Employer> getEmployer(@PathVariable("employerId") Long employerId) {
        try {
            Optional<Employer> employer = employerService.getEmployer(employerId);
            return employer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //    Return the creation for a user using the Entity data Struct
    @PostMapping
    public ResponseEntity<String> saveEmployer(@Valid @RequestBody Employer employer) {
        try {
            employerService.saveEmployer(employer);
            return ResponseEntity.status(HttpStatus.CREATED).body("Record successfully created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating the employer: " + e.getMessage());
        }
    }

    //    Delete a user using the id -> watch out the getId() method uses the same logic
    @DeleteMapping("/{employerId}")
    public ResponseEntity<String> deleteEmployer(@PathVariable("employerId") Long employerId) {
        try {
            employerService.deleteEmployer(employerId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Record successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting a employer : " + e.getMessage());
        }
    }

    // Update a user using the id -> To valid if the JSON format is good, add the @NotBlank and @Email notation in the entity to use it
    // use the @Valid notation. This method returns 200 ok status if the update is successfully.
    @PutMapping("/{employerId}")
    public ResponseEntity<String> updateEmployer(@Valid @RequestBody Employer employer, @PathVariable("employerId") Long employerId) {
        try {
            employerService.updateEmployer(employer, employerId);
            return ResponseEntity.ok("Successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
