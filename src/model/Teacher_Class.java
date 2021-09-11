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
public class Teacher_Class {
    private int idgv;
    private String name_gv;
    private String name_Class;

    public Teacher_Class() {
    }

    public Teacher_Class(int idgv, String idClass) {
        this.idgv = idgv;
        this.name_Class = idClass;
    }
    
    public Teacher_Class(String name_gv, String name_Class) {
        this.name_gv = name_gv;
        this.name_Class = name_Class;
    }

    public int getIdgv() {
        return idgv;
    }

    public void setIdgv(int idgv) {
        this.idgv = idgv;
    }

    public String getNameGV() {
        return name_gv;
    }

    public void setNameGV(String name_gv) {
        this.name_gv = name_gv;
    }

    public String getName_Class() {
        return name_Class;
    }

    public void setName_Class(String name_Class) {
        this.name_Class = name_Class;
    }

    
}
