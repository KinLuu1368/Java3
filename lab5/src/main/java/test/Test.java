/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.sql.Connection;

import controller.DemoConect;

/**
 *
 * @author Kien Luu
 */
public class Test {
    public static void main(String[] args) {
        Connection conection = DemoConect.getConnection();
        System.out.println(conection);
    }
}
