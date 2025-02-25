package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employer")
public class Employer {
//    Adding values for the employer entity -> this values where set in the DB
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employerId;

    private String firstName;
    private String lastName;

    @Column(name = "email_address", unique = true)
    private String email;

}
