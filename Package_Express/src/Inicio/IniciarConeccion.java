/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jhonny
 */
public class IniciarConeccion {
    public static Connection connection ;
    public int a;
   
    public static void IniciarConeccion(){
    	String user = "root";
		String password = "isma2001";
		String stringConnection = "jdbc:mysql://localhost:3306/PACKAGE_EXPRESS";

        try {
            connection = DriverManager.getConnection(stringConnection, user, password);
        } catch (SQLException ex) {
        System.out.println("Fallo");
        }
            
    }

    public static Connection getConnection() {
        return connection;
    }
    
}
