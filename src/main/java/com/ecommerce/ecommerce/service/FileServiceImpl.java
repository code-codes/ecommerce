package com.ecommerce.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;


@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile image) throws IOException {
        //file name of current / original file
        String originalFileName = image.getOriginalFilename();

        //generate a unique file name
        String randomId = UUID.randomUUID().toString();
        String newName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));
        String imagePath = path + File.separator + newName;

        //check if path exisit and create
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        Files.copy(image.getInputStream(), Paths.get(imagePath));
        //
        return newName;
    }
}
