package com.dh.dentistClinic.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dentists")
@Getter
@Setter
public class Dentist {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true,nullable = false)
    private String credential;
    @Column
    private String name;
    @Column
    private String lastName;
    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private Set<Shift> turns= new HashSet<>();

    public Dentist(){

    }

    public Dentist(String credential, String name, String lastName, Set<Shift> turns) {
        this.credential = credential;
        this.name = name;
        this.lastName = lastName;
        this.turns = turns;
    }
}
