package com.dh.dentistClinic.services;

import com.dh.dentistClinic.entities.Dentist;
import com.dh.dentistClinic.entities.Patient;
import com.dh.dentistClinic.repository.DentistRepository;
import com.dh.dentistClinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {
    @Autowired
    private DentistRepository dentistRepository;

    public Dentist saveDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    public Optional<Dentist> getDentistById(Long Id) {
        return dentistRepository.findById(Id);
    }

    public Optional<Dentist> getByLastnameAndName(String credential) {
        return dentistRepository.findByCredential(credential);
    }

    public void updateDentist(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    public void deleteDentists(Long Id) {
        dentistRepository.deleteById(Id);
    }

    public List<Dentist> getAll() {
        return dentistRepository.findAll();

    }
}