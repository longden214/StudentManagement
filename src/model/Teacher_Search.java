/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class Teacher_Search {
    private int idgv;
    private String hoten;
    private String phone;
    private String email;
    private Boolean gender;
    private Date ngaysinh;
    private String number_Class;
    private int number_Subject;

    public Teacher_Search() {
    }

    public Teacher_Search(int idgv, String hoten, String phone, String email, Boolean gender, Date ngaysinh) {
        this.idgv = idgv;
        this.hoten = hoten;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.ngaysinh = ngaysinh;
    }
    
    public Teacher_Search(int idgv, String hoten, String phone, String email, Boolean gender, Date ngaysinh, String number_Class, int number_Subject) {
        this.idgv = idgv;
        this.hoten = hoten;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.ngaysinh = ngaysinh;
        this.number_Class = number_Class;
        this.number_Subject = number_Subject;
    }

    public int getIdgv() {
        return idgv;
    }

    public void setIdgv(int idgv) {
        this.idgv = idgv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getNumber_Class() {
        return number_Class;
    }

    public void setNumber_Class(String number_Class) {
        this.number_Class = number_Class;
    }

    public int getNumber_Subject() {
        return number_Subject;
    }

    public void setNumber_Subject(int number_Subject) {
        this.number_Subject = number_Subject;
    }
    
    
}
