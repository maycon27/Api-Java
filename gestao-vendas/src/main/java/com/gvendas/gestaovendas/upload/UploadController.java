package com.gvendas.gestaovendas.upload;

import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.servico.FirebaseStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private FirebaseStorageService uploadService;

    @PostMapping
    public ResponseEntity upload(@RequestBody UploadInput uploadInput) throws IOException {

        String url = uploadService.upload(uploadInput);

        return ResponseEntity.ok(new UploadOutput(url));
    }
}
