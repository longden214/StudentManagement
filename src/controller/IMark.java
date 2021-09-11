/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Mark;

/**
 *
 * @author admin
 */
public interface IMark {
    List<Mark> getMark(String search);
    void insertMark(Mark m);
    void updateMark(Mark m);
    Mark find(String idsv,String idmon,String type,int lanthi);
}
