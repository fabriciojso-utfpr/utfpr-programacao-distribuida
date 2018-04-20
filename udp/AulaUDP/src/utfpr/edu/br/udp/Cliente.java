package utfpr.edu.br.udp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;

public class Cliente {

    public static DatagramSocket dgConexao;
    public static DatagramPacket dgPacote;

    public static InetAddress endereco;

    public static void main(String[] args) {

        try {

            dgConexao = new DatagramSocket();
            byte[] msg = new byte[2];

            String solicitacao = JOptionPane.showInputDialog("Digite o número de iterações");            

            int resposta = Integer.valueOf(solicitacao);

            msg = String.valueOf(solicitacao).getBytes();
            
            String temp = new String(msg);
            
            int temp2 = Integer.parseInt(temp);

            System.out.println("Mensagem " + temp2);

            endereco = InetAddress.getByName("localhost");

            dgPacote = new DatagramPacket(msg, msg.length, endereco, 10000);

            dgConexao.send(dgPacote);

            System.out.println("Mensagem enviada...");

            for (int i = 0; i < resposta; i++) {
                msg = new byte[128];

                dgPacote = new DatagramPacket(msg, msg.length);

                dgConexao.receive(dgPacote);

                String dado = new String(dgPacote.getData());
                System.out.println("Iteracao " + i + " = " + dado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
