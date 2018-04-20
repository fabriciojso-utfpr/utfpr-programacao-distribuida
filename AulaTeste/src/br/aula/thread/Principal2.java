
package br.aula.thread;

import br.aula.thread.Thread3;

public class Principal2 {
    
    public static Thread3 thread=new Thread3();

    public static void main(String[] args) {
        Thread t1=new Thread(thread);
        t1.start();
        System.out.println("Thread vai parar");
        System.out.println("Thread vai parar");
        System.out.println("Thread vai parar");
        thread.parar=true;
        
    }
    
}
