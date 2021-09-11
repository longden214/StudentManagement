/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.SeeMark;

/**
 *
 * @author admin
 */
public interface ISeeMark {
    List<SeeMark> getSeeMark(String idkhoa,String className,String idSubject,String search,int sort);
}
