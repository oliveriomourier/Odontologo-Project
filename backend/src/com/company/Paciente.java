package com.company;

import java.time.LocalDate;

public class Paciente {
    private Integer id;
    private String nombre;
    private String apellido;
    private LocalDate nacimiento;
    private Integer dni;

    public Paciente(String nombre, String apellido, LocalDate nacimiento, Integer dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.dni = dni;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public Integer getDni() {
        return dni;
    }
}
