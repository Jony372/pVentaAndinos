/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import java.sql.*;
import javax.swing.JOptionPane;

public class SQLconector {
    private static String bd = "pVentaAnd";
    private static String login = "root";
    private static String password = "12345678";
    private static String url = "jdbc:mysql://localhost:3306/"+bd;
    
    public static Connection conectar(){
        Connection cn;
        try {
            cn = DriverManager.getConnection(url,login,password);
            System.out.println("Se conecto a la base de datos");
            return cn;
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error de conexion local", "ERROR", 2);
            System.exit(1);
        }
        return null;
    }
    
}
