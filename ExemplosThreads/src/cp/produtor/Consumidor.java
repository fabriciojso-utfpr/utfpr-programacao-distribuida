package cp.produtor;

import java.util.Random;

public class Consumidor implements Runnable {    

    public static Random gerador = new Random();
    
    public Buffer locacaoCompartilhada;

    public Consumidor(Buffer bufferCompartilhado) {
        this.locacaoCompartilhada = bufferCompartilhado;
    }

    @Override
    public void run() {
        int soma = 0;
        for (int i = 0; i <= 10; i++) {
            try {
                System.out.println("Consumidor lendo...");
                Thread.sleep(gerador.nextInt(3000));
                soma += locacaoCompartilhada.get();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("\n\n\nConsumidor terminou com soma = " + soma);
    }

}
