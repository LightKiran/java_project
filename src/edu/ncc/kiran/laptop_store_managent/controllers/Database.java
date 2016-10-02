/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author kiran
 */
public class Database {

    private String pc_name;
    private String db_name;
    private String user_name;
    private String password;
    private String driver;
    //private String sql;
    public static Connection conn;
    protected PreparedStatement pstat = null;
    protected ResultSet rs = null;

    public Database() {
        pc_name = "localhost";
        db_name = "c_00158132_kiran_duwal_laptop_store";
        user_name = "root";
        password = "";
        driver = "com.mysql.jdbc.Driver";
//        sql = "";
//        conn = null;
//        pstat = null;
    }

    public Database(String pc_name, String db_name, String user_name,
            String password, String driver) {
        this.pc_name = pc_name;
        this.db_name = db_name;
        this.user_name = user_name;
        this.password = password;
        this.driver = driver;
//        this.sql = "";
//        this.conn = null;
//        this.pstat = null;
    }

    public void GetDbConnection() {
        try {
            Class.forName(driver);
            
            this.conn = DriverManager.getConnection("jdbc:mysql://" + pc_name + "/"
                    + db_name, user_name, password);
            System.out.println("Connected to database");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please start your localhost and try again");
            System.out.println("Error : " + ex.getMessage());
        }
    }

    public void CloseDbConnection() {
        try {
            this.conn.close();
            System.out.println("Database connection close");
        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
    }
/*
    public String getPc_name() {
        return pc_name;
    }

    public void setPc_name(String pc_name) {
        this.pc_name = pc_name;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /*
     public Connection getConn() {
     return conn;
     }

     public void setConn(Connection conn) {
     this.conn = conn;
     }*/

/*
    protected static Connection conn = null;
    protected PreparedStatement pstat = null;
    protected ResultSet rs = null;

    public void GetDbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successful");
           // if (conn == null) {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp_00158132_kiran_duwal_batch14a", "root", "");
                System.out.println("connected to db.");
            //}
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Driver load failed.");
        } catch (SQLException ex) {
            System.out.println("Could not connect to db.");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
