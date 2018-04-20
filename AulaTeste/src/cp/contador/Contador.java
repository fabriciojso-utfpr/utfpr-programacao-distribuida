
package cp.contador;


public class Contador implements Conta{
    
    private int c=0;

    public void incC(){
        c++;
    }
    
    public void decC(){
        c--;
    }
    
    public int mostraC(){
        return c;
    }
    
}
