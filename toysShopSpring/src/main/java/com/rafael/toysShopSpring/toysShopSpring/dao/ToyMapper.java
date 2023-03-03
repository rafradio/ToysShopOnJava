/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.toysShopSpring.toysShopSpring.dao;

import com.rafael.toysShopSpring.toysShopSpring.models.Toy;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class ToyMapper implements RowMapper<Toy> {
    
    @Override
    public Toy mapRow(ResultSet rs, int rowNum) throws SQLException {
        Toy toy = new Toy();
        toy.setId(rs.getInt("id"));
        toy.setName(rs.getString("name"));
        toy.setQuantity(rs.getInt("quantity"));
        toy.setProbability(rs.getFloat("probability"));
        toy.setImageSrc(rs.getString("imageSrc"));
        return toy;
    }
}
