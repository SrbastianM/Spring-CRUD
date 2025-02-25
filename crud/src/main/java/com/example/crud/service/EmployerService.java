package com.example.crud.service;


import com.example.crud.entity.Employer;
import com.example.crud.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {
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

    public void delete(Long id) {
        employerRepository.deleteById(id);
    }
}
