/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GD1;

/**
 *
 * @author Kien Luu
 */
public class Student {
    String maSV;
    String name;
    String mail;
    String phone;
    Boolean Gender;
    String address;
    String img;
    Double enScore;
    Double ITScore;
    Double GDTCScore;
    
    public Student() {}
    
    public Student(String maSV, String name, String mail, String phone, Boolean Gender, String address, String img) {
        this.maSV = maSV;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.Gender = Gender;
        this.address = address;
        this.img = img;
    }
    
    public Student(String maSV, String name, Double enScore, Double ITScore, Double GDTCScore) { 
        this.maSV = maSV;
        this.name = name;
        this.enScore = enScore;
        this.ITScore = ITScore;
        this.GDTCScore = GDTCScore;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getGender() {
        return Gender;
    }

    public void setGender(Boolean Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getEnScore() {
        return enScore;
    }

    public void setEnScore(Double enScore) {
        this.enScore = enScore;
    }

    public Double getITScore() {
        return ITScore;
    }

    public void setITScore(Double ITScore) {
        this.ITScore = ITScore;
    }

    public Double getGDTCScore() {
        return GDTCScore;
    }

    public void setGDTCScore(Double GDTCScore) {
        this.GDTCScore = GDTCScore;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
        
    
}
