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
import model.Subject_Search;

/**
 *
 * @author admin
 */
public class SubjectSearchImp implements ISubject_Search{

    @Override
    public List<Subject_Search> getSubject_Search(String name) {
        List<Subject_Search> result = new ArrayList();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getSubjectSearch()}");
        if(name !=null){
            rs = SqlConnection.executeQuery("{call sp_Search_SubjectSearch(?)}", name);
        }
        try {
            while (rs.next()) {
                Subject_Search sb = new Subject_Search(rs.getInt("id"), rs.getString("mon"),rs.getString("ten_Faculty"),rs.getInt("number"));
                result.add(sb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectSearchImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
