package br.edu.utfpr.tcp;

import java.io.*;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Cliente {

    public static void main(String[] args) {
        try {
            Socket conexao = new Socket("Localhost", 5000);
            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());            
            String informacao = JOptionPane.showInputDialog("Digite a frase");            
            while (!informacao.equals("fim")) {
                saida.writeUTF(informacao);
                System.out.println("Resposta do servidor: " + entrada.readUTF());
                informacao = JOptionPane.showInputDialog("Digite a frase");
            }
            saida.writeUTF(informacao);
            conexao.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
