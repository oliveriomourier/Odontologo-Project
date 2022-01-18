package com.odontologo.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "odontologos")
@Getter @Setter
public class Odontologo {
    @Id
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private int id;
    private String nombre;
    private String apellido;
    private Integer matricula;

    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private Set<Paciente> pacientes;

    public Odontologo(String nombre, String apellido, Integer matricula, Set<Paciente> pacientes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.pacientes = pacientes;
    }
}

