package br.com.ernestobarbosa.gateway.controllers;


import br.com.ernestobarbosa.gateway.entity.Videos;
import br.com.ernestobarbosa.gateway.repository.VideosRepository;
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
    private VideosRepository videosRepository;

    @GetMapping("/{pacienteId}/videos")
    public Page<Videos> getAllVideosByPacienteId(@PathVariable(value = "postId") Long pacienteId,
                                                 Pageable pageable) {
        return videosRepository.findByPacienteId(pacienteId, pageable);
    }

}
