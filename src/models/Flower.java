/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;
import utilities.Formatter;

/**
 *
 * @author Administrator
 */
public class Flower {
    private String id ;
    private String description ;
    private Date importDate ;
    private double price ;
    private String category ;
    private final String format ;
    
    public Flower(String id, String description, Date importDate, double price, String category , String format) {
        this.id = id;
        this.description = description;
        this.importDate = importDate;
        this.price = price;
        this.category = category;
        this.format = format ;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public void display(){
        System.out.println(this.toString());
    }
            
    @Override
    public String toString(){
        String msg = String.format("%s,%s,%s,%s,%f",
                id , description , Formatter.toDateString(importDate, format) , price , category) ;
        return msg ;
    }
}
