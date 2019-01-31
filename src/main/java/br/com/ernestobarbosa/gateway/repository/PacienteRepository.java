package br.com.ernestobarbosa.gateway.repository;

import br.com.ernestobarbosa.gateway.entity.table.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}