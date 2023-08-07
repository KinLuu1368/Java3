/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt.lab5;

/**
 *
 * @author Kien Luu
 */
public class Student {
    String masv;
    String hoTen;
    String mail;
    String sdt;
    String diaChi;
    boolean gioiTinh;
    
    public Student() {
    }
    
    public Student (String masv, String hoTen, String mail, String sdt, String diaChi, boolean gioiTinh) {
        this.masv = masv;
        this.hoTen = hoTen;
        this.mail = mail;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }
}
