/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SeeMark;

/**
 *
 * @author admin
 */
public class SeeMarkImp implements ISeeMark{

    @Override
    public List<SeeMark> getSeeMark(String idkhoa,String className,String idSubject,String search,int sort) {
        List<SeeMark> result = new ArrayList();
        ResultSet rs = SqlConnection.executeQuery("{call sp_SearchSeeMark(?,?,?,?)}", idkhoa,className,idSubject,search);
        if (sort == 1) {
            rs = SqlConnection.executeQuery("{call sp_getSeeMarkSortByASC()}");
        }
        
        if (sort == 2) {
            rs = SqlConnection.executeQuery("{call sp_getSeeMarkSortByDESC()}");
        }
        try {
            while (rs.next()) {
                SeeMark sm = new SeeMark(rs.getString("idsv"),rs.getInt("idmon"),rs.getInt("type"),rs.getString("idFaculty"),rs.getString("lop"),rs.getString("ten"),rs.getString("id_sv"), rs.getString("name"), rs.getString("mon"), rs.getString("type_mark"), rs.getFloat("diem"), rs.getInt("lanthi"), rs.getString("ketqua"));
                result.add(sm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeeMarkImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
