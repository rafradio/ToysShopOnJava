/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.toysShopSpring.toysShopSpring.controllers;

import com.rafael.toysShopSpring.toysShopSpring.dao.ToysDao;
import com.rafael.toysShopSpring.toysShopSpring.models.Toy;
import com.rafael.toysShopSpring.toysShopSpring.workWithCard.WorkWithCard;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToysWebController {
    private WorkWithCard workWithCard;
    private ToysDao toysDao;
    
    @Autowired
    public ToysWebController(WorkWithCard workWithCard, ToysDao toysDao) {
        this.workWithCard = workWithCard;
        this.toysDao = toysDao;
    }
    
    @GetMapping("/main")
    public String mainPage(Model model) {
        List<Toy> toys = this.toysDao.main();
        model.addAttribute("toys", toys);
        System.out.println("размер карточек " + toys.size() + "\n");
        return "toys/main";
    }
    
    @PostMapping("/main")
    public String takeQuery(HttpServletRequest request) {
//        String data = request.getParameter("length");
//        
//        this.workWithCard.parseQuery(request);
        this.toysDao.removeWonToys(this.workWithCard.parseQuery(request));
        return "redirect:/main";
    }
    
    @GetMapping("/new")
    public String newPage(Model model) {
        model.addAttribute("toy", new Toy());
        return "toys/new";
    }
    
    @PostMapping("/new")
    public String takePicture(HttpServletRequest request, @ModelAttribute("toy") Toy toy) throws IOException, ServletException {
        String imgSrc = this.workWithCard.savePictureOnServer(request.getPart("fileToUpload"));
//        String imgSrc = request.getPart("fileToUpload").getSubmittedFileName();
        toy.setImageSrc(imgSrc);
        System.out.println("путь до картинки " + toy.getImageSrc() + "\n");
        this.toysDao.saveToy(toy);
        return "redirect:/new";
    }
    
    
}
