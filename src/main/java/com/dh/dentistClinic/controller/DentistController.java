package com.dh.dentistClinic.controller;

import com.dh.dentistClinic.entities.Dentist;
import com.dh.dentistClinic.exception.ResourceNotFoundException;
import com.dh.dentistClinic.services.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dentists")
public class DentistController {
    private DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Dentist> searchDentistById(@PathVariable Long Id){
        Optional<Dentist> dentistSearch= dentistService.getDentistById(Id);
        if(dentistSearch.isPresent()){
            return ResponseEntity.ok(dentistSearch.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/find/credential/{credential}")
    public ResponseEntity<Dentist> searchDentistByCredential(@PathVariable String credential){
        Optional<Dentist> dentistFound= dentistService.getDentistById(Long.valueOf(credential));
        if(dentistFound.isPresent()){
            return ResponseEntity.ok(dentistFound.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }
    @PostMapping
    public ResponseEntity<Dentist> registerDentist(@RequestBody Dentist dentist){
        return ResponseEntity.ok(dentistService.saveDentist(dentist));

    }
    @GetMapping
    public ResponseEntity<List<Dentist>> getAllDentists() {
        List<Dentist> dentist = dentistService.getAll();
        return ResponseEntity.ok().body(dentist);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDentist(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Dentist> deleteADentist= dentistService.getDentistById(id);
        if(deleteADentist.isPresent()){
            dentistService.deleteDentists(deleteADentist.get().getId());
            return ResponseEntity.ok("The dentist with ID was deleted: "+deleteADentist.get().toString());
        }else throw new ResourceNotFoundException("There is no ID associated with the query: " + id);
    }
}
