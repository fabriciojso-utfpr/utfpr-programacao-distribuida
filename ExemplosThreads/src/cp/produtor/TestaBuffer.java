package cp.produtor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestaBuffer {

    public static void main(String[] args) {
        // criar fila de duas threads
        ExecutorService aplicacao = Executors.newFixedThreadPool(2);

        // criando buffer para compartilhamento
        Buffer locacaoCompartilhada = new BuffernaoSincronizado();

        System.out.println("Ação\t\t\t\tValor");
        System.out.println("----\t\t\t\t-----\n");

        // inicilizar produtor e consumidor
        aplicacao.execute(new Produtor(locacaoCompartilhada));
        aplicacao.execute(new Consumidor(locacaoCompartilhada));

        aplicacao.shutdown();
    }

}
