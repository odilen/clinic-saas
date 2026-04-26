package com.odilen.clinic.patient.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "clinica_id")
    private Long clinicaId;

    @NotBlank
    @Size(max = 100)
    private String nombre;

    @NotBlank
    @Size(max = 100)
    private String apellido;

    @Size(max = 20)
    private String telefono;

    @Email
    @Size(max = 100)
    private String email;

    private LocalDate fechaNacimiento;

    @Size(max = 500)
    private String observaciones;
}
