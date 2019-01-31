package br.com.ernestobarbosa.gateway.controllers;

import br.com.ernestobarbosa.gateway.entity.status.Exist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

import static br.com.ernestobarbosa.gateway.config.Constants.COMPLETED_DIR;

@RestController
@RequestMapping
public class Status {

    @GetMapping("/status/{fileName:.+}")
    public Exist status(@PathVariable(value = "fileName") String fileName) {

        File file = new File(COMPLETED_DIR + fileName + "-data.json");

        if(file.exists()){
            return new Exist(fileName, true);
        }

        return new Exist(fileName, false);
    }

}
