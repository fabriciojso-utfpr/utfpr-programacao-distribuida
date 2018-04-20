
package cp.contador;


public class ContadorSincronizado implements Conta{

    private int c = 0;

    public synchronized void incC() {
        c++;
    }

    public synchronized void decC() {
        c--;
    }

    public synchronized int mostraC() {
        return c;
    }

}
