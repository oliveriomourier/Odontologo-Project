package com.odontologo.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private int id;
    private String nombre;
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "odontologo_id", referencedColumnName = "id")
    private Odontologo odontologo;

    public Paciente(String nombre, String apellido, Odontologo odontologo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.odontologo = odontologo;
    }
}
