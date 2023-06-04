/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import business.FlowerStoreManager;
import utilities.Inputter;
import utilities.Menu;

/**
 *
 * @author 
 */
public class Main {
    public static void main(String[] args) {
        FlowerStoreManager fsm = new FlowerStoreManager("dd/MM/yyyy");
        Menu mainMenu = new Menu("Flower store management") ;
        mainMenu.addOption("Manage flower");
        mainMenu.addOption("Manage order");
        mainMenu.addOption("Quit");
        Menu flowerMenu = new Menu("Manage flower") ;
        flowerMenu.addOption("Add flower");
        flowerMenu.addOption("Find flower");
        flowerMenu.addOption("Update flower");
        flowerMenu.addOption("Delete flower");
        flowerMenu.addOption("Back to main menu");
        Menu orderMenu = new Menu("Manage order") ;
        orderMenu.addOption("Add order");
        orderMenu.addOption("Display order");
        orderMenu.addOption("Sort order");
        orderMenu.addOption("Save data");
        orderMenu.addOption("Load data");
        orderMenu.addOption("Back to main menu");
        boolean saved = true ;
        while(true){
            mainMenu.print();
            int n = mainMenu.getChoice() ;
            switch(n){
                case 1:{
                    flowerMenu.print();
                    switch(flowerMenu.getChoice()){
                        case 1:{
                            while(true){
                                fsm.addFlower();
                                if (!Inputter.getYesOrNo("Countinously add new flower?")) break ;
                            }
                            saved = false ;
                            break ;
                        }
                        case 2:{
                            fsm.findFlower();
                            break ;
                        }
                        case 3:{
                            fsm.updateFlower();
                            break ;
                        }
                        case 4:{
                            fsm.deleteFlower();
                            break ;
                        }
                    }
                    break ;
                }
                case 2:{
                    orderMenu.print();
                    switch(orderMenu.getChoice()){
                        case 1:{
                            while(true){
                                fsm.addOrder();
                                if (!Inputter.getYesOrNo("Countinously add new order?")) break ;
                            }
                            saved = false ;
                            break ;
                        }
                        case 2:{
                            fsm.displayOrder();
                            break ;
                        }
                        case 3:{
                            fsm.sortOrder();
                            break ;
                        }
                        case 4:{
                            fsm.saveData();
                            saved = true;
                            break ;
                        }
                        case 5:{
                            fsm.loadData();;
                            break ;
                        }
                    }
                    break ;
                }
                case 3:{
                    if(Inputter.getYesOrNo("Quit program?")){
                        if (!saved && Inputter.getYesOrNo("Do you want to save before quit?")){
                            fsm.saveData();
                        }
                        return ;
                    }
                }
            }
        }
    }
}
