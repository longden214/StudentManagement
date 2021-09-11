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
public class Teacher_Subject {
    private int idgv;
    private int idsb;
    private String nameGV;
    private String name_Subject;

    public Teacher_Subject() {
    }

    public Teacher_Subject(int idgv, int idsb, String nameGV, String name_Subject) {
        this.idgv = idgv;
        this.idsb = idsb;
        this.nameGV = nameGV;
        this.name_Subject = name_Subject;
    }


    public int getIdgv() {
        return idgv;
    }

    public void setIdgv(int idgv) {
        this.idgv = idgv;
    }

    public int getIdsb() {
        return idsb;
    }

    public void setIdsb(int idsb) {
        this.idsb = idsb;
    }

    public String getNameGV() {
        return nameGV;
    }

    public void setNameGV(String nameGV) {
        this.nameGV = nameGV;
    }

    public String getName_Subject() {
        return name_Subject;
    }

    public void setName_Subject(String name_Subject) {
        this.name_Subject = name_Subject;
    }

    
    
}
