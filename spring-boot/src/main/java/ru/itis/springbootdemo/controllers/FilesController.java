package ru.itis.springbootdemo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.services.FileStorageService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FilesController {

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/files/upload")
    public String getFilesUploadPage(){
        return "file_upload_page";
    }

    @PostMapping("/files")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file){
        String filePath = fileStorageService.saveFile(file);
        return ResponseEntity.ok()
                .body(filePath);
    }

    @GetMapping("/files/{file-name:.+}")
    public void getFile(@PathVariable("file-name") String fileName, HttpServletResponse response){
        fileStorageService.writeFileToResponse(fileName, response);
    }
}
