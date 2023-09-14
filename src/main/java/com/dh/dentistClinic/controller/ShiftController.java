package com.dh.dentistClinic.controller;

import com.dh.dentistClinic.dto.ShiftDTO;
import com.dh.dentistClinic.entities.Shift;
import com.dh.dentistClinic.services.DentistService;
import com.dh.dentistClinic.services.PatientService;
import com.dh.dentistClinic.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shifts")
public class ShiftController {
    private ShiftService shiftService;
    private PatientService patientService;
    private DentistService dentistService;

    @Autowired
    public ShiftController(ShiftService shiftService, PatientService patientService, DentistService dentistService) {
        this.shiftService = shiftService;
        this.patientService = patientService;
        this.dentistService = dentistService;
    }
    @GetMapping
    public ResponseEntity<List<ShiftDTO>> searchShifts(){
        return ResponseEntity.ok(shiftService.shiftList());
    }
    @PostMapping
    public ResponseEntity<ShiftDTO> registerShift(@RequestBody Shift shift) {

        DentistService dentistService= new DentistService();
        PatientService patientService= new PatientService();

        if(dentistService.getDentistById(shift.getDentist().getId())!=null&&patientService.getPatientById(shift.getPatient().getId())!=null){
            ShiftDTO shiftDTO = shiftService.shiftAShiftDTO(shift);
            return ResponseEntity.ok(shiftService.saveShift(shiftDTO));
        }
        else{
            return ResponseEntity.badRequest().build();
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<ShiftDTO> searchShift(@PathVariable Long id){
        Optional<ShiftDTO> shiftSearch = shiftService.searchShift(id);
        if(shiftSearch.isPresent()){
           return ResponseEntity.ok(shiftSearch.get());
        }
        else{
           return ResponseEntity.notFound().build(); //404
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShift(@PathVariable Long id){
        Optional<ShiftDTO> deleteShift = shiftService.searchShift(id);
        if(deleteShift.isPresent()){
            shiftService.deleteShift(id);
            return ResponseEntity.ok("\n" +
                    "Successfully deleted shift with ID: "+id);
        }
        else {
            return ResponseEntity.badRequest().body("Requested shift not found "+id);
        }
    }
    @PutMapping()
    public ResponseEntity<String> updateShift(@RequestBody Shift shift){
        Optional<ShiftDTO> updateShift= shiftService.searchShift(shift.getId());
        if(updateShift.isPresent()){
           if(dentistService.getDentistById(shift.getDentist().getId())!=null&&patientService.getPatientById(shift.getPatient().getId())!=null){
                shiftService.updateShift(shiftService.shiftAShiftDTO(shift));
                return ResponseEntity.ok("Shift ID successfully updated: "+shift.getId());
            }else{
                return ResponseEntity.badRequest().body("Cannot update shift with ID: "+shift.getId()+" There is no associated patient or dentist");
            }

        }
        else{
            return ResponseEntity.badRequest().body("The requested shift does not exist");
        }
    }

}

