package br.com.ernestobarbosa.gateway.repository;

import br.com.ernestobarbosa.gateway.entity.Videos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideosRepository extends JpaRepository<Videos, Long> {
    Page<Videos> findByPacienteId(Long postId, Pageable pageable);
    Optional<Videos> findByIdAndPacienteId(Long id, Long postId);
}