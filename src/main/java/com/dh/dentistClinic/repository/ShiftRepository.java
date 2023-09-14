package com.dh.dentistClinic.repository;

import com.dh.dentistClinic.entities.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
}
