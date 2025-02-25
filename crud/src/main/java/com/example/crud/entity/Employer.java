package com.example.crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "employer")
public class Employer {
    //    Adding values for the employer entity -> this values where set in the DB
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employerId;

    @NotBlank(message = "First Name cannot be empty")
    private String firstName;
    @NotBlank(message = "Last Name cannot be empty")
    private String lastName;

    @Email(message = "Invalid email format")
    @Column(name = "email_address", unique = true)
    private String email;

}
