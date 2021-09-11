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
import model.User;

/**
 *
 * @author admin
 */
public class UserDao {
    public List<User> getAllUser(String name){
        List<User> data = new ArrayList<>();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getAdmin()}");
        
        if (name != null) {
            rs = SqlConnection.executeQuery("{call sp_getfindAdminAll(?)}",name);
        }
        
        try {
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("ten"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                
                data.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    public User findUser(int id){
        ResultSet rs = SqlConnection.executeQuery("{call sp_getFUser(?)}",id);
        try {
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("ten"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void addUser(User u){
        SqlConnection.executeUpdate("{call addUser(?,?,?)}",u.getUserName(),u.getPassword(),u.getRole());
    }
    
    public void editUser(User u){
        SqlConnection.executeUpdate("{call sp_editUser(?,?,?)}",u.getId(),u.getUserName(),u.getPassword());
    }
    
    public void removeUser(int id){
        SqlConnection.executeUpdate("{call sp_removeUser(?)}",id);
    }
}
