package com.odilen.clinic.patient.service;

import com.odilen.clinic.patient.model.Paciente;
import com.odilen.clinic.patient.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public List<Paciente> listarPorClinica(Long clinicaId) {
        return pacienteRepository.findByClinicaId(clinicaId);
    }

    public Paciente obtenerPorId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + id));
    }

    public Paciente crear(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente actualizar(Long id, Paciente pacienteActualizado) {
        Paciente paciente = obtenerPorId(id);

        paciente.setClinicaId(pacienteActualizado.getClinicaId());
        paciente.setNombre(pacienteActualizado.getNombre());
        paciente.setApellido(pacienteActualizado.getApellido());
        paciente.setTelefono(pacienteActualizado.getTelefono());
        paciente.setEmail(pacienteActualizado.getEmail());
        paciente.setFechaNacimiento(pacienteActualizado.getFechaNacimiento());
        paciente.setObservaciones(pacienteActualizado.getObservaciones());

        return pacienteRepository.save(paciente);
    }

    public void eliminar(Long id) {
        Paciente paciente = obtenerPorId(id);
        pacienteRepository.delete(paciente);
    }
}
