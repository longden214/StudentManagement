/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Teacher;

/**
 *
 * @author admin
 */
public interface ITeacher {
    List<Teacher> getTeacher(String name);
    void insertTeacher(Teacher t);
    void updateTeacher(Teacher t);
    void delete(int idgv);
    Teacher find(int idgv);
    
}
