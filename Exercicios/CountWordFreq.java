package Exercicios;
import Estudos.Map.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Ayron
 */
public class CountWordFreq {
    public static void Main(String[] args) {
        
    }
    
    public static void countWordFreq (String filename) throws FileNotFoundException{ 
        File file = new File(filename);
        Scanner reader = new Scanner(file);
        Map freq = new Map();
        
    }
    
}
