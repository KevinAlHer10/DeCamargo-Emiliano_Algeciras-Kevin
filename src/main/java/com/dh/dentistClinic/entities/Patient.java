package com.dh.dentistClinic.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String identificationNumber;
    @Column
    private LocalDate dischargeDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Shift> shifts= new HashSet<>();

    public Patient(){
    }
    public Patient(String name, String lastName, String identificationNumber, LocalDate dischargeDate, Address address, String email) {
        this.name = name;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.dischargeDate = dischargeDate;
        this.address = address;
        this.email = email;
    }
}