package utfpr.edu.br.udp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

    public static DatagramSocket dgConexao;
    public static DatagramPacket dgPacote;

    public static InetAddress endereco;
    
    static long fibonacci(int valor) {
        if (valor < 2) {
            return valor;
        } else {
            return fibonacci(valor - 1) + fibonacci(valor - 2);
        }
    }

    public static void main(String[] args) {

        try {

            dgConexao = new DatagramSocket(10000);

            byte[] msg = new byte[2];

            dgPacote = new DatagramPacket(msg, msg.length);

            System.out.println("Servidor pronto...");

            dgConexao.receive(dgPacote);
            
            String temp = new String(msg);
            
            System.out.println("Valor "+temp);
            
            int solicitacao = Integer.parseInt(temp);
            
            System.out.println("Valor "+solicitacao);
            
            for (int i = 0; i < solicitacao; i++) {
            
                endereco = dgPacote.getAddress();
                int porta = dgPacote.getPort();

                System.out.println("Porta = " + porta);

                msg = new byte[128];
                msg = String.valueOf(fibonacci(i)).getBytes();

                dgPacote = new DatagramPacket(msg, msg.length, endereco, porta);
                dgConexao.send(dgPacote);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
