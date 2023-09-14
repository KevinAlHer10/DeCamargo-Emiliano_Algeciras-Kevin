package com.dh.dentistClinic.services;

import com.dh.dentistClinic.dto.ShiftDTO;
import com.dh.dentistClinic.entities.Dentist;
import com.dh.dentistClinic.entities.Patient;
import com.dh.dentistClinic.entities.Shift;
import com.dh.dentistClinic.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShiftService {
    @Autowired
    private ShiftRepository shiftRepository;
    public List<ShiftDTO> shiftList(){
        List<Shift> shiftsFound= shiftRepository.findAll();
        List<ShiftDTO> answer= new ArrayList<>();
        for (Shift shift: shiftsFound) {
            answer.add(shiftAShiftDTO(shift));
        }
        return answer;
    }
    public Optional<ShiftDTO> searchShift(Long id){
        Optional<Shift> shiftsSearch= shiftRepository.findById(id);
        if(shiftsSearch.isPresent()){
            return Optional.of(shiftAShiftDTO(shiftsSearch.get()));
        }else{
            return Optional.empty();
        }
    }
    public void deleteShift(Long id){
        shiftRepository.deleteById(id);
    }
    public void updateShift(ShiftDTO shiftDTO){
        shiftRepository.save(shiftDTOaShift(shiftDTO));
    }
    public ShiftDTO saveShift(ShiftDTO shiftDTO){
        Shift shiftSave= shiftRepository.save(shiftDTOaShift(shiftDTO));
        return shiftAShiftDTO(shiftSave);
    }
    public ShiftDTO shiftAShiftDTO(Shift shift){
        ShiftDTO convertShift= new ShiftDTO();
        convertShift.setId(shift.getId());
        convertShift.setPatientId(shift.getPatient().getId());
        convertShift.setDentistId(shift.getDentist().getId());
        convertShift.setDate(shift.getDate());
        return convertShift;
    }
    public Shift shiftDTOaShift(ShiftDTO shiftDTO){
        Shift answer= new Shift();
        Dentist dentist = new Dentist();
        Patient patient= new Patient();
        dentist.setId(shiftDTO.getDentistId());
        patient.setId(shiftDTO.getPatientId());
        answer.setDate(shiftDTO.getDate());
        answer.setId(shiftDTO.getId());
        answer.setDentist(dentist);
        answer.setPatient(patient);
        return answer;
    }
}