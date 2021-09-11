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
public class Subject_Search {
    private int id;
    private String mon;
    private int idFaculty;
    private String ten_Faculty;
    private int number;

    public Subject_Search() {
    }

    public Subject_Search(int id, String mon, int idFaculty) {
        this.id = id;
        this.mon = mon;
        this.idFaculty = idFaculty;
    }
    
    public Subject_Search(int id, String mon, String ten_Faculty, int number) {
        this.id = id;
        this.mon = mon;
        this.ten_Faculty = ten_Faculty;
        this.number= number;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
    
    
}
