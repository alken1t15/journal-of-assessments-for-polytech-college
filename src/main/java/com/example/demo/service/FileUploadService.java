package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
    public void uploadFile(MultipartFile file) throws IOException {
        file.transferTo(new File("E:\\finalVersion2.0\\src\\main\\webapp\\spravka\\" + file.getOriginalFilename()));
    }

}