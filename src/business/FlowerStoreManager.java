/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.util.ArrayList;
import models.Flower;
import models.Order;
import models.OrderDetail;
import utilities.Formatter;
import utilities.Loader;

/**
 *
 * @author Administrator
 */
public class FlowerStoreManager {
    private FlowerManager fm ;
    private OrderManager om ;
    private final String format ;
    private final String FLOWERPATH = "\\data\\flowers.dat" ;
    private final String ORDERPATH = "\\data\\orders.dat" ;

    public FlowerStoreManager(String format) {
        loadData() ;
        this.format = format;
        fm = new FlowerManager(format) ;
        om = new OrderManager(format) ;
    }
    
    public void addFlower(){
        fm.add();
    }
    
    public void findFlower(){
        fm.find();
    }
    
    public void updateFlower(){
        fm.update();
    }
    
    public void deleteFlower(){
        fm.delete(om);
    }
    
    public void addOrder(){
        om.add(fm);
    }
    
    public void displayOrder(){
        om.display();
    }
    
    public void sortOrder(){
        om.sort();
    }
    
    public void loadData(){
        ArrayList<String> dta = new ArrayList<>() ;
        dta.addAll(Loader.readFromFile(ORDERPATH));
        dta.addAll(Loader.readFromFile(FLOWERPATH));
        for(String line : dta){
            if(line == null || line.isEmpty()) continue ; 
            String[] lineSplit = line.split(",") ;
            if (lineSplit[0].matches("F\\d{3}")){
                fm.add(new Flower(lineSplit[0],
                lineSplit[1] , 
                Formatter.toDate(lineSplit[2] , format),
                Integer.parseInt(lineSplit[3]) ,
                lineSplit[4] ,
                format)) ;
            }else if(lineSplit[0].matches("O\\d{3}")){
                Order o = new Order(lineSplit[0] , lineSplit[2] , Formatter.toDate(lineSplit[1], format) , format) ;
                int count = 0 ;
                for(String detail : lineSplit){
                    if (count > 2){
                        String od[] = detail.split(":") ;
                        Flower f = fm.find(od[1]) ;
                        int quantity = Integer.parseInt(od[2]) ;
                        o.addDetail(new OrderDetail(od[0] , f , quantity));
                    }
                    count++ ;
                }
            }
        }
    }
    
    public void saveData(){
        ArrayList<String> ordDta = om.toStringArrayList() ;
        ArrayList<String> floDta = fm.toStringArrayList() ;
        Loader.writeToFile(ORDERPATH, ordDta);
        Loader.writeToFile(FLOWERPATH, floDta);
    }
}
