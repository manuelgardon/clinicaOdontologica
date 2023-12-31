package com.dh.clinicaOdontologica.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "paciente")
public class Paciente {

    @Id
    @SequenceGenerator(name = "pacientes_id", sequenceName = "pacientes_id", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private String apellido;
    private String domicilio;
    private Integer dni;
    private LocalDate fechaAlta;

    public Paciente() {}

    @Autowired
    public Paciente(String nombre, String apellido, String domicilio, Integer dni, LocalDate fechaAlta, Turno turno) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
        this.turno = turno;
    }

    @OneToOne(mappedBy = "paciente")
    private Turno turno;

}
