package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import models.Flower;
import models.OrderDetail;

public class OrderDetailManager {

    private Set<OrderDetail> set = new TreeSet<>(Comparator.comparing(OrderDetail::getId));

    public OrderDetailManager() {
    }

    private String initId() {
        String id = Integer.toString(set.size());
        String idString = "OD";
        while (idString.length() + id.length() < 5) {
            id = "0" + id;
        }
        idString = idString + id;
        return idString;
    }

    public String addOrderDetail(Flower f, int count) {
        String id = initId();
        set.add(new OrderDetail(id, f, count));
        return id ;
    }
    
    public OrderDetail find(String id){
        for(OrderDetail od : set){
            if (od.getId().equals(id)) return od ;
        }
        return null ;
    }

    public boolean isFlowerInDetail(Flower f) {
        for (OrderDetail od : set) {
            if (od.getFlower().getId().equals(f.getId())) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<String> toStringArrayList(){
        ArrayList<String> ret = new ArrayList<>();
        for(OrderDetail f : set){
            ret.add(f.toString());
        }
        return ret ;
    }
}
