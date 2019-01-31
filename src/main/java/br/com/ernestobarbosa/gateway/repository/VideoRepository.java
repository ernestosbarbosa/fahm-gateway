package br.com.ernestobarbosa.gateway.repository;

import br.com.ernestobarbosa.gateway.entity.table.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    Page<Video> findByPacienteId(Long postId, Pageable pageable);
    Optional<Video> findByIdAndPacienteId(Long id, Long postId);
}