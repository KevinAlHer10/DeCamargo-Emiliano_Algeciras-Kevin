package com.dh.dentistClinic.controller;

import com.dh.dentistClinic.entities.Patient;
import com.dh.dentistClinic.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
 private PatientService patientService;

    @GetMapping("/email/{email}")
    public ResponseEntity<Patient> getPatientByEmail(@PathVariable String email){
        Optional<Patient> patientSearch = patientService.getByEmail(email);
        if(patientSearch.isPresent()){
            return ResponseEntity.ok(patientSearch.get());

        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Patient>> listAll(){
        return ResponseEntity.ok(patientService.getAll());
    }

    @PostMapping
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient){
        Optional<Patient> patientSearch = patientService.getByEmail(patient.getEmail());
        if(patientSearch.isPresent()){
            return ResponseEntity.badRequest().build();

        }else{
            return ResponseEntity.ok(patientService.savePatient(patient));
        }
    }

    @PutMapping
    public ResponseEntity<String> updatePatient(@RequestBody Patient patient){
        Optional<Patient> patientSearch = patientService.getPatientById(patient.getId());
        if(patientSearch.isPresent()){
            patientService.updatePatient(patient);
            return ResponseEntity.ok(+ patient.getId()+" Name:-"+ patient.getName());
                    }
        else{
            return ResponseEntity.badRequest().body( "There is no associated information in the database: "+ patient.getId());

        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long Id){
        Optional<Patient> patientSearch = patientService.getPatientById(Id);
        if (patientSearch.isPresent()){
            return ResponseEntity.ok(patientSearch.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
