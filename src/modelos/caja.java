/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.sql.*;

public class caja {
    private static String ID;
    private static Double cantidad=0.0, dinInicial;
    private static Date fecha;

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        caja.ID = ID;
    }

    public static Double getCantidad() {
        return cantidad;
    }

    public static void setCantidad(Double cantidad) {
        caja.cantidad += cantidad;
    }

    public static Double getDinInicial() {
        return dinInicial;
    }

    public static void setDinInicial(Double dinInicial) {
        caja.dinInicial = dinInicial;
    }

    public static Date getFecha() {
        return fecha;
    }

    public static void setFecha(Date fecha) {
        caja.fecha = fecha;
    }

    
    
}
