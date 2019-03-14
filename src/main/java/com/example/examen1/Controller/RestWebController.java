package com.example.examen1.Controller;

import com.example.examen1.Model.Cita;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/event")
public class RestWebController {

    //metodo que declara tipo de objeto cita y lo convierte a tipo json regresando los datos al momento de ejecutarse el js
    @GetMapping(value = "/all")
    public String getEvents(@ModelAttribute Cita cita, RedirectAttributes attributes) {

        System.out.println("Entra al metodo REST");
        String jsonMsg = null;
        try {
            List<Cita> events = new ArrayList<Cita>();

            Cita cita1 = new Cita();
            cita1.setNombrePaciente("Juan");
            cita1.setTitle("Paciente: Juan \n"+ "Asunto: Dolor en zona pelvica \n"+"Hora: 3:30");
            cita1.setHora("3:14");
            cita1.setStart("2019-03-14");
            cita1.setEnd("2019-03-15");
            cita1.setDoctor("Robertinski");

            events.add(cita1);




            // FullCalendar
            ObjectMapper mapper = new ObjectMapper();
            jsonMsg =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(events);
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
        return jsonMsg;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

    }

}
