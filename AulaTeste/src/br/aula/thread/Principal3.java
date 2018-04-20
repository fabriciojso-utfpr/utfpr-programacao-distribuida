package br.aula.thread;

public class Principal3 {       
    
    
    public static void main(String[] args) {        
        Thread t = new Thread(new Thread1());
        t.setDaemon(false);
        t.start();   
        System.out.println("fim do programa");
        
    }

}
