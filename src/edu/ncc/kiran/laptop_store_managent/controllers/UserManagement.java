/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import edu.ncc.kiran.laptop_store_managent.models.RoleInfo;
import edu.ncc.kiran.laptop_store_managent.models.UserInfo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kiran
 */
public class UserManagement extends Database {

    private RoleManagement roleMgmt;

    public UserManagement() {
        roleMgmt = new RoleManagement();
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;
    }

    public UserInfo verifyUsers(UserInfo user) {
        UserInfo objUserInfo = null;
        try {
//            Database db = new Database();
//            db.GetDbConnection();
            String sql = "SELECT * FROM tbl_user WHERE login_name = ? and login_password = ?";
            this.pstat = conn.prepareStatement(sql);
            this.pstat.setString(1, user.getLogin_name());
            this.pstat.setString(2, user.getLogin_password());
            this.rs = this.pstat.executeQuery();
            while (rs.next()) {
                objUserInfo = new UserInfo();
                objUserInfo.setUser_id(this.rs.getInt("user_id"));
                objUserInfo.setLogin_name(this.rs.getString("login_name"));

                int roleId = this.rs.getInt("role_id");
                RoleInfo userRole = roleMgmt.searchRoleById(roleId);
                objUserInfo.setRoleInfo(userRole);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objUserInfo;
    }
}
