/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author Administrator
 */
public class FlowerStoreManager {
    private FlowerManager fm ;
    private OrderManager om ;
    private final String format ;

    public FlowerStoreManager(String format) {
        this.format = format;
        fm = new FlowerManager(format) ;
        om = new OrderManager(format) ;
    }
    
    
}
