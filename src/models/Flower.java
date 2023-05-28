package models;

import java.util.Date;
import utilities.Formatter;

public class Flower {
    private final String id ;
    private String description ;
    private Date importDate ;
    private double price ;
    private String category ;
    private final String dateFormat ;

    public Flower(String id, String description, Date importDate, double price, String category , String dateFormat) {
        this.id = id;
        this.description = description;
        this.importDate = importDate;
        this.price = price;
        this.category = category;
        this.dateFormat = dateFormat ;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getImportDate() {
        return importDate;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
    
    public void display(){
        System.out.println(this.toString());
    }
    
    @Override
    public String toString(){
        String ret = String.format("%s,%s,%s,%f,%s",
                id ,
                description ,
                Formatter.toDateString(importDate , dateFormat),
                price , 
                category);
        return ret ;
    }
}
