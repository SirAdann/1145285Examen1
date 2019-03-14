package com.example.examen1.Controller;

import com.example.examen1.Model.Cita;
import com.example.examen1.Model.Doctor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//Controlador que renderiza contenido estatico
@Controller
public class HomeController {

    //Controlador que llama la pagina principal
    @GetMapping("/")
    public String home(){

        return "index";
    }

    //Controlador que llama la pagina del formulario de citas
    @GetMapping("/cita")
    public String List(Model modelo, @ModelAttribute Cita cita){

        //Creacion de objetos de tipo doctor
        Doctor doctor1 = new Doctor();
        Doctor doctor2 = new Doctor();
        Doctor doctor3 = new Doctor();
        Doctor doctor4 = new Doctor();
        Doctor doctor5 = new Doctor();
        //Declaracion e instancia de una lista de tipo doctor
        List<Doctor> doc = new ArrayList<Doctor>();


    //Asignacion de atributos a los doctores
        doctor1.setNombres("Juan Armando ");
        doctor1.setApellido("Sanchez Urquides");
        doctor1.setTitulo("Neurólogo");

        doctor2.setNombres("Ramiro Armando");
        doctor2.setApellido("Quiñonez Guzmán");
        doctor2.setTitulo("Cardiólogo");

        doctor3.setNombres("Juan Pablo ");
        doctor3.setApellido("Gómez Lora");
        doctor3.setTitulo("Oftalmólogo");

        doctor4.setNombres("Luis Roberto ");
        doctor4.setApellido("Rodriguéz Meza");
        doctor4.setTitulo("Otorrinolaringólogo");

        doctor5.setNombres("Jorge");
        doctor5.setApellido("Alvaréz Lara");
        doctor5.setTitulo("Traumatólogo");

        //Se agregan los doctores a la lista
        doc.add(doctor1);
        doc.add(doctor2);
        doc.add(doctor3);
        doc.add(doctor4);
        doc.add(doctor5);

        System.out.println(doc.toString());

        //Se agrega a model la lista de doctores para el formulario
        modelo.addAttribute("listadocs",doc);






        return "cita";
    }

    //controlador para recibir los datos del formulario en el objeto cita
    @PostMapping("/add")
    public String add(@ModelAttribute Cita cita, RedirectAttributes attributes){

        System.out.println(cita.toString());




        return"Calendario";
    }

    //controladore que llama el calendario
    @GetMapping("/cal")
    public  String calendario(){


        return("Calendario");
    }






    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

    }
}
