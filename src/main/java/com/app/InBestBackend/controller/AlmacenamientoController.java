package com.app.InBestBackend.controller;
import com.app.InBestBackend.domain.service.AlmacenamientoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/media")
@AllArgsConstructor
public class AlmacenamientoController {
    private final AlmacenamientoService almacenamientoService;
    private final HttpServletRequest request;

    @PostMapping("upload")
    public Map<String, String> uploadFile(@RequestParam("file")MultipartFile multipartFile){
        String path = almacenamientoService.guardar(multipartFile);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String url = ServletUriComponentsBuilder
                .fromOriginHeader(host)
                .path("/media/")
                .path(path)
                .toString();
        return Map.of("url", url);
    }

    @GetMapping("{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename){
        try {
            Resource file = almacenamientoService.cargar(filename);
            String contentType = Files.probeContentType(file.getFile().toPath());
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_TYPE, contentType)
                    .body(file);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
