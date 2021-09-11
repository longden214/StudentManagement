/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Mark_Type;

/**
 *
 * @author admin
 */
public interface IMark_Type {
    List<Mark_Type> getMark_Type(String name);
    void insert(Mark_Type mt);
    void update(Mark_Type mt);
    void delete(int id);
    Mark_Type find(int id);
    Mark_Type result(int id);
}
