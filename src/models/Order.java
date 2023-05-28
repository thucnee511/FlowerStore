/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import business.FlowerManager;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import utilities.Formatter;
import utilities.Inputter;

/**
 *
 * @author Administrator
 */
public class Order {

    private final String id;
    private final Date date;
    private final String cusName;
    private int count;
    private double total;
    private Set<String> orderDetails = new TreeSet<>();
    private final String dateFormat ;

    public Order(String id, Date date, String cusName , String dateFormat) {
        this.id = id;
        this.date = date;
        this.cusName = cusName;
        this.count = 0;
        this.total = 0;
        this.dateFormat = dateFormat ;
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

    public int getCount() {
        return count;
    }

    public double getTotal() {
        return total;
    }

    public Set<String> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<String> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void addOrderDetail(OrderDetailManager odm, FlowerManager fm) {
        while (true) {
            String fId = Inputter.getString("Enter flower id (Press enter to stop add detail): ");
            if (fId.isEmpty() && orderDetails.isEmpty()) {
                System.out.println("Order must have at least 1 order detail.");
            } else if (fId.isEmpty()) {
                break;
            } else {
                int _count = Inputter.getPositiveInt("Enter flower count: ");
                orderDetails.add(odm.addOrderDetail(fm.find(fId), count));
                count += _count;
                total += fm.find(fId).getPrice() * _count;
            }
        }
    }

    private String toStringDetails() {
        String ret = "";
        for (String item : orderDetails) {
            ret += String.format("%s:", item);
        }
        return ret.substring(0, ret.length() - 1);
    }

    @Override
    public String toString() {
        String ret = String.format("%s,%s,%s,%s",id,Formatter.toDateString(date, dateFormat) , cusName , toStringDetails());
        return ret;
    }
}
