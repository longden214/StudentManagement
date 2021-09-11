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
public class Sem {
    private int idFaculty;
    private int idmon;
    private int year ;
    private int sem;
    private int soTinchi;
    private String name_Faculty;
    private String name_mon;

    public Sem() {
    }

    public Sem(int idFaculty, int idmon,  int sem, int year,int soTinchi) {
        this.idFaculty = idFaculty;
        this.idmon = idmon;
        this.year = year;
        this.sem = sem;
        this.soTinchi = soTinchi;
    }
    
    public Sem(int idFaculty, int idmon,String name_Faculty, String name_mon,int sem,int year, int soTinchi) {
        this.idFaculty = idFaculty;
        this.idmon = idmon;
        this.name_Faculty = name_Faculty;
        this.name_mon = name_mon;
        this.sem = sem;
        this.year = year;
        this.soTinchi = soTinchi;
    }

    public int getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    public int getIdmon() {
        return idmon;
    }

    public void setIdmon(int idmon) {
        this.idmon = idmon;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public int getSoTinchi() {
        return soTinchi;
    }

    public void setSoTinchi(int soTinchi) {
        this.soTinchi = soTinchi;
    }

    public String getName_Faculty() {
        return name_Faculty;
    }

    public void setName_Faculty(String name_Faculty) {
        this.name_Faculty = name_Faculty;
    }

    public String getName_mon() {
        return name_mon;
    }

    public void setName_mon(String name_mon) {
        this.name_mon = name_mon;
    }
    
    
    
    
}
