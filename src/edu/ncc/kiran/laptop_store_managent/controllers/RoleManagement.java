/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;
import edu.ncc.kiran.laptop_store_managent.models.RoleInfo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Prashanna
 */
public class RoleManagement extends Database{
    
    public RoleInfo searchRoleById(int id){
        RoleInfo role = null;
        try {
            String query = "SELECT * FROM tbl_role WHERE role_id = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setInt(1, id);
            this.rs = this.pstat.executeQuery();
            while(this.rs.next()){
                role = new RoleInfo();
                role.setRole_id(this.rs.getInt("role_id"));
                role.setRole_type(this.rs.getString("role_type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.rs.close();
                this.pstat.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoleManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return role;
    }
    
    
   /* public Role findRoleByName(String name){
        Role role = null;
        try {
            String query = "SELECT * FROM role WHERE name = ?";
            this.pstat = this.con.prepareStatement(query);
            this.pstat.setString(1, name);
            this.rs = this.pstat.executeQuery();
            while(this.rs.next()){
                role = new Role();
                role.setId(this.rs.getInt("id"));
                role.setName(this.rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.rs.close();
                this.pstat.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return role;
    }*/
    
}
