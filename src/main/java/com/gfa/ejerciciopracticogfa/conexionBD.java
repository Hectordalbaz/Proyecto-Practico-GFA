/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gfa.ejerciciopracticogfa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hecto
 */
public class conexionBD {
    String host = "localhost", puerto = "3306", bd = "usuarios", usuario = "root", cont = "root";
     public Connection conexion(){
         Connection con = null;
           try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + bd + "", usuario, cont);
        } catch (ClassNotFoundException | SQLException e) {
        }
           return con;
     }
    
}
