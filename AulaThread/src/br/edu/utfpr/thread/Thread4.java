package br.edu.utfpr.thread;

import javax.swing.JTextArea;

public class Thread4 implements Runnable{

    JTextArea jTArea;
    
    public Thread4(JTextArea jTArea){
        this.jTArea = jTArea;
    }
    
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            this.jTArea.append("i = "+i+"\n");
        }
    }
    
}
