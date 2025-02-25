package com.example.crud.service;


import com.example.crud.entity.Employer;
import com.example.crud.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// This service use the auto-injection of the repository. In this particular case access to the DB and
// all the CRUD methods.
@Service
public class EmployerService {
    // Auto-injection of the repository
    @Autowired
    EmployerRepository employerRepository;

    public List<Employer> getEmployers() {
        return employerRepository.findAll();
    }

    public Optional<Employer> getEmployer(Long employerId) {
        return employerRepository.findById(employerId);
    }

    public void saveEmployer(Employer employer) {
        employerRepository.save(employer);
    }

    public void updateEmployer(Employer employer, Long employerID) {
       Employer existingEmployer = employerRepository.findById(employerID).orElseThrow(() -> new RuntimeException("Employer not found" + employerID));

       existingEmployer.setFirstName(employer.getFirstName());
       existingEmployer.setLastName(employer.getLastName());
       existingEmployer.setEmail(employer.getEmail());

       employerRepository.save(existingEmployer);
    }

    public void deleteEmployer(Long employerId) {
        Employer existingEmployer = employerRepository.findById(employerId)
                .orElseThrow(() -> new RuntimeException("Employer not found: " + employerId));
        employerRepository.delete(existingEmployer);
    }
}
