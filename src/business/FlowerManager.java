/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import models.Flower;
import utilities.Formatter;
import utilities.Inputter;

/**
 *
 * @author Administrator
 */
public class FlowerManager extends TreeSet<Flower>{
    private final String format ;
    
    public FlowerManager(String format){
        this.format = format ;
    }
    
    public void add(){
        String id = "" ;
        while(true){
            id = Inputter.getString("Enter flower id: ","[FXXX]","F\\d{3}") ;
            if (find(id) == null) break ;
            else{
                System.out.println("Id must be unique.");
            }
        }
        String description = Inputter.getString("Enter description: ", 3 , 50) ;
        Date importDate = Inputter.getDate("Enter import date: ", format);
        double price = Inputter.getPositiveReal("Enter unit price: ") ;
        String category = Inputter.getStringNonBlank("Enter category: ") ;
        this.add(new Flower(id , description , importDate , price , category , format));
    }
    
    public Flower find(String id){
        for(Flower f : this){
            if(f.getId().equals(id)) return f ;
        }
        return null ;
    }
    
    public void find(){
        String id = Inputter.getString("Enter flower id: ","[FXXX]","F\\d{3}") ;
        Flower f = find(id) ;
        if (f == null){
            System.out.println("The flower does not exist.");
        }else{
            f.display();
        }
    }
    
    public void update(){
        String id = Inputter.getString("Enter flower id: ","[FXXX]","F\\d{3}") ;
        Flower f = find(id) ;
        if (f == null){
            System.out.println("The flower does not exist.");
        }else{
            String description = Inputter.getString("Enter description (You can ignore by just enter): ") ;
            String importDate = Inputter.getString("Enter import date (You can ignore by just enter): ") ;
            String price = Inputter.getString("Enter price (You can ignore by just enter): ") ;
            String category = Inputter.getString("Enter category (You can ignore by just enter): ") ;
            try{
                if (!description.isEmpty() && (description.length() < 3 || description.length() > 50))
                    throw new Exception("Description length must be in [3,50]");
                if (!importDate.isEmpty() && Formatter.isValidDateFormat(importDate, format))
                    throw new Exception("Invalid date format.") ;
                if (!price.isEmpty() && Double.parseDouble(price) < 0)
                    throw new Exception("Price must higher than 0.") ;
            }catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("Update failed.");
                return ;
            }
            if (!description.isEmpty()) f.setDescription(description);
            if (!importDate.isEmpty()) f.setImportDate(Formatter.toDate(importDate, format));
            if (!price.isEmpty()) f.setPrice(Double.parseDouble(price));
            if (!category.isEmpty()) f.setCategory(category);
            System.out.println("Update successfully.");
        }
    }
    
    public void delete(OrderManager om){
        String id = Inputter.getString("Enter flower id: ","[FXXX]","F\\d{3}") ;
        Flower f = find(id) ;
        if (om.isFlowerInOrder(f)){
            System.out.println("Delete failed. The flower is in an order.");
        }
    }
    
    public ArrayList<String> toStringArrayList(){
        ArrayList<String> ret = new ArrayList<>();
        for(Flower f : this){
            ret.add(f.toString());
        }
        return ret ;
    } 
}
