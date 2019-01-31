package br.com.ernestobarbosa.gateway.controllers;

import br.com.ernestobarbosa.gateway.entity.table.Paciente;
import br.com.ernestobarbosa.gateway.exception.ResourceNotFoundException;
import br.com.ernestobarbosa.gateway.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @GetMapping("/listar")
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @PutMapping("/criar")
    public Paciente createPaciente(@Valid @RequestBody Paciente p) {
        return pacienteRepository.save(p);
    }

    @GetMapping("/{id}")
    public Paciente getPacienteById(@PathVariable(value = "id") Long pacienteId) {
        return pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente", "id", pacienteId));
    }

    @PostMapping("/atualizar/{id}")
    public Paciente updatePaciente(@PathVariable(value = "id") Long pacienteId,
                           @Valid @RequestBody Paciente pacienteDetails) {

        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente", "id", pacienteId));

        paciente.setName(pacienteDetails.getName());

        Paciente updatedPaciente = pacienteRepository.save(paciente);

        return updatedPaciente;
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable(value = "id") Long pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente", "id", pacienteId));

        pacienteRepository.delete(paciente);

        return ResponseEntity.ok().build();
    }
}
