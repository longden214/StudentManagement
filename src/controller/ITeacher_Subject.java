/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Teacher_Subject;

/**
 *
 * @author admin
 */
public interface ITeacher_Subject {
    List<Teacher_Subject> getTeacher_Subject(String name);
    void insertTeacher_Subject(Teacher_Subject ts);
    void deleteTeacher_Subject(int idgv,int idsbj);
    Teacher_Subject find(String idgv,String idsbj);
}
