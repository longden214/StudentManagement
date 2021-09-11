/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Class;
import java.util.List;

/**
 *
 * @author admin
 */
public interface IClass {
    List<Class> getClass(String search);
    Class find(String id);
    void addClass(Class c);
    void editClass(Class c);
    void removeClass(String id);
}
