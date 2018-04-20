package br.edu.utfpr.tcp;

import java.io.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor extends Thread {

    private Socket socket;

    public Servidor(Socket conexao) {
        this.socket = conexao;
    }

    public void run() {
        
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            String resultado = entrada.readUTF();
            while (!resultado.equals("fim")) {                
                System.out.println("Enviando na porta " + socket.getPort()+" do cliente "+resultado);
                saida.writeUTF(resultado.toUpperCase());  
                resultado = entrada.readUTF();
                System.out.println("Resultado "+resultado);
            }
            System.out.println("Clience se desconectou...");
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Aguardando conexões...");
            while (true) {
                Socket conexao = servidor.accept();
                Servidor sThread = new Servidor(conexao);
                System.out.println("Clience se conectou...");
                sThread.start();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
