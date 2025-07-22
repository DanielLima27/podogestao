package com.podogestao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "cpf", length = 15, nullable = false, unique = true)
    private String cpf;

    @Column(name = "phone", length = 15, nullable = false)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "marital_status", length = 20, nullable = false)
    private String maritalStatus;

    @Column(name = "occupation", length = 50)
    private String occupation;

    @Column(name = "address", length = 150)
    private String address;

    @Column(name = "neighborhood", length = 50)
    private String neighborhood;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "zip_code", length = 10)
    private String zipCode;


}