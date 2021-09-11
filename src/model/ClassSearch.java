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
public class ClassSearch {
    private String className;
    private int facultyId;
    private String course;
    private String Faculty_Name;
    private int khoa;
    private int ma;

    public ClassSearch() {
    }

    public ClassSearch(String className, int facultyId, String course) {
        this.className = className;
        this.facultyId = facultyId;
        this.course = course;
    }
    public ClassSearch(String className, String Faculty_Name, String course,int khoa,int ma) {
        this.className = className;
        this.Faculty_Name = Faculty_Name;
        this.course = course;
        this.khoa=khoa;
        this.ma=ma;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFaculty_Name() {
        return Faculty_Name;
    }

    public void setFaculty_Name(String Faculty_Name) {
        this.Faculty_Name = Faculty_Name;
    }

    public int getKhoa() {
        return khoa;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }
    
    
    
    
}
