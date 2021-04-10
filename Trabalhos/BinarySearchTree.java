package Trabalhos;

import java.util.Scanner;

/**
 *
 * @author norya
 */
public class BinarySearchTree {
    
    public static void main(String[] args){
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        
        int cases = scanner.nextInt();
        int[] inputs = new int[cases];
        
        for(int i = 0; i < cases; i++) {
            inputs[i] = scanner.nextInt();
        }
        
        for(int input : inputs) {
            tree.insert(input);
        }
        
        tree.printPreOrder(tree.getRoot());
        System.out.println("");
        tree.printInOrder(tree.getRoot());
        System.out.println("");
        tree.printPostOrder(tree.getRoot());
        System.out.println("");
    }
    
    static class Tree {
        Node root;
        
        public Node getRoot(){
            return root;
        }
        
        public Node search(int value) {
            Node next = root;
            Node prev = next;
            
            while(next != null) {
                if(next.value == value) {
                    prev = next;
                    next = null;
                } else if(value < next.value) {
                    prev = next;
                    next = next.left;
                } else {
                    prev = next;
                    next = next.right;
                }
            }
            
            return prev;
        }
        
        public void insert(int value){
            if(root == null) {
                root = new Node(value);
            } else {
                Node pos = search(value);
                if(pos != null) {
                    if (pos.value != value) {
                        if(value < pos.value) {
                            pos.left = new Node(value);
                        } else if (value > pos.value) {
                            pos.right = new Node(value);
                        }
                    }
                }
            }
        }
        
        public void printPreOrder(Node root) {
            if(root != null) {
                System.out.print(root.value + " ");
                printPreOrder(root.left);
                printPreOrder(root.right);
            }
        }
        
        public void printInOrder(Node root) {
            if(root != null) {
                printInOrder(root.left);
                System.out.print(root.value + " ");
                printInOrder(root.right);
            }
        }
        
        public void printPostOrder(Node root) {
            if(root != null) {
                printPostOrder(root.left);
                printPostOrder(root.right);
                System.out.print(root.value + " ");
            }
        }
    }
    
    static class Node{
        int value;
        Node right;
        Node left;
        
        public Node(int value) {
            this.value = value;
        }
    }
}
