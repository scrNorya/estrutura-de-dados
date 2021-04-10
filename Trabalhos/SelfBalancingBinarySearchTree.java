package Trabalhos;
import java.util.Scanner;

/**
 *
 * @author ayron
 */
public class SelfBalancingBinarySearchTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tree tree = new Tree();
//        Scanner scanner = new Scanner(System.in);
//       
//        int cases = scanner.nextInt();
//        int[] inputs = new int[cases];
//        
//        for(int i = 0; i < cases; i++) {
//            inputs[i] = scanner.nextInt();
//        }
//        
//        for(int input : inputs) {
//            tree.insert(input);
//        }

tree.insert(44);
tree.insert(28);
tree.insert(11);
tree.insert(58);
tree.insert(21);
tree.insert(17);
tree.insert(97);
tree.insert(68);
tree.insert(95);
tree.insert(86);
tree.insert(64);
tree.insert(31);
tree.insert(65);
tree.insert(67);
tree.insert(26);
tree.insert(9);
tree.insert(3);
tree.insert(56);
tree.insert(41);
tree.insert(42);
tree.insert(94);
tree.insert(29);
tree.insert(2);
tree.insert(13);
tree.insert(19);
tree.insert(14);
tree.insert(18);
tree.insert(10);
tree.insert(85);
tree.insert(91);
tree.insert(49);
tree.insert(46);
tree.insert(93);
tree.insert(82);
tree.insert(36);
tree.insert(78);
tree.insert(62);
tree.insert(52);
tree.insert(25);
tree.insert(48);
tree.insert(90);
tree.insert(87);
tree.insert(99);
tree.insert(34);
tree.insert(37);
tree.insert(33);
tree.insert(50);
tree.insert(1);
tree.insert(72);
tree.insert(54);
tree.insert(55);
tree.insert(71);
tree.insert(77);
tree.insert(20);
tree.insert(69);
tree.insert(6);
tree.insert(61);
tree.insert(70);
tree.insert(23);
tree.insert(96);
tree.insert(39);
tree.insert(63);
tree.insert(57);
tree.insert(35);
tree.insert(22);
tree.insert(88);
tree.insert(12);
tree.insert(7);
tree.insert(27);
tree.insert(38);
tree.insert(4);
tree.insert(79);
tree.insert(51);
tree.insert(8);
tree.insert(98);
tree.insert(15);
tree.insert(24);
tree.insert(45);
tree.insert(30);
tree.insert(32);
tree.insert(100);
tree.insert(92);
tree.insert(74);
tree.insert(66);
tree.insert(59);
tree.insert(60);
tree.insert(73);
tree.insert(5);
tree.insert(75);
tree.insert(16);
tree.insert(43);
tree.insert(83);
tree.insert(80);
tree.insert(81);
tree.insert(89);
tree.insert(40);
tree.insert(47);
tree.insert(84);
tree.insert(53);
tree.insert(76);


        tree.printPreOrder(tree.getRoot());
        System.out.println("");
        tree.printInOrder(tree.getRoot());
        System.out.println("");
        tree.printPostOrder(tree.getRoot());
        System.out.println("");
    }
    
    static class Tree {
        Node root = null;
        
        public void insert(int k) {
            System.out.println(k);
            Node node = new Node(k);
            if(root == null) {
                root = node;
            } else {
                Node p = search(root, k);
                if(p.value == k) {
                    node = p;
                } else {
                    if(p.value < k) {
                        node.parent = p;
                        p.right = node;
                    } else {
                        node.parent = p;
                        p.left = node;
                    }
                }
            }
            rebalance(node);
        }
        
        public void rebalance(Node p) {
            int pHeight = -1;
            
            while(p != null) {
                if(!isBalanced(p)) {
                    Node pLeft = null;
                    Node pRight = null;
                    if(p.left != null) {
                        pLeft = p.left;
                    }
                    if(p.right != null) {
                        pRight = p.right;
                    }
                    reestructure(getHigherGrandchild(p));
                    updateHeight(pLeft);
                    updateHeight(pRight);
                }
                
                pHeight = getNodeHeight(p);
                
                updateHeight(p);
                
                if(getNodeHeight(p) == pHeight) {
                    p = null;
                } else {
                    p = p.parent;
                }
            }
        }
        
        public void rotate(Node n) {
            Node node = n;
            Node nodeParent = node.parent;
            Node nodeGrandparent = nodeParent.parent;
            if(nodeGrandparent == null) {
                root = node;
                node.parent = null;
            } else {
                if(nodeParent == nodeGrandparent.left) {
                    nodeGrandparent.left = node;
                    node.parent = nodeGrandparent;
                } else {
                    nodeGrandparent.right = node;
                    node.parent = nodeGrandparent;
                }
            }
            if(node == nodeParent.left) {
                nodeParent.left = node.right;
                if(node.right != null) {
                    node.right.parent = nodeParent;
                } 
                node.right = nodeParent;
                nodeParent.parent = node;
            } else {
                nodeParent.right = node.left;
                if(node.left != null) {
                    node.left.parent = nodeParent;
                }
                node.left = nodeParent;
                nodeParent.parent = node;
            }
        }
        
        public Node search(Node root, int k) {
            System.out.println(k);
            if(k == root.value) {
                return root;
            } else if(k <= root.value) {
                if(root.left != null) {
                    return search(root.left, k);
                }
            } else if(root.right != null) {
                return search(root.right, k);
            }
            return root;
        }
        
        public Node reestructure(Node node) {
            Node nodeParent = node.parent;
            if(areSameSide(nodeParent, node)) {
                rotate(nodeParent);
                return nodeParent;
            }
            rotate(node);
            rotate(node);
            return node;
        }
        
        private void updateHeight(Node node) {
            if(node != null) {
                node.height = Math.max(getNodeHeight(node.right), getNodeHeight(node.left)) + 1;
            }
        }
        
        private boolean isBalanced(Node node) {
            int balance;
            if(node == null) {
                balance = 0;
            } else {
                balance = getNodeHeight(node.right) - getNodeHeight(node.left);
            }
            if(balance >= -1 && balance <= 1) {
                return true;
            } else {
                return false;
            }
        }
        
        public Node getHigherGrandchild(Node node) {
            Node higher = null;
            
            if(node.left != null) {
                if(node.left.left != null) {
                    higher = node.left.left;                
                }
                if(node.left.right != null) {
                    if(higher != null) {
                        if(getNodeHeight(higher) < getNodeHeight(node.left.right)) {
                            higher = node.left.right;
                        }
                    } else {
                        higher = node.left.right;
                    }
                }
            }
            
            if(node.right != null) {
                if(node.right.left != null) {
                    if(higher != null) {
                        if(getNodeHeight(higher) < getNodeHeight(node.right.left)) {
                            higher = node.right.left;
                        }
                    } else {
                        higher = node.right.left;
                    }
                }
                
                if(node.right.right != null) {
                    if(higher != null) {
                        if(getNodeHeight(higher) < getNodeHeight(node.right.right)) {
                            higher = node.right.right;
                        }
                    } else {
                        higher = node.right.right;
                    }
                }
            }
                
            return higher;
        }
        
        public boolean areSameSide(Node p1, Node p2) {
            if(p1 == p1.parent.right && p2 == p2.parent.right ||
                    p1 == p1.parent.left && p2 == p2.parent.left) {
                return true;
            }
            return false;
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
        
        public Node getRoot() {
            return root;
        }
        
        public int getNodeHeight(Node node){
            if(node != null) {
                return node.height;
            } else {
                return -1;
            }
        }
    }
    
    static class Node{
        int height = -1;
        int value;
        Node right;
        Node left;
        Node parent;
        
        public Node(int value) {
            this.value = value;
        }
    }
}
