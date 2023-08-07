/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Kien Luu
 */
public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Client is Connecting");
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Client is Conect");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            while (true) {
                System.out.print("Nhap vao so thu 1: ");
                dos.writeDouble(new Scanner(System.in).nextDouble());
                dos.flush();
                System.out.print("Nhap vao so thu 2: ");
                dos.writeDouble(new Scanner(System.in).nextDouble());
                dos.flush();
                System.out.println("Tong 2 so: " + dis.readDouble());
                System.out.println("Tiep tuc? (y/n)");
                String request = new Scanner(System.in).nextLine();
                if (request.equalsIgnoreCase("n")) {
                    break;
                }
                
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
