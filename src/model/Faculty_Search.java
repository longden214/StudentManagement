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
public class Faculty_Search {
    private int id;
    private String khoa;
    private int year;
    private int number_Teacher;

    public Faculty_Search() {
    }

    public Faculty_Search(int id, String khoa, int year) {
        this.id = id;
        this.khoa = khoa;
        this.year = year;
    }
    public Faculty_Search(int id, String khoa, int year,int number_Teacher) {
        this.id = id;
        this.khoa = khoa;
        this.year = year;
        this.number_Teacher=number_Teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getkhoa() {
        return khoa;
    }

    public void setkhoa(String khoa) {
        this.khoa = khoa;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumber_Teacher() {
        return number_Teacher;
    }

    public void setNumber_Teacher(int number_Teacher) {
        this.number_Teacher = number_Teacher;
    }
    
    
}
