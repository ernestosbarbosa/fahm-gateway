package br.com.ernestobarbosa.gateway.controllers;

import br.com.ernestobarbosa.gateway.domain.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static br.com.ernestobarbosa.gateway.config.Constants.UPLOAD_DIR;

@RestController
@RequestMapping
public class Upload {

    @PutMapping("/video")
    public ResponseEntity<Response> uploadVideo(@RequestParam("file")MultipartFile file) throws IOException{

        String fileName = String.valueOf(new Date().getTime());

        File uploadedFile = new File(UPLOAD_DIR + fileName);
        FileUtils.writeByteArrayToFile(uploadedFile, file.getBytes());

        return ResponseEntity.ok(new Response(fileName));
    }

}
