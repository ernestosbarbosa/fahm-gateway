package br.com.ernestobarbosa.gateway.controllers;

import br.com.ernestobarbosa.gateway.message.Sender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static br.com.ernestobarbosa.gateway.config.Constants.START_QUEUE;

@RestController
@RequestMapping
public class Run {

    @PostMapping("/run/{fileName:.+}")
    public ResponseEntity<String> executar(@PathVariable(value = "fileName") String fileName) throws IOException, TimeoutException {
        new Sender(START_QUEUE).sendMessage(fileName);
        return ResponseEntity.status(201).build();
    }

}
