/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estudos.Map;

/**
 *
 * @author ayron
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map map;
        map = new Map();
        map.put(10, 10);
        map.put(map, 5);
        System.out.println(map.search(map).getValue());
        
    
    }
    
}
