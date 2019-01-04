package br.com.ernestobarbosa.gateway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

import static br.com.ernestobarbosa.gateway.config.Constants.COMPLETED_DIR;

@RestController
@RequestMapping
public class Status {

    @GetMapping("/status/{fileName}")
    public ResponseEntity<String> status(@PathVariable(value = "fileName") String fileName) {
        File file = new File(COMPLETED_DIR + fileName + ".json");
        if(file.exists()){
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

}
