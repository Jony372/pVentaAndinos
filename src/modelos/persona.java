/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.sql.*;

public class persona {
    
    private static String ID, Nombre, aPat, aMat, telefono, fNac;

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        persona.ID = ID;
    }

    public static String getNombre() {
        return Nombre;
    }

    public static void setNombre(String Nombre) {
        persona.Nombre = Nombre;
    }

    public static String getaPat() {
        return aPat;
    }

    public static void setaPat(String aPat) {
        persona.aPat = aPat;
    }

    public static String getaMat() {
        return aMat;
    }

    public static void setaMat(String aMat) {
        persona.aMat = aMat;
    }
    
    public static String getTelefono() {
        return telefono;
    }

    public static void setTelefono(String telefono) {
        persona.telefono = telefono;
    }

    public static String getfNac() {
        return fNac;
    }

    public static void setfNac(String fNac) {
        persona.fNac = fNac;
    }

    
}
