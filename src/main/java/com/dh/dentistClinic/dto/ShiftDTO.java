package com.dh.dentistClinic.dto;

import com.dh.dentistClinic.entities.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ShiftDTO {
    private Long Id;
    private LocalDate date;
    private Long patientId;
    private Long dentistId;


}
