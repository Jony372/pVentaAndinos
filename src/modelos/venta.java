/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

public class venta {
    private static String ID, ID_producto, nameProducto, ID_venta, ID_sabor, saborProd;
    private static int cant, totalCantidad=0;
    private static double precio, totalProd, total=0;

    public static int getTotalCantidad() {
        return totalCantidad;
    }

    public static void setTotalCantidad() {
        venta.totalCantidad += cant;
    }
    
    public static void reinTC(){
        totalCantidad = 0;
    }

    public static Object[] datosTabla(){
        totalProd = precio*cant;
        saborProd = sabor.getFlavor();
        return new Object[]{ID_producto,nameProducto, sabor.getId(), saborProd,precio,cant, totalProd};
    }

    public static String getSaborProd() {
        return saborProd;
    }

    public static void setSaborProd(String saborProd) {
        venta.saborProd = saborProd;
    }
    
    public static double getTotalProd() {
        return totalProd;
    }

    public static void setTotalProd(double totalProd) {
        venta.totalProd = totalProd;
    }

    public static double getTotal() {
        return total;
    }
    
    public static void reinTotal(){
        venta.total = 0.0;
    }

    public static void setTotal(double total) {
        venta.total += total;
    }
    
    public static void editarTotal(double total) {
        venta.total -= total;
    }
    
    public static String getID() {
        return ID;
    }

    public static String getNameProducto() {
        return nameProducto;
    }

    public static void setNameProducto(String nameProducto) {
        venta.nameProducto = nameProducto;
    }

    public static void setID(String ID) {
        venta.ID = ID;
    }

    public static String getID_producto() {
        return ID_producto;
    }

    public static void setID_producto(String ID_producto) {
        venta.ID_producto = ID_producto;
    }

    public static String getID_venta() {
        return ID_venta;
    }

    public static void setID_venta(String ID_venta) {
        venta.ID_venta = ID_venta;
    }

    public static String getID_sabor() {
        return ID_sabor;
    }

    public static void setID_sabor(String ID_sabor) {
        venta.ID_sabor = ID_sabor;
    }

    public static int getCant() {
        return cant;
    }

    public static void setCant(int cant) {
        venta.cant = cant;
    }

    public static double getPrecio() {
        return precio;
    }

    public static void setPrecio(double precio) {
        venta.precio = precio;
    }
    
}
