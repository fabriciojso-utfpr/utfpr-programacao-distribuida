package br.aula.thread;

public class Thread3 implements Runnable {

    protected boolean parar=false;
    
    @Override
    public void run() {
        int i = 0;
        while (!parar) {            
            System.out.println(" i = " + i);
            i++;
        }
    }

}
