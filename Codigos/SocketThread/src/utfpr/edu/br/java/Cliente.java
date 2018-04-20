package utfpr.edu.br.java;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;


public class Cliente {
    
    private static Socket socket;
    
    private static DataInputStream entrada;
    private static DataOutputStream saida;
    
    public static void main(String[] args) {
        
        try {
            
            socket = new Socket("127.0.0.1", 50000);
            
            entrada = new DataInputStream(socket.getInputStream());
            saida = new DataOutputStream(socket.getOutputStream());
            
            
            String frase = JOptionPane.showInputDialog("Digite um valor");
            
            saida.writeUTF(frase);
            
            String novaFrase = entrada.readUTF();
            
            System.out.println(novaFrase);
            JOptionPane.showMessageDialog(null, novaFrase);
            
            socket.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
