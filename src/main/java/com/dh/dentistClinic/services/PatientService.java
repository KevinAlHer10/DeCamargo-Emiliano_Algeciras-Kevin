package com.dh.dentistClinic.services;

import com.dh.dentistClinic.entities.Patient;
import com.dh.dentistClinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
   private PatientRepository patientRepository;
   public Patient savePatient (Patient patient){
       return patientRepository.save(patient);
   }

   public Optional<Patient> getPatientById(Long Id){ return patientRepository.findById(Id); }

    public Optional<Patient> getByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public Optional<Patient> getByLastnameAndName(String lastname, String name) {
        return patientRepository.findByLastNameAndName(lastname, name);
    }

    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }

    public void deletePatient(Long Id) {
        patientRepository.deleteById(Id);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }


}
