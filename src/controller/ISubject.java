/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Subject;

/**
 *
 * @author admin
 */
public interface ISubject {
    List<Subject> getSubject(String mon);
    void insertSubject(Subject sb);
    void updateSubject(Subject sb);
    void deleteSubject(int id);
    Subject find(int id);
}
