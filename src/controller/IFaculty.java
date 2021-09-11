/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Faculty;

/**
 *
 * @author admin
 */
public interface IFaculty {
    List<Faculty> getFaculty(String search);
    Faculty find(int id);
    void addCourse(Faculty f);
    void editCourse(Faculty f);
    void remove(int id);
}
