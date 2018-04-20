
package cp.swing;

import javax.swing.JTextArea;



public class ThreadExemplo extends Thread{
    
    private int tempo=0;
    private JTextArea jTxArea;
    
    public ThreadExemplo(){}
    
    public ThreadExemplo(String nome, int prioridade, int tempo, JTextArea jTxArea){
        this.setName(nome);
        this.setPriority(prioridade);
        this.tempo=tempo;
        this.jTxArea=jTxArea;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("ID:\t"+this.getId());
            jTxArea.append("ID:\t"+this.getId()+"\n");
            System.out.println("Nome:\t"+this.getName());
            jTxArea.append("Nome:\t"+this.getName()+"\n");
            System.out.println("Prioridade:\t"+this.getPriority());
            jTxArea.append("Prioridade:\t"+this.getPriority()+"\n");
            System.out.println("Tempo:\t"+this.tempo+"\n\n");
            jTxArea.append("Tempo:\t"+this.tempo+"\n\n\n");
            try {
                Thread.sleep(i);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
