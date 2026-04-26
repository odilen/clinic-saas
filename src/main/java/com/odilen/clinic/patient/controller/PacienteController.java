package com.odilen.clinic.patient.controller;

import com.odilen.clinic.patient.model.Paciente;
import com.odilen.clinic.patient.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> listarTodos(@RequestParam(required = false) Long clinicaId) {
        if (clinicaId != null) {
            return pacienteService.listarPorClinica(clinicaId);
        }
        return pacienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Paciente obtenerPorId(@PathVariable Long id) {
        return pacienteService.obtenerPorId(id);
    }

    @PostMapping
    public Paciente crear(@Valid @RequestBody Paciente paciente) {
        return pacienteService.crear(paciente);
    }

    @PutMapping("/{id}")
    public Paciente actualizar(@PathVariable Long id, @Valid @RequestBody Paciente paciente) {
        return pacienteService.actualizar(id, paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pacienteService.eliminar(id);
    }
}
