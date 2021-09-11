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
import model.Sem;

/**
 *
 * @author admin
 */
public class SemImp implements ISem{

    @Override
    public List<Sem> getSem(String idmon) {
        List<Sem> result = new ArrayList();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getSem()}");
        if(idmon != null){
            rs =SqlConnection.executeQuery("{call sp_seacherSem(?)}", idmon);
        }
        try {
            while (rs.next()) {
                Sem s = new Sem(rs.getInt("idFaculty"),rs.getInt("idmon"),rs.getString("name_Faculty"), rs.getString("name_mon"),  rs.getInt("sem"),rs.getInt("year"), rs.getInt("soTinchi"));
                result.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void insertSem(Sem s) {
        SqlConnection.executeUpdate("{call sp_insertSem(?,?,?,?,?)}",s.getIdFaculty(),s.getIdmon(),s.getSem(),s.getYear(),s.getSoTinchi());
    }

    @Override
    public void updateSem(Sem s) {
        SqlConnection.executeUpdate("{call sp_updateSem(?,?,?,?,?)}", s.getIdFaculty(),s.getIdmon(),s.getSem(),s.getYear(),s.getSoTinchi());
    }

    @Override
    public void deleteSem(int idmon,int idFaculty) {
        SqlConnection.executeUpdate("{call sp_deleteSem(?,?)}",idmon,idFaculty);
    }

    @Override
    public Sem find(String idmon,String idFaculty) {
        ResultSet rs = SqlConnection.executeQuery("{call sp_findSem(?,?)}", idmon,idFaculty);
        try {
            while (rs.next()) {
                Sem s = new Sem(rs.getInt("idFaculty"),rs.getInt("idmon"),rs.getString("name_Faculty"), rs.getString("name_mon"),  rs.getInt("sem"),rs.getInt("year"), rs.getInt("soTinchi"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
