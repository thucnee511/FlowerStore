package models;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import models.Flower;
import models.OrderDetail;

public class OrderDetailManager {
    private Set<OrderDetail> set = new TreeSet<>(Comparator.comparing(OrderDetail::getId));
    
    public OrderDetailManager(){
    }
    
    private String initId(){
        String id = Integer.toString(set.size()) ;
        String idString = "OD" ;
        while(idString.length() + id.length() < 5){
            id = "0" + id ;
        }
        idString = idString + id ;
        return idString ;
    }
    
    public void addOrderDetail(Flower f , int count){
        String id = initId() ;
        set.add(new OrderDetail(id , f , count)) ;
    }
}
