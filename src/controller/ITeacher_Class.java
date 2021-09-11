/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Teacher_Class;

/**
 *
 * @author admin
 */
public interface ITeacher_Class {
    List<Teacher_Class> getTeacher_Class(String idClass);
    void insertTeacher_Class(Teacher_Class tc);
    void deleteTeacher_Class(int idgv,String idClass);
    Teacher_Class find(String idgv,String idClass);
}
