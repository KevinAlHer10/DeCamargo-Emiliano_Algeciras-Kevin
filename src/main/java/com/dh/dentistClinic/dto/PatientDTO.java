package com.dh.dentistClinic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientDTO {
    private String name;
    private String lastName;
    private String address;
    private String identificationNumber;
    private String dischargeDate;
}
