
package cp.contador;

public class ThreadContador implements Runnable{
    
    private Conta cont;
    private String nome;
    private int tempo=10;
    
    public ThreadContador(){}    

    public ThreadContador(int tempo, String nome, Conta cont){
        this.tempo=tempo;
        this.cont=cont;
        this.nome=nome;
    }

    public void gastarTempo(){
        try {
            Thread.sleep((int) (Math.random() * tempo));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            cont.decC();    
            gastarTempo();            
        }
        System.out.println(nome+" C = "+cont.mostraC());
    }
    
}
