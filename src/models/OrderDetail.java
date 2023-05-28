/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Administrator
 */
public class OrderDetail {
    private final String id ;
    private final Flower flower ;
    private final int count ;

    public OrderDetail(String id, Flower flower, int count) {
        this.id = id;
        this.flower = flower;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public Flower getFlower() {
        return flower;
    }

    public int getCount() {
        return count;
    }
    
    public double getTotal(){
        return flower.getPrice() * count ;
    }
    
    @Override
    public String toString(){
        String ret = String.format("%s,%s,%d",id,flower.getId(),count);
        return ret ;
    }
}
