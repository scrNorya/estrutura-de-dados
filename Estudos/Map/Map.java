package Estudos.Map;

import java.util.Arrays;

/**
 *
 * @author Ayron
 */

 /**
 *@param <K> Key
 *@param <V> Value
 */
public class Map<K, V>{
    private Element[] map;
    int size;
    
    public Map() {
        map = new Element[1];
        size = -1;
    }
    
    private void increaseMapLength(){
        map = Arrays.copyOf(map, map.length*2);
    }
    
    public void put(K key, V value) {
        if (size + 1 == map.length) {
            increaseMapLength();
        }
        
        int i = searchPos(key);
        
        if(i != -1) {
            map[i].setValue(value);
        } else if (size + 1 < map.length){
            map[size + 1] = new Element(key, value);
        } else {
            map[++size] = new Element(key, value);
        }
    }
    
    public void delete(K key) {
        int i = searchPos(key);
        if(i != -1) {
            map[i] = null;
        }
    }
    
    public Element search(K key) {
        int i = searchPos(key);
        if(i != -1) {
            return map[i];
        }
        return null;
    }
    
    public Element[] getMap() {
        return map;
    }
    
    private int searchPos(K key){
        int i = 0;
        while(i <= size + 1) {
            if(map[i] != null && map[i].getKey() == key) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }
}
