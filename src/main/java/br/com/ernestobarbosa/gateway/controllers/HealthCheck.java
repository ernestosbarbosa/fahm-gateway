package br.com.ernestobarbosa.gateway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class HealthCheck {

    @GetMapping("/")
    public ResponseEntity<String> taNoAr() {
        return ResponseEntity.ok("Está no Ar!");
    }

}
