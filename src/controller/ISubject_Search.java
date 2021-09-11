/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Subject_Search;

/**
 *
 * @author admin
 */
public interface ISubject_Search {
    List<Subject_Search> getSubject_Search(String name);
}
