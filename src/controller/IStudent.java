/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Student;

/**
 *
 * @author admin
 */
public interface IStudent {
    List<Student> getStudent(String search);
    Student find(String id);
    void insert(Student t);
    void update(Student t);
    void delete(String id);
}
