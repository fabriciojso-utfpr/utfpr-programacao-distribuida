package cp.produtor;

import java.util.Random;

public class Produtor implements Runnable {

    private static Random gerador = new Random();
    
    private Buffer locacaoCompartilhada;

    public Produtor(Buffer bufferCompartilhado) {
        this.locacaoCompartilhada = bufferCompartilhado;
    }

    @Override
    public void run() {
        int soma = 0;

        for (int i = 0; i <= 10; i++) {
            try {
                System.out.println("Produtor escrevendo...");
                Thread.sleep(gerador.nextInt(3000));
                locacaoCompartilhada.set(i);
                soma += i;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("\n\n\n Produtor terminou com soma = " + soma);
    }

}
