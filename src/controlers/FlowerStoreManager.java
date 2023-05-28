/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import business.FlowerManager;
import business.OrderManager;
import java.util.ArrayList;
import models.OrderDetailManager;
import utilities.Loader;

/**
 *
 * @author Administrator
 */
public class FlowerStoreManager {
    private final String FLOWERPATH = "\\data\\flowers.dat" ;
    private final String ORDERPATH = "\\data\\orders.dat" ;
    private final FlowerManager fm;
    private final OrderManager om;
    private final OrderDetailManager odm;
    private final String format;

    public FlowerStoreManager(String format) {
        this.fm = new FlowerManager(format);
        this.om = new OrderManager(format);
        this.odm = new OrderDetailManager();
        this.format = format;
    }

    public void addFlower() {
        fm.add();
    }

    public void findFlower() {
        fm.find();
    }

    public void updateFlower() {
        fm.update();
    }

    public void deleteFlower() {
        fm.delete(odm);
    }

    public void addOrder() {
        om.add(fm, odm);
    }

    public void displayOrder() {
        om.display();
    }

    public void sortOrder() {
        om.sort();
    }
    
    public void save(){
        ArrayList<String> fDta = fm.toStringArrayList() ;
        ArrayList<String> oDta = new ArrayList<>() ;
        oDta.addAll(om.toStringArrayList());
        oDta.addAll(odm.toStringArrayList());
        Loader.writeToFile(FLOWERPATH, fDta);
        Loader.writeToFile(ORDERPATH, oDta);
    }
    
    public void load(){
        ArrayList<String> dta = Loader.readFromFile(FLOWERPATH) ;
        dta.addAll(Loader.readFromFile(ORDERPATH));
        for(String line : dta){
            String[] split = line.split(",");
            if(split[0].matches("F\\d{3}")){
                
            }
        }
    }
}
