package com.dh.dentistClinic.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "turnos")
@Getter
@Setter
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "dentist-id", referencedColumnName = "id")
    private Dentist dentist;
    @Column
    private LocalDate date;

    public Shift(){
    }

    public Shift(Patient patient, Dentist dentist, LocalDate date) {
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }
}
