package br.edu.utfpr.thread;

public class Principal {


    public static void main(String[] args) {
        /*Thread1 t = new Thread1("thread1");
        t.start();
        Thread1 t2 = new Thread1("thread2");
        t2.start();        */
        
        for(int i=0;i<100;i++)
            new Thread(new Thread3("thread"+i)).start();
    }
    
}
