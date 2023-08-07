/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bt.lab7.Demo;

import java.net.InetAddress;

/**
 *
 * @author Kien Luu
 */
public class FindHost {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            InetAddress[] address = InetAddress.getAllByName("phongthuythaonguyen.com");
            for (int i=0; i < address.length; i++) {
                System.out.println("Address " + (i+1)+": " + address[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
