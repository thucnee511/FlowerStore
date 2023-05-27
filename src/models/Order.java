/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Administrator
 */
public class Order {
    private final String id ;
    private final Date date ;
    private final String cusName ;
    private final Set<String> orderDetails = new TreeSet<>() ;

    public Order(String id, Date date, String cusName) {
        this.id = id;
        this.date = date;
        this.cusName = cusName;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getCusName() {
        return cusName;
    }

    public Set<String> getOrderDetails() {
        return orderDetails;
    }
    
    public void addOrderDetail(OrderDetailManager odm , FlowerManager fm){
        while(true){
            
        }
    }
}
