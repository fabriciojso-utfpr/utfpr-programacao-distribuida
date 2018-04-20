package br.edu.utfpr.thread;

public class Thread3 implements Runnable{

    private String name;
    
    public Thread3(String nome){
        this.name = nome;
    }
    
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(this.name+" i = "+i);
        }
        
    }
    
}
