package com.odilen.clinic.patient.repository;

import com.odilen.clinic.patient.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findByClinicaId(Long clinicaId);
}