package Trabalhos;

import java.util.ArrayList;
import java.util.Scanner;

public class OpenAddressingHashTable {
    public static void main(String[] args) {
        CLI cli = new CLI();
        cli.init();
    }
    
    static class CLI {
        Scanner scanner = new Scanner(System.in);
        HashMap hashMap;
        
        public void init() {
            int length = 0;
            
            boolean exit = false;
            while(!exit && length < 1) {
                System.out.println("Informe o tamanho da tabela ou -1 para encerrar: ");
                length = scanner.nextInt();
                
                if(length == -1) {
                    exit = true;
                } else if (length <= 0) {
                    System.out.println("Tamanho de tabela deve ser maior ou igual a 1");
                }
            }
            
            ArrayList <String[]> commands = new ArrayList<>();
            String operator;
            String string;
            while(!exit) {
                operator = "";
                string = "";
                while(!operator.equals("-1") && !operator.equals("0") && !operator.equals("1")) {
                    System.out.println("Informe 0 para adicionar, 1 para remover ou -1 para encerrar: ");
                    operator = scanner.nextLine();
                    // Se usado nextInt estoura excecao ao digitar algo diferente de inteiro mas 
                    // se usado nextLine por algum motivo mostra a string de "informe... " duas veze
                    if(operator.equals("-1")) {
                        exit = true;
                    }
                }
                
                if(!exit) {
                    System.out.println("Informe a string ou -1 para encerrar");
                    string = scanner.nextLine();
                    if(string.equals("-1")) {
                        exit = true;
                    }
                }
                
                if(!exit) {
                    commands.add(new String[]{operator, string});
                }
            }
            
            if(exit) {
                hashMap = new HashMap(length);
                for(int i = 0; i < commands.size(); i++) {
                    if(commands.get(i)[0].equals("0")) {
                        hashMap.insert(commands.get(i)[1]);
                    } else {
                        hashMap.remove(commands.get(i)[1]);
                    }
                }
                hashMap.print();
            }
            
        }
    }
    
    static class HashMap {
        String[] hashMap;
        
        public HashMap(int m){
            initHashMap(m);
        }
        
        public void print() {
            for (String element : hashMap) {
                System.out.println(element);
            }
        }
        
        public void insert(String str){
            int pos = hash(str);
            if(hashMap[pos].equals("-1") || hashMap[pos].equals("-2")) {
                hashMap[pos] = str;
            } else {
                boolean put = false;
                int i = 0;
                int k = pos + 1;
                while(!put && i < hashMap.length) {
                    if(k >= hashMap.length) {
                        k = 0;
                    }
                    if(hashMap[k].equals("-1") || hashMap[k].equals("-2")) {
                        hashMap[k] = str;
                        put = true;
                    } else {
                        k++;
                        i++;
                    }
                }
            }
        }
        
        public void remove(String str){
            int pos = hash(str);
            if(hashMap[pos].equals(str)) {
                hashMap[pos] = "-2";
            } else {
                boolean removedOrNone = false;
                int i = 0;
                int k = pos + 1;
                while(!removedOrNone && i < hashMap.length) {
                    if(k >= hashMap.length) {
                        k = 0;
                    }
                    if(hashMap[k].equals("-1")) {
                        removedOrNone = true;
                    } else if(hashMap[k].equals(str)) {
                        hashMap[k] = "-2";
                        removedOrNone = true;
                    } else {
                        i++;
                        k++;
                    }
                }
            }
        }
        
        
        private void initHashMap(int m) {
            hashMap = new String[m];
            for(int i = 0; i < hashMap.length; i++) {
                hashMap[i] = "-1";
            }
        }
        
        private int hash(String str) {
            return str.length() % hashMap.length;
        }
    }
}