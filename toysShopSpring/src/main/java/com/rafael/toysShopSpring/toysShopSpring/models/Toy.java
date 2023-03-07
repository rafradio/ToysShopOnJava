/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.toysShopSpring.toysShopSpring.models;

public class Toy {
    private int id;
    private String name;
    private int quantity;
    private float probability;
    private String imageSrc;

    public Toy() {
    }

    public Toy(int id, String name, int quantity, float probability, String imageSrc) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.probability = probability;
        this.imageSrc = imageSrc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append(this.getId())
                .append(", ")
                .append(this.getName())
                .append(", ")
                .append(this.getQuantity())
                .append(", ")
                .append(this.getProbability())
                .append(", ")
                .append(this.getImageSrc());
        return sb.toString();
    }
    
    
    
}
