/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Teacher_Search;

/**
 *
 * @author admin
 */
public interface ITeacher_Search {
    List<Teacher_Search> getTeacher_Search(String name);
}
