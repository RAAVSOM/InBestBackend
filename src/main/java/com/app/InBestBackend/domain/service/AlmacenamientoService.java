package com.app.InBestBackend.domain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class AlmacenamientoService {
    @Value("${media.location}")
    private String mediaLocation;
    private Path rootlocation;

    public String guardar(MultipartFile file){
        try{
            if(file.isEmpty()){
                throw new RuntimeException("Error de subida");
            }
            String filename = file.getOriginalFilename();
            Path destinationFile = rootlocation.resolve(Paths.get(filename))
                    .normalize().toAbsolutePath();
            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
            return filename;
        }catch (IOException e){
            throw new RuntimeException("fallo", e);
        }
    }

    public Resource cargar(String filename){
        try{
            Path file = rootlocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new RuntimeException("no se pudo leer el archivo");
            }
        }catch (MalformedURLException e){
            throw  new RuntimeException("error", e);
        }
    }
}
