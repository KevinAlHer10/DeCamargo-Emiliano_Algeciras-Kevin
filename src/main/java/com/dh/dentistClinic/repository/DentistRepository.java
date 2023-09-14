package com.dh.dentistClinic.repository;

import com.dh.dentistClinic.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
    Optional<Dentist> findByCredential(String credential);
}
