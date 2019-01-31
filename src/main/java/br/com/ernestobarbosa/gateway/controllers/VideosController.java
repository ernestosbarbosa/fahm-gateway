package br.com.ernestobarbosa.gateway.controllers;


import br.com.ernestobarbosa.gateway.entity.table.Video;
import br.com.ernestobarbosa.gateway.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
public class VideosController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/{pacienteId}")
    public Page<Video> getAllVideosByPacienteId(@PathVariable(value = "pacienteId") Long pacienteId,
                                                Pageable pageable) {
        return videoRepository.findByPacienteId(pacienteId, pageable);
    }

}
