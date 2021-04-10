
import java.util.Scanner;


/**
 *
 * @author Ayron
 */
// Utilizado para testes no trabalho SelfBalancingBinarySearchTree
public class PrintInsertFunctions {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[100];
        for(int i = 0; i < 100; i++) {
            strings[i] = scanner.nextLine();
        }
        
        for(int i=0; i < 100; i++) {
            System.out.println("tree.insert("+strings[i]+");");
        }
    }
}
