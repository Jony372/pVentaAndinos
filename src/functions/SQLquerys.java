/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelos.*;
public class SQLquerys {
    
    private static DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE;
    public static LocalDate fecha;
    private static LocalTime hora;
    
    
    private static final Connection cn = SQLconector.conectar();
    
    public static boolean login(String username, String pass){
        
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM usuario WHERE Nombre = '"+username+"' AND Password = '"+pass+"'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuarios.setID(rs.getString("ID"));
                usuarios.setnUsuario(rs.getString("Nombre"));
                usuarios.setTipo(rs.getInt("Permiso"));
                ps = cn.prepareStatement("SELECT * FROM Persona WHERE ID = '"+rs.getString("Persona")+"'");
                rs = ps.executeQuery();
                if (rs.next()) {
                    usuarios.setNombre(rs.getString("Nombre"));
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: "+e.toString());
        }
        
        return false;
    }
    
    public static boolean canUseNombre(String tabla, String name){
        
        try {
            System.out.println("SELECT * FROM "+tabla+" WHERE Nombre = '"+name+"' AND Estado = 1");
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM "+tabla+" WHERE Nombre = '"+name+"' AND Estado = 1");
            ResultSet rs = ps.executeQuery();
            return !rs.next();
        } catch (SQLException e) {
            System.err.println("Error en canusenombre: "+e.toString());
        }
        return false;
    }
    
    public static void insertProductos(String id, String Name, double precio, int exist, String tipo, Double gasGar){
        
        try{
            PreparedStatement ps = cn.prepareStatement("INSERT INTO Producto VALUES ('"+id+"','"+Name+"',"+precio+","+exist+",'"+tipo+"',"+gasGar+", 1)");
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                JOptionPane.showMessageDialog(null, "Se a registrado el producto");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el producto");
            }
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null, "ERROR\nID duplicado, use otro por favor", "ID duplicado", 2);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error inesperado\nrevise que los datos esten correctos", "ERROR", 2);
            System.err.println("Error: "+e);
        }
    }
    
    public static DefaultTableModel llenarTablaProducto(DefaultTableModel dtm){
        dtm.setRowCount(0);
        
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM Producto WHERE Estado = 1 ORDER BY Nombre");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Object[] fila = new Object[6];
                fila[0]=rs.getString("ID");
                fila[1]=rs.getString("Nombre");
                fila[2]=rs.getString("Tipo");
                fila[3]=rs.getDouble("Precio");
                fila[4]=rs.getInt("Existencias");
                fila[5]=rs.getInt("Gasto_Garrafa");
                dtm.addRow(fila);
            }
            return dtm;
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
        return dtm;
    }
    
    public static void editarProducto(String wid, String id, String Name, double precio, int exist, String tipo, int gasGar){
        try{
            PreparedStatement ps = cn.prepareStatement("UPDATE Producto SET ID='"+id+"', Nombre = '"+Name+"', Precio = '"+ precio +"', Existencias = "+exist+", Tipo = '"+tipo+"', Gasto_Garrafa = "+gasGar+" WHERE ID = '"+wid+"'");
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                JOptionPane.showMessageDialog(null, "Se a editado el producto");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo editar el producto");
            }
        }catch(SQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null, "ERROR\nID duplicado, use otro por favor", "ID duplicado", 2);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inesperado\nrevise que los datos esten correctos", "ERROR", 2);
            System.err.println("Error: "+e);
        }
    }
    
    public static void eliminar(String ID, String tabla){
        try{
            PreparedStatement ps = cn.prepareStatement("UPDATE "+tabla+" SET Estado = 0 WHERE ID = '"+ID+"'");
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                JOptionPane.showMessageDialog(null, "Se a eliminado el producto");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto");
            }
        }catch(Exception e){
            System.err.println("Error: "+e);
        }
    }
    
    public static int garrafaValue(String sabor){
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT Cantidad FROM Garrafa WHERE Sabor = '"+sabor+"'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("Cantidad");
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la base de datos");
            System.err.println(e);
        }catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }
    
    public static void guardarGarValues(int value, String sabor){
        try {
            PreparedStatement ps = cn.prepareStatement("UPDATE Garrafa SET Cantidad = '"+value+"' WHERE Sabor = '"+sabor+"'");
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                System.out.println("Se guardo el valor de "+sabor);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo editar el producto "+sabor);
            }
        } catch (Exception e) {
            System.err.println("Error en guardarGarValues: "+e);
        }
    }
    
    public static String tipoProd(String prod){
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT Tipo FROM Producto WHERE Nombre = '"+prod+"'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("Tipo");
            }
        } catch (Exception e) {
            System.err.println("Error: "+e);
        }
        return "Otro";
    }
    
    public static DefaultComboBoxModel nameProd(){
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        cbm.addElement("Elija un producto");
        
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT Nombre FROM Producto WHERE Estado = '1' ORDER BY Nombre");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cbm.addElement(rs.getString("Nombre"));
            }
            
        } catch (SQLException e) {
            System.err.println("Error: "+e);
        }
        return cbm;
    }
    
    public static DefaultComboBoxModel saborProd(String tipo){
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        if (tipo.equals("Malteada")) {tipo = "Helado";}
        sabor.setTipo(tipo);
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT Sabor FROM Sabor WHERE Tipo = '"+tipo+"' ORDER BY Sabor");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cbm.addElement(rs.getString("Sabor"));
            }
        } catch (SQLException e) {
            System.err.println("Error: "+e);
        }
        return cbm;
    }
    
    public static String[] tabProd(String nombre){
        String[] datos = new  String[6];
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM Producto WHERE Nombre = '"+nombre+"'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                datos[0] = rs.getString("ID");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Precio");
                datos[3] = rs.getString("Existencias");
                datos[4] = rs.getString("Tipo");
                datos[5] = rs.getString("Gasto_Garrafa");
            }
            return datos;
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return datos;
    }
    
    public static void idSabor(){
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT ID FROM Sabor WHERE Sabor = '"+sabor.getFlavor()+"' AND Tipo = '"+sabor.getTipo()+"'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sabor.setId(rs.getString("ID"));
            }else{
                sabor.setId("");
            }
        } catch (Exception e) {
            System.err.println("Error al tomar el id del sabor: "+e);
        }
    }
    
    public static boolean existCaja(){
        
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM Caja WHERE Estado = 1");
            ResultSet rs = ps.executeQuery();
            return rs.next();
            
        } catch (SQLException e) {
            System.err.println("Error: "+e);
        }
        
        return false;
    }
    
    public static void llenarCaja(){
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM Caja WHERE Estado = 1");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                caja.setID(rs.getString("ID"));
                caja.setCantidad(rs.getDouble("Cantidad"));
                caja.setDinInicial(rs.getDouble("Inicial"));
                caja.setFecha(rs.getDate("Fecha"));
                System.out.println(rs.getDate("Fecha").toString());
            }
            
        } catch (SQLException e) {
            System.err.println("Error: "+e);
        }
    }
    
    public static void cerrarCaja(){
        try {
            PreparedStatement ps = cn.prepareStatement("UPDATE `caja` SET `Estado` = '0' WHERE `caja`.`ID` = '"+caja.getID()+"'");
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                System.out.println("Se a cerrado la caja");
            }
            
        } catch (SQLException e) {
            System.err.println("Error: "+e);
        }
    }
    
    public static void crearCaja(double ini){
        fecha = LocalDate.now();
        String f = fecha.format(format);
        String id = functions.IDgener();
        try{
            PreparedStatement ps = cn.prepareStatement("INSERT INTO Caja VALUES('"+id+"',0,"+ini+",'"+f+"', 1)");
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                caja.setID(id);
                caja.setFecha(Date.valueOf(f));
            }
        }catch(SQLIntegrityConstraintViolationException e){
            crearCaja(ini);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error inesperado", "ERROR", 2);
            System.err.println("Error: "+e.getMessage());
        }
    }
    
    public static void crearVenta(){
        hora = LocalTime.now();
        String f = hora.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        String id = functions.IDgener();
        try{
            PreparedStatement ps = cn.prepareStatement("INSERT INTO Ventas VALUES('"+id+"',"+sell.getTotal()+",'"+usuarios.getID()+"', '"+caja.getID()+"', '"+f+"')");
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                sell.setID(id);
            }
        }catch(SQLIntegrityConstraintViolationException e){
            crearVenta();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inesperado", "ERROR", 2);
            System.err.println("Error: "+e);
        }
    }
    
    public static void agregarPVenta(){
        
        
        String id = functions.IDgener();
        String IDprod = productos.getID(), IDventas = sell.getID(), IDsabor = sabor.getId();
        int cant = productos.getCant();
        double total = productos.getPrecio()*cant;
        
        String query = " VALUES('"+id+"','"+IDprod+"','"+IDventas+"','"+cant+"','"+IDsabor+"','"+total+"')";
        if (IDsabor.equals("")) {
            query = "(ID,Producto,Ventas,Cantidad,Total) VALUES('"+id+"','"+IDprod+"','"+IDventas+"','"+cant+"','"+total+"')";
        }else{
            gastoGarrafa(IDsabor, IDprod, cant);
        }
        
        try{
            PreparedStatement ps = cn.prepareStatement("INSERT INTO Producto_Venta"+query);
            int filasAfec = ps.executeUpdate();
            if (filasAfec == 0) {
                System.err.println("No se agrego nada");
            }
        }catch(SQLIntegrityConstraintViolationException e){
            System.err.println("Error id(creo): "+e);
            crearVenta();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error inesperado", "ERROR", 2);
            System.err.println("Error: "+e);
        }catch(Exception e){
            System.err.println("Error: "+e);
        }
    }
    
    public static void gastoGarrafa(String idSabor, String idProd, int c){
        String idGar;
        int gasto = 0, cant=0;
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT Garrafa FROM Sabor WHERE ID = '"+idSabor+"' AND Garrafa != 'NULL'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idGar = rs.getString("Garrafa");
            }else{
                System.out.println("No tiene garrafa");
                return;
            }
            
            ps = cn.prepareStatement("SELECT Gasto_Garrafa FROM Producto WHERE ID = '"+idProd+"'");
            rs = ps.executeQuery();
            if (rs.next()) {
                gasto = rs.getInt("Gasto_Garrafa");
            }else{
                System.out.println("No tiene gasto_garrafa");
                return;
            }
            
            ps = cn.prepareStatement("SELECT Cantidad FROM Garrafa WHERE ID = '"+idGar+"'");
            rs = ps.executeQuery();
            if (rs.next()) {
                cant = rs.getInt("Cantidad");
            }else{
                System.out.println("No tiene cantidad");
                return;
            }
            
            int restar = cant-(gasto*c);
            ps = cn.prepareStatement("UPDATE Garrafa SET Cantidad = "+restar+" WHERE ID = '"+idGar+"'");
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                System.out.println("Se a editado el producto");
            }
            
            System.out.println(restar);
            
        } catch (Exception e) {
            System.out.println("Error en gastoGarrafa: "+e);
        }
        
    }
    
    public static DefaultComboBoxModel personas(){
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        cbm.addElement("Nuevo");
        
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM Persona ORDER BY Nombre");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cbm.addElement(rs.getString("ID").concat(" "+rs.getString("Nombre")));
            }
            
        } catch (SQLException e) {
            System.err.println("Error: "+e);
        }
        return cbm;
    }
    
    public static boolean agregarPersona(){
        String ID = functions.IDgener(),
                Nombre = persona.getNombre(),
                aPat = persona.getaPat(),
                aMat = persona.getaMat(),
                fNac = persona.getfNac(),
                tel = persona.getTelefono();
        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO Persona VALUES('"+ID+"', '"+Nombre+"', '"+aPat+"', '"+aMat+"', '"+fNac+"', '"+tel+"')");
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                JOptionPane.showMessageDialog(null, "Se agrego a "+Nombre);
                persona.setID(ID);
                return true;
            }
        }catch(com.mysql.cj.jdbc.exceptions.MysqlDataTruncation e){
            JOptionPane.showMessageDialog(null, "Agregue un numero de telefono valido, por favor");
        }catch(SQLIntegrityConstraintViolationException e){
            System.err.println("Error id(creo): "+e);
            agregarPersona();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error inesperado", "ERROR", 2);
            System.err.println("Error: "+e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error\nAsegurese de que los datos sean correctos");
            System.err.println("Error: "+e);
        }
        return false;
    }
    
    public static void agregarUsu(String pass, String nUsu, int permiso, String idPersona){
        String id = functions.IDgener();
        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO Usuario VALUES('"+id+"', '"+pass+"', '"+nUsu+"', "+permiso+", '"+idPersona+"', 1)");
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                JOptionPane.showMessageDialog(null, "Se agrego el usuario");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo agrego el usuario");
            }
        }catch(SQLIntegrityConstraintViolationException e){
            System.err.println("Error en agregarusu: \n"+e.getLocalizedMessage());
            agregarUsu(pass, nUsu, permiso, idPersona);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error inesperado", "ERROR", 2);
            System.err.println("Error en agregarusu2: "+e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error\nAsegurese de que los datos sean correctos");
            System.err.println("Error en agregarusu3: "+e);
        }
    }
    
    public static DefaultTableModel llenarTablaUsuarios(DefaultTableModel dtm){
        dtm.setRowCount(0);
        
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM Persona INNER JOIN Usuario ON Usuario.Persona = Persona.ID INNER JOIN Permiso ON Usuario.Permiso = Permiso.ID WHERE Usuario.Estado != 0 ORDER BY Persona.Nombre");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Object[] fila = new Object[7];
                fila[0]=rs.getString("Persona.ID");
                fila[1]=rs.getString("Persona.Nombre");
                fila[2]=rs.getString("Persona.ApellidoP");
                fila[3]=rs.getString("Persona.ApellidoM");
                fila[4]=rs.getString("Usuario.Nombre");
                fila[5]=rs.getString("Persona.Telefono");
                fila[6]=rs.getString("Permiso.Tipo");
                dtm.addRow(fila);
            }
            return dtm;
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
        return dtm;
    }
    
    public static void eliminarUsu(String nUsu){
        try{
            PreparedStatement ps = cn.prepareStatement("UPDATE Usuario SET Estado = 0 WHERE Nombre = '"+nUsu+"'");
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                JOptionPane.showMessageDialog(null, "Se a eliminado el usuario");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario");
            }
        }catch(Exception e){
            System.err.println("Error: "+e);
        }
    }
    
    public static void editarUsu(String user, String pass, String nUsu, int permiso, String idPersona, int p){
        try{
            String sql = "UPDATE Usuario SET Password = '"+pass+"', Nombre = '"+nUsu+"', Permiso = "+permiso+", Persona = '"+idPersona+"' WHERE Nombre = '"+user+"'";
            if (p==1) {
                sql = "UPDATE Usuario SET Nombre = '"+nUsu+"', Permiso = "+permiso+", Persona = '"+idPersona+"' WHERE Nombre = '"+user+"'";
            }
            PreparedStatement ps = cn.prepareStatement(sql);
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                JOptionPane.showMessageDialog(null, "Se a editado el usuario");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo editar el usuario");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo editar el usuario");
            System.err.println("Error: "+e);
        }
    }
    
    public static DefaultTableModel llenarTablaCajas(DefaultTableModel dtm, int filtro){
        dtm.setRowCount(0);
        String sql = "SELECT * FROM Caja";
        String f;
        switch (filtro) {
            case 1:
                fecha = LocalDate.now().minusYears(1);
                f = fecha.format(format);
                sql = sql.concat(" WHERE Fecha >= '"+f+"'");
                break;
            case 2:
                fecha = LocalDate.now().minusMonths(1);
                f = fecha.format(format);
                sql = sql.concat(" WHERE Fecha >= '"+f+"'");
                break;
            case 3:
                fecha = LocalDate.now().minusDays(7);
                f = fecha.format(format);
                sql = sql.concat(" WHERE Fecha >= '"+f+"'");
                break;
            default:
                break;
        }
        try {
            PreparedStatement ps = cn.prepareStatement(sql+" ORDER BY Fecha DESC");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Object[] fila = new Object[3];
                fila[0]=rs.getString("ID");
                fila[1]=rs.getString("Fecha");
                fila[2]=rs.getString("Cantidad");
                dtm.addRow(fila);
            }
            return dtm;
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
        return dtm;
    }
    
    public static DefaultTableModel llenarTablaVentas(DefaultTableModel dtm, String idCaja){
        dtm.setRowCount(0);
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM Ventas INNER JOIN Usuario ON ventas.usuario = Usuario.ID WHERE Caja = '"+idCaja+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Object[] fila = new Object[4];
                fila[0]=rs.getString("Ventas.ID");
                fila[1]=rs.getString("Ventas.Total");
                fila[2]=rs.getString("Usuario.Nombre");
                fila[3]=rs.getString("Ventas.Fecha");
                dtm.addRow(fila);
            }
            return dtm;
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
        return dtm;
    }
    
    public static DefaultTableModel llenarTablaProductosVenta(DefaultTableModel dtm, String venta){
        dtm.setRowCount(0);
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM Producto_Venta INNER JOIN Producto ON Producto_venta.Producto = Producto.ID WHERE Ventas = '"+venta+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Object[] fila = new Object[3];
                fila[0]=rs.getString("Producto.Nombre");
                fila[1]=rs.getString("Cantidad");
                fila[2]=rs.getString("Total");
                dtm.addRow(fila);
            }
            return dtm;
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
        return dtm;
    }

    public static void guardarcaja(){
        String id = caja.getID();
        double cant = caja.getCantidad();
        try {
            PreparedStatement ps = cn.prepareStatement("UPDATE Caja SET Cantidad = "+cant+" WHERE ID = '"+id+"'");
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                System.out.println("Se guardaron los datos");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar\nIntentelo de nuevo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado\nintentelo de nuevo, si el problema persiste contacte al proovedor");
            System.out.println("Error: "+e);
        }
    }
    
    public static void retiro(double dinero, String t){
        String id = functions.IDgener(),
                user = usuarios.getID(),
                idcaja = caja.getID(),
                f = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        
        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO Ventas VALUES('"+id+"', "+dinero+", '"+user+"', '"+idcaja+"', '"+f+"')");
            int filasAfec = ps.executeUpdate();
            if (filasAfec > 0) {
                JOptionPane.showMessageDialog(null, "Se ah realizado el "+t);
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo realizar el "+t);
            }
        }catch(SQLIntegrityConstraintViolationException e){
            System.err.println("Error en retiro: \n"+e.getLocalizedMessage());
            retiro(dinero, t);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error inesperado", "ERROR", 2);
            System.err.println("Error en retiro"+e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error\nAsegurese de que los datos sean correctos");
            System.err.println("Error en retiro: "+e);
        }
    }
    
}
