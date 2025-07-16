/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mhjuice_management;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author RIFQY
 */
public class koneksi {
     private Connection con;
    
    public void connect (){
        try {
            String url="jdbc:mysql://localhost/mh_jus"; 
            String username_xampp = "root";
            String password = "";
            con = DriverManager.getConnection(url,username_xampp, password);
            System.out.println("Koneksi berhasil");
           // JOptionPane.showMessageDialog(null, "Koneksi Berhasil!");
        } catch (Exception e) {
            e.printStackTrace();
            con = null;
        }
    }
    
    public Connection getCon() {
        return con;
    }
}
