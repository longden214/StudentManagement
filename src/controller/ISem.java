/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Sem;

/**
 *
 * @author admin
 */
public interface ISem {
    List<Sem> getSem(String idmon);
    void insertSem(Sem s);
    void updateSem(Sem s);
    void deleteSem(int idmon,int idFaculty);
    Sem find(String idmon,String idFaculty);
}
