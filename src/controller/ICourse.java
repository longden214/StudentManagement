/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Course;

/**
 *
 * @author admin
 */
public interface ICourse {
    List<Course> getCourse(String search);
    Course find(String ma);
    void addCourse(Course c);
    void editCourse(Course c);
    void remove(String ma);
}
