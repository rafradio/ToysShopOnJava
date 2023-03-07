/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.toysShopSpring.toysShopSpring.workWithCard;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
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
    
    public HashMap<Integer, Integer> parseQuery(HttpServletRequest request) {
        HashMap<Integer, Integer> idQuantityMap = new HashMap<>();
        int length = Integer.parseInt(request.getParameter("length"));
        for (int i = 1; i < length+1; i++) {
            String key1 = "id" + i;
            String key2 = "quantity" + i;
            idQuantityMap.put(Integer.valueOf(request.getParameter(key1)), 
                            Integer.valueOf(request.getParameter(key2)));
        }
//        System.out.println("ajax data " + idQuantityMap.get(1));
        return idQuantityMap;
    }
}
