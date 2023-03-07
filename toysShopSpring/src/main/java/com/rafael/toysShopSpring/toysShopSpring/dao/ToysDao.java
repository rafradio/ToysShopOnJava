/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.toysShopSpring.toysShopSpring.dao;

import com.rafael.toysShopSpring.toysShopSpring.models.Toy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    public void removeWonToys(HashMap<Integer, Integer> idQuantityMap) {
        for (Map.Entry<Integer, Integer> map: idQuantityMap.entrySet()) {
            System.out.println("ajax data " + map.getValue() + " " + map.getKey());
            jdbcTemplate.update("UPDATE springtoys SET `quantity`=? WHERE (`id` = ?)",
                map.getValue(), map.getKey());
        }
    }
    
    
    
}
