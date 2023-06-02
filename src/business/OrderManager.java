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
import models.Order;
import models.OrderDetail;
import utilities.Formatter;
import utilities.Inputter;

/**
 *
 * @author Administrator
 */
public class OrderManager extends TreeSet<Order> {

    private final String format;

    public OrderManager(String format) {
        this.format = format;
    }

    public void add(FlowerManager fm) {
        String id = "";
        while (true) {
            id = Inputter.getString("Enter flower id: ", "[FXXX]", "F\\d{3}");
            if (find(id) != null) {
                break;
            } else {
                System.out.println("Id must be unique.");
            }
        }
        Date date = Inputter.getDate("Enter date: ", format);
        String cusName = Inputter.getStringNonBlank("Enter customer name: ");
        Order o = new Order(id, cusName, date, format);
        System.out.println("Add order details:");
        int countId = 0;
        while (true) {
            String fId;
            while (true) {
                fId = Inputter.getString("Enter flower id (Just enter to stop add detail): ");
                if (countId == 0 && fId.isEmpty()) {
                    System.out.println("Must have at least 1 order detail.");
                } else {
                    break;
                }
            }
            int quantity = Inputter.getPositiveInt("Enter quantity: ");
            String oId = Integer.toString(countId);
            Flower f = fm.find(fId);
            o.addDetail(new OrderDetail(oId, f, quantity));
        }
    }

    public Order find(String id) {
        for (Order f : this) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        return null;
    }
    
    public boolean isFlowerInOrder(Flower flower){
        for(Order o : this){
            Set<OrderDetail> ods = o.getOrderDetail() ;
            for(OrderDetail od : ods){
                if(od.getFlower().getId().equals(flower.getId())) return true ;
            }
        }
        return false ;
    }

    public void display() {
        Date sDate = Inputter.getDate("Start date: ", format);
        Date eDate = Inputter.getDate("End date: ", format);
        Set<Order> displaySet = new TreeSet<>(Comparator.comparing(Order::getId));
        for (Order o : this) {
            if (isInRangeDate(sDate, eDate, o)) {
                displaySet.add(o);
            }
        }
        System.out.println("LIST ORDER FROM " + Formatter.toDateString(sDate, format) + " TO " + Formatter.toDateString(eDate, format));
        display(displaySet);
    }

    public void sort() {
        Set<Order> displaySet = new TreeSet<>();
        String sOrd = Inputter.getString("ORDER BY (Order Id, Order Date, Flower Count, Order Total): ");
        String tOrd = Inputter.getString("SORT ORDER (ASC, DESC): ");
        boolean asc = tOrd.equalsIgnoreCase("asc");
        if (sOrd.equalsIgnoreCase("order id")) {
            if (asc) {
                displaySet = new TreeSet<>(Comparator.comparing(Order::getId));
            } else {
                displaySet = new TreeSet<>(Comparator.comparing(Order::getId).reversed());
            }
        } else if (sOrd.equalsIgnoreCase("order date")) {
            if (asc) {
                displaySet = new TreeSet<>(new CmpDate());
            } else {
                displaySet = new TreeSet<>(new CmpDate().reversed());
            }
        } else if (sOrd.equalsIgnoreCase("flower count")) {
            if (asc) {
                displaySet = new TreeSet<>(new CmpCount());
            } else {
                displaySet = new TreeSet<>(new CmpCount().reversed());
            }
        } else if (sOrd.equalsIgnoreCase("order total")) {
            if (asc) {
                displaySet = new TreeSet<>(new CmpTotal());
            } else {
                displaySet = new TreeSet<>(new CmpTotal().reversed());
            }
        } else {
            System.out.println("Does not exist.");
        }
        for (Order o : this) {
            displaySet.add(o);
        }
        display(displaySet);
    }

    private void display(Set<Order> displaySet) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("| No.| Order Id | Order Date | Customer        | Flower Count | Order Total |");
        System.out.println("-----------------------------------------------------------------------------");
        int count = 1;
        for (Order o : displaySet) {
            String line = Formatter.toInfoLine(count, o.getId(), Formatter.toDateString(o.getDate(), format), o.getName(), o.getCount(), o.getTotal());
            System.out.println(line);
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    private boolean isInRangeDate(Date sDate, Date eDate, Order o) {
        Date current = o.getDate();
        boolean isAfter = sDate.compareTo(current) <= 0;
        boolean isBefore = eDate.compareTo(current) >= 0;
        return isAfter && isBefore;
    }

    public ArrayList<String> toStringArrayList() {
        ArrayList<String> ret = new ArrayList<>();
        for (Order f : this) {
            ret.add(f.toString());
        }
        return ret;
    }
}

class CmpDate implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        if (o1.getDate().compareTo(o2.getDate()) == 0) {
            return o1.getId().compareTo(o2.getId());
        } else {
            return o1.getDate().compareTo(o2.getDate());
        }
    }

}

class CmpCount implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        if (o1.getCount() == o2.getCount()) {
            return o1.getId().compareTo(o2.getId());
        } else {
            return Integer.compare(o1.getCount(), o2.getCount());
        }
    }

}

class CmpTotal implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        if (o1.getTotal() == o1.getTotal()) {
            return o1.getId().compareTo(o2.getId());
        } else {
            return Double.compare(o1.getTotal(), o2.getTotal());
        }
    }

}
