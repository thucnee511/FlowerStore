/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import utilities.Formatter;

/**
 *
 * @author Administrator
 */
public class Order {
    private String id ;
    private String name ;
    private Date date ;
    private Set<OrderDetail> orderDetails = new TreeSet<>() ;
    private final String format ;
    private int count ;
    private double total ;
    
    public Order(String id, String name, Date date , String format) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.format = format ;
        count = 0 ;
        total = 0 ;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public Set<OrderDetail> getOrderDetail(){
        return orderDetails ;
    }
    
    public void addDetail(OrderDetail od){
        orderDetails.add(od) ;
        count += od.getQuantity() ;
        total += od.getFlowerCost() ;
    }
    
    public int getCount(){
        return count ;
    }
    
    public double getTotal(){
        return total ;
    }
    
    private String toStringDetail(){
        String ret = "" ;
        for(OrderDetail od : orderDetails){
            ret += String.format("%s,",od.toString()) ;
        }
        return ret.substring(0 , ret.length()-1) ;
    }
    
    @Override
    public String toString(){
        String str = String.format("%s,%s,%s,%s",
                id , Formatter.toDateString(date, format) , name , toStringDetail()) ;
        return str ;
    }
}
