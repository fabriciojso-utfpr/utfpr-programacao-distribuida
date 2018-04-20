package br.edu.utfpr.thread;

public class Thread1 extends Thread{
    
    public Thread1(){       
        
    }
    
    public Thread1(String nome){
        this.setName(nome);
    }

    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(this.getName()+" i = "+i);
        }
    }    
    
}
