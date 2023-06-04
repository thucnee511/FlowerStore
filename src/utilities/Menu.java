/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.util.ArrayList;

/**
 *
 * @author Hoang Ha Oanh
 */
public class Menu {

    private String title;
    private ArrayList<String> options;
    private int size;

    public Menu(String title) {
        this.title = title;
        this.size = 0;
        this.options = new ArrayList<>();
    }

    public void addOption(String option) {
        options.add(option);
        size++;
    }

    public void print() {
        System.out.println(title);
        for (int i = 0; i < size; i++) {
            System.out.println(String.format("%d-%s.", i + 1, options.get(i)));
        }
    }

    public int getChoice() {
        while (true) {
            try {
                int choice = Inputter.getInt("Enter your choice: ");
                if (choice < 1 || choice > size) throw new Exception() ;
                return choice ;
            } catch (Exception e) {
                System.out.println("Choose 1 - " + size + ".");
            }
        }
    }
}
