/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import static edu.ncc.kiran.laptop_store_managent.controllers.Database.conn;
import edu.ncc.kiran.laptop_store_managent.models.RoleInfo;
import edu.ncc.kiran.laptop_store_managent.models.UserInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kiran
 */
public class UserManagement extends Database {

    private RoleManagement roleMgmt;

    public UserManagement() { // initializing default constructor
        roleMgmt = new RoleManagement();
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;
    }

    public boolean createNewUser(UserInfo user) { // for creating new users
        boolean isUserCreated = false;
        try {
            String query = "INSERT INTO tbl_user VALUES(null,?,?,?,?,?,?,?,?,?)";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setString(1, user.getFirst_name());
            this.pstat.setString(2, user.getMiddle_name());
            this.pstat.setString(3, user.getLast_name());
            this.pstat.setString(4, user.getContact_no());
            this.pstat.setString(5, user.getAddress());
            this.pstat.setString(6, user.getEmail());
            this.pstat.setString(7, user.getLogin_name());
            this.pstat.setString(8, user.getLogin_password());
            try {
                this.pstat.setInt(9, user.getRoleInfo().getRole_id());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "please select role");
                return isUserCreated;
            }

            int insert = this.pstat.executeUpdate();

            if (insert > 0) {
                isUserCreated = true;
            } 

        } catch (SQLException ex) {
            System.out.println("ERROR1" + ex);
            JOptionPane.showMessageDialog(null, "login name already exist try another");
            return isUserCreated;
        } finally {
            try {
                this.pstat.close();
            } catch (SQLException ex) {
                System.out.println("ERROR" + ex);

            }
        }
        return isUserCreated;
    }

    public UserInfo verifyUsers(UserInfo user) { // to verify user during login process
        UserInfo objUserInfo = null;
        try {
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

    public ArrayList<UserInfo> listAllUsers() { // to list all users from table 
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;

        ArrayList<UserInfo> objUserInfo = new ArrayList<UserInfo>();

        try {
            String query = "select * from tbl_user";
            this.pstat = this.conn.prepareStatement(query);
            this.rs = this.pstat.executeQuery();

            while (rs.next()) {
                UserInfo pg = new UserInfo();
                pg.setUser_id(this.rs.getInt("user_id"));
                pg.setFirst_name(this.rs.getString("first_name"));
                pg.setMiddle_name(this.rs.getString("middle_name"));
                pg.setLast_name(this.rs.getString("last_name"));
                pg.setContact_no(this.rs.getString("contact_no"));
                pg.setAddress(this.rs.getString("address"));
                pg.setEmail(this.rs.getString("email"));
                pg.setEmail(this.rs.getString("login_name"));
                pg.setEmail(this.rs.getString("login_password"));

                int lapId = this.rs.getInt("role_id");
                SupCtrl supCtrl = new SupCtrl();
                RoleInfo objRoleInfo = supCtrl.searchRoleById(lapId);
                pg.setRoleInfo(objRoleInfo);
                objUserInfo.add(pg);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objUserInfo;
    }

    public ArrayList<UserInfo> listLatestUsers() { // list latest user from table
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;

        ArrayList<UserInfo> objUserInfo = new ArrayList<UserInfo>();

        try {
            String query = "select * from tbl_user order by user_id desc limit 2";
            this.pstat = this.conn.prepareStatement(query);
            this.rs = this.pstat.executeQuery();

            while (rs.next()) {
                UserInfo pg = new UserInfo();
                pg.setUser_id(this.rs.getInt("user_id"));
                pg.setFirst_name(this.rs.getString("first_name"));
                pg.setMiddle_name(this.rs.getString("middle_name"));
                pg.setLast_name(this.rs.getString("last_name"));
                pg.setContact_no(this.rs.getString("contact_no"));
                pg.setAddress(this.rs.getString("address"));
                pg.setEmail(this.rs.getString("email"));
                pg.setEmail(this.rs.getString("login_name"));
                pg.setEmail(this.rs.getString("login_password"));

                int lapId = this.rs.getInt("role_id");
                SupCtrl supCtrl = new SupCtrl();
                RoleInfo objRoleInfo = supCtrl.searchRoleById(lapId);
                pg.setRoleInfo(objRoleInfo);
                objUserInfo.add(pg);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objUserInfo;
    }

    public boolean updateUser(UserInfo userInfo) { // to update user information

        String sql = "update tbl_user set first_name=?, middle_name=?, last_name=?, contact_no=?, address=?, email=?, login_name=?, login_password=?, role_id=? where user_id=?";
        boolean res = false;
        try {
            GetDbConnection();
            pstat = this.conn.prepareStatement(sql);
            pstat.setString(1, userInfo.getFirst_name());
            pstat.setString(2, userInfo.getMiddle_name());
            pstat.setString(3, userInfo.getLast_name());
            pstat.setString(4, userInfo.getContact_no());
            pstat.setString(5, userInfo.getAddress());
            pstat.setString(6, userInfo.getEmail());
            pstat.setString(7, userInfo.getLogin_name());
            pstat.setString(8, userInfo.getLogin_password());
            pstat.setInt(9, userInfo.getRoleInfo().getRole_id());
            pstat.setInt(10, userInfo.getUser_id());

            pstat.executeUpdate();
            pstat.close();
            CloseDbConnection();
            res = true;
        } catch (Exception ex) {
            res = false;
            System.out.println("Error: " + ex.getMessage());
        }
        return (res);
    }

    public boolean deleteUser(UserInfo userInfo) { // to delete user from table

        String sql = "delete from tbl_user where user_id = ?";
        boolean res = false;
        try {
            GetDbConnection();
            pstat = this.conn.prepareStatement(sql);
            pstat.setInt(1, userInfo.getUser_id());

            pstat.executeUpdate();
            pstat.close();
            CloseDbConnection();
            res = true;
        } catch (Exception ex) {
            res = false;
            System.out.println("Error: " + ex.getMessage());
        }
        return (res);
    }
}
