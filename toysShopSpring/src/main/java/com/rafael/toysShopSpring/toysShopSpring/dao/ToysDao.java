/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.toysShopSpring.toysShopSpring.dao;

import com.rafael.toysShopSpring.toysShopSpring.models.Toy;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ToysDao {
    private List<Toy> toys = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ToysDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Toy> main(){
        return jdbcTemplate.query("select * from springtoys", new ToyMapper());
    }
    
    public void saveToy(Toy toy) {
        jdbcTemplate.update("insert into springtoys (name, quantity, probability, imageSrc) values(?,?,?,?)",
                toy.getName(), toy.getQuantity(), toy.getProbability(), toy.getImageSrc());
    }
    
    
    
}
