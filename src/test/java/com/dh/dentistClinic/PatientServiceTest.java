package com.dh.dentistClinic;

import com.dh.dentistClinic.entities.Address;
import com.dh.dentistClinic.entities.Patient;
import com.dh.dentistClinic.services.PatientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;
    @Test
    @Order(1)
    public void savePatientTest(){
        Patient patientSaved= new Patient("Pedro","Perez","111111", LocalDate.of(2023,06,28),new Address("Siempre viva",742,"Springfield","USA"),"victorino@digitalhouse.com");
        patientService.savePatient(patientSaved);
        assertEquals(1L,patientSaved.getId());
    }
    @Test
    @Order(2)
    public void searchPatientById(){
        Long idAsearch=1L;
        Optional<Patient> patientSearch= patientService.getPatientById(idAsearch);
        assertNotNull(patientSearch.get());
    }
    @Test
    @Order(3)
    public void getAllPatients(){
        List<Patient> patients= patientService.getAll();
        assertEquals(1,patients.size());
    }
    @Test
    @Order(4)
    public void updatePatient(){
        Patient patientModify= new Patient("Sabina","Montoya","111111", LocalDate.of(2023,06,28),new Address("Siempre viva",742,"Springfield","USA"),"paprika@digitalhouse.com");
        patientService.updatePatient(patientModify);
        Optional<Patient> patientSearch= patientService.getPatientById(1L);
        assertEquals("Victor",patientSearch.get().getName());
    }
    @Test
    @Order(5)
    public void deletePatient(){
        Long idAsearch=1L;
        patientService.deletePatient(idAsearch);
        Optional<Patient> pacienteEliminated= patientService.getPatientById(idAsearch);
        assertFalse(pacienteEliminated.isPresent());
    }
}
