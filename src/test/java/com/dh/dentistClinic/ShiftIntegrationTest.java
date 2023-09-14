package com.dh.dentistClinic;

import com.dh.dentistClinic.dto.ShiftDTO;
import com.dh.dentistClinic.entities.Address;
import com.dh.dentistClinic.entities.Dentist;
import com.dh.dentistClinic.entities.Patient;
import com.dh.dentistClinic.entities.Shift;
import com.dh.dentistClinic.services.DentistService;
import com.dh.dentistClinic.services.PatientService;
import com.dh.dentistClinic.services.ShiftService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class ShiftIntegrationTest {
        @Autowired
        private MockMvc mockMvc;
        @Autowired
        private PatientService patientService;
        @Autowired
        private DentistService dentistService;
        @Autowired
        private ShiftService shiftService;
        private void upData(){
            Patient addPatient= patientService.savePatient(new Patient("Valerie","Martinez","122222", LocalDate.of(2023,06,28),new Address("viva",742,"Springfield","USA"),"valerie@digitalhouse.com"));
            Dentist addDentist= dentistService.saveDentist(new Dentist("MP20","Max","Dientes"));
            ShiftDTO addShift= shiftService.saveShift(new ShiftDTO(addPatient,addDentist,LocalDate.of(2023,04,20)));

        }
        @Test
        public void listarTodosLosTurnos() throws Exception{
            upData();
            MvcResult answer= mockMvc.perform(MockMvcRequestBuilders.get("/shifts").accept(MediaType.APPLICATION_JSON))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();
            assertFalse(answer.getResponse().getContentAsString().isEmpty());
        }
    }

}
