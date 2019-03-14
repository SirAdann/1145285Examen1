package com.example.examen1.Model;

import lombok.Data;

import java.util.Date;

@Data
public class Cita {

    private String nombrePaciente;
    private String title;
    private String hora;
    private String start;
    private String end;
    private String doctor;
}
