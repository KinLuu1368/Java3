/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Kien Luu
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Servere is connecting");
            Socket socket = serverSocket.accept();
            System.out.println("Server is conect");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            while (true) {
                double number1 = dis.readDouble();
                double number2 = dis.readDouble();
                System.out.println("2 numbers get from client is " + number1 + " and " + number2);
                double sum = number1 + number2;
                dos.writeDouble(sum);
                dos.flush();
                System.out.println("Sum of 2 numbers is " + sum);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
}
