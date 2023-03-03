/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.toysShopSpring.toysShopSpring.workWithCard;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import org.springframework.stereotype.Component;

@Component
public class WorkWithCard {
    
    public String savePictureOnServer(Part filePart) throws IOException, ServletException {
        InputStream fileInputStream = filePart.getInputStream();
        String pathToServer = "http://localhost:8080/img/";
        String pathToFile = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\toysShopSpring\\src\\main\\resources\\static\\img\\";
        File fileToSave = new File(pathToFile + filePart.getSubmittedFileName());
        Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Новый файл на сервере: " + filePart.getSubmittedFileName() );
        return pathToServer + filePart.getSubmittedFileName();
    }
}
