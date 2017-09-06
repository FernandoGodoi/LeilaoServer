/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.leilaoserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author TI
 */
public class Conexao extends Thread {
    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    String nome;
    double lance;
    LeilaoItem leilao;
    
    public Conexao(Socket aClientSocket, LeilaoItem leilao) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            nome = "";
            this.leilao = leilao;
            
        } catch (IOException e) {
            System.out.println("Connection: "+e.getMessage());
        }
    }
    public void send(String data) throws IOException{
        out.writeUTF(data);
    }

    @Override
    public String toString() {
        return this.nome+ "Valor "+this.lance; //To change body of generated methods, choose Tools | Templates.
    }
    
    public void run() {
        try {
            String data = in.readUTF();
            nome = data;
            data = leilao.produto.toString();
            out.writeUTF(data);
            
            while (true) {
                /* Receive message from client */
                data = in.readUTF();
                System.out.print("\n\t[Receive - "+clientSocket.getInetAddress().toString()
                        +":"+clientSocket.getPort()+"]: "+data);
                this.lance = Double.parseDouble(data);
                leilao.atualizarLance();
                /* Send the response to client */
                data = "ACK";
                out.writeUTF(data);
            
            }
            
            
        } catch (IOException e) {
            System.out.println("IO: "+e.getMessage());
        }
    }
}