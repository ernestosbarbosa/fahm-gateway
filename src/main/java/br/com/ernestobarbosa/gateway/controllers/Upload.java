package br.com.ernestobarbosa.gateway.controllers;

import br.com.ernestobarbosa.gateway.entity.table.Video;
import br.com.ernestobarbosa.gateway.repository.PacienteRepository;
import br.com.ernestobarbosa.gateway.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static br.com.ernestobarbosa.gateway.config.Constants.UPLOAD_DIR;

@RestController
@RequestMapping
public class Upload {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    private VideoRepository videoRepository;

    @PutMapping("/video/{pacienteId}/{date}/{name:.+}")
    public Video uploadVideo(@PathVariable(value = "pacienteId") Long pacienteId, @PathVariable(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") String date, @PathVariable(value = "name") String name, @RequestParam("file")MultipartFile file) throws IOException, ParseException {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date d = simpleDateFormat.parse(date);

        Video v = new Video();
        v.setDate(d);
        v.setFileName("Paciente ID " + pacienteId + " - " + date + " - " + name);
        System.out.println("Paciente ID " + pacienteId + " - " + date + " - " + name);
        v.setPaciente(pacienteRepository.getOne(pacienteId));
        v.setPath(UPLOAD_DIR + v.getFileName());

        File uploadedFile = new File(UPLOAD_DIR + v.getFileName());
        FileUtils.writeByteArrayToFile(uploadedFile, file.getBytes());

        return videoRepository.save(v);
    }

}
