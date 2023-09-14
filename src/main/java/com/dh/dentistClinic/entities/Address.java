package com.dh.dentistClinic.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String street;
    @Column
    private Integer number;
    @Column
    private String location;
    @Column
    private String province;

    public Address(){}

    public Address(String street, Integer number, String location, String province) {
        this.street = street;
        this.number = number;
        this.location = location;
        this.province = province;
    }
}
