/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class Subject {
    private int id;
    private String mon;
    private int idFaculty;
    private String ten_Faculty;

    public Subject() {
    }

    public Subject(int id, String mon, int idFaculty) {
        this.id = id;
        this.mon = mon;
        this.idFaculty = idFaculty;
    }
    
    public Subject(int id, String mon, String ten_Faculty) {
        this.id = id;
        this.mon = mon;
        this.ten_Faculty = ten_Faculty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public int getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getTen_Faculty() {
        return ten_Faculty;
    }

    public void setTen_Faculty(String ten_Faculty) {
        this.ten_Faculty = ten_Faculty;
    }

    @Override
    public String toString() {
        return mon ;
    }
    
}
