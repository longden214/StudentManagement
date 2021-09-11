/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.ClassSearch;

/**
 *
 * @author admin
 */
public interface IClass_Search {
    List<ClassSearch> getClassSearch(String name);
}
