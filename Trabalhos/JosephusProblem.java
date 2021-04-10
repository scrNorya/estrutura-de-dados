package Trabalhos;
import java.util.Scanner;

/**
 *
 * @author ayron
 */
public class JosephusProblem {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CLI cli = new CLI();
        try {
            cli.init();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    static class Node {
    
        private final int position;
        private Node next;

        public Node(int position) {
            this.position = position;
        }

        public int getPosition() {
            return position;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    
    }
    
    static class SolveJosephusProblem {
    
        public int solveJosephus(int n, int m) throws Exception {
            
            if(n <= 0) {
                throw new Exception("Numero de soldados deve ser maior que 0");
            }
            
            if(m <= 0) {
                throw new Exception("Numero de tamanho de passos deve ser maior que 0");
            } 
            
            Node head = new Node(1);
            Node newNode = head;
            
            for(int i = 2; i <= n; i++) {
                newNode.setNext(new Node(i));
                newNode = newNode.getNext();
            }
            
            newNode.setNext(head);
            
            Node cursor = head, prevCursor;
            
            
            while(cursor.getNext() != cursor) {
                
                int steps = 1;
                
                prevCursor = cursor;
                    
                while(steps < m) {
                    cursor = cursor.getNext();
                    steps++;
                }
                if(cursor.getNext() == prevCursor) {
                    cursor = prevCursor;
                }
                cursor.setNext(cursor.getNext().getNext());
                cursor = cursor.getNext();
            }
            
            return cursor.getPosition();
        }
    }
    
    static class CLI {
    
        Scanner scanner = new Scanner(System.in);
        SolveJosephusProblem jp = new SolveJosephusProblem();

        public CLI() {
        }

        public void init() throws Exception {
            System.out.println("Josephus Problem");

            int cases;
            int[] n, m;

            System.out.println("Informe o numero de casos: ");

            cases = scanner.nextInt();

            if(cases < 0) {
                throw new Exception("Numero de casos deve ser maior ou igual a 0");
            }

            n = new int[cases];
            m = new int[cases];

            for(int i = 0; i < cases; i++) {
                System.out.println("Informe valor de n do caso " + (i+1) + ": ");
                n[i] = scanner.nextInt();

                if(n[i] <= 0) {
                    throw new Exception("Valor de n deve ser maior ou igual a 1");
                }

                System.out.println("Informe o valor de m do caso " + (i+1) + ": ");
                m[i] = scanner.nextInt();

                if(m[i] <= 0) {
                    throw new Exception("Valor de m deve ser maior ou igual a 1");
                }
            }

            for(int i = 0; i < cases ; i++) {
                int r = jp.solveJosephus(n[i], m[i]);
                System.out.println("Usando n="+n[i]+ ", m="+m[i]+", resultado="+r);
            }
        }
    }
}