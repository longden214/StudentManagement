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
import model.Mark;

/**
 *
 * @author admin
 */
public class MarkImp implements IMark{

    @Override
    public List<Mark> getMark(String search) {
        List<Mark> result = new ArrayList();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getMark()}");
        if(search != null){
            rs = SqlConnection.executeQuery("{call sp_searchMark(?)}", search);
        }
        try {
            while (rs.next()) {
                Mark m = new Mark(rs.getString("idsv"),rs.getInt("idmon"),rs.getInt("type"),rs.getString("id_sv"), rs.getString("mon"), rs.getString("name"),rs.getString("lop"), rs.getString("type_mark"), rs.getFloat("diem"), rs.getInt("lanthi"), rs.getString("ketqua"));
                result.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarkImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void insertMark(Mark m) {
        SqlConnection.executeUpdate("{call sp_insertMark(?,?,?,?,?,?)}",m.getIdsv(),m.getIdmon(),m.getType(),m.getDiem(),m.getLanthi(),m.getKetqua());
    }

    @Override
    public void updateMark(Mark m) {
        SqlConnection.executeUpdate("{call sp_updateMark(?,?,?,?,?,?)}",m.getIdsv(),m.getIdmon(),m.getType(),m.getDiem(),m.getLanthi(),m.getKetqua());
    }  

    @Override
    public Mark find(String idsv, String idmon, String type,int lanthi) {
        ResultSet rs = SqlConnection.executeQuery("{call sp_findMark(?,?,?,?)}", idsv,idmon,type,lanthi);
        try {
            while (rs.next()) {
                Mark m = new Mark(rs.getString("idsv"),rs.getInt("idmon"),rs.getInt("type"),rs.getString("id_sv"), rs.getString("mon"), rs.getString("name"),rs.getString("lop"), rs.getString("type_mark"), rs.getFloat("diem"), rs.getInt("lanthi"), rs.getString("ketqua"));
                return m;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarkImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
