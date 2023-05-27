/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import models.Flower;

/**
 *
 * @author Administrator
 */
public class FlowerManger {
    private Set<Flower> set = new TreeSet<>(Comparator.comparing(Flower::getId)) ;
    
    
}
