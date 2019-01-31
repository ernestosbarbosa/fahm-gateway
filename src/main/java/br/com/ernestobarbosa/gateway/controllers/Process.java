package br.com.ernestobarbosa.gateway.controllers;

import br.com.ernestobarbosa.gateway.entity.process.Clip;
import br.com.ernestobarbosa.gateway.entity.process.Quadro;
import br.com.ernestobarbosa.gateway.entity.table.Paciente;
import br.com.ernestobarbosa.gateway.entity.table.Video;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static br.com.ernestobarbosa.gateway.config.Constants.COMPLETED_DIR;


@RestController
@RequestMapping
public class Process {

    @PostMapping("/process")
    public ArrayList<Clip> data(@Valid @RequestBody Video[] videos) throws IOException {

        ArrayList<Clip> c = new ArrayList<>();

        for(Video v: videos){
            File f = new File(COMPLETED_DIR + v.getFileName() + "-data.json");
            if(f.exists()){
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
                InputStream is = new FileInputStream(COMPLETED_DIR + v.getFileName() + "-data.json");
                Clip processed = mapper.readValue(is, Clip.class);
                c.add(processed);
            }
        }

        return c;
    }

}
