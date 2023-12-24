
package functions;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import modelos.*;

public class functions {
    
    static Random rdm = new Random();
    private static String second = ":";
    
    
    //Esta funcion se usa para reajustar las imagenes al tamaño de algun label
    public static void setBg(String ruta, JLabel lb){
        ImageIcon fondo = new ImageIcon(ruta);
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_DEFAULT));
        lb.setIcon(icono);
    }
    
    //Esta fucnion es para la ventana de opciones la cual oculta los demas paneles para mostrar solo el necesario
    public static void ocultarLabels(JPanel lb1, JPanel lb2, JPanel lb3/*, JPanel lb4*/){
        lb1.setVisible(true);
        lb2.setVisible(false);
        lb3.setVisible(false);
//        lb4.setVisible(false);
    }
    
    //Esta funcion es para repintar los paneles de los botones del menu de opciones
    public static void botones(JPanel lb1, JPanel lb2, JPanel lb3, int r, int g, int b){
        lb1.setBackground(new java.awt.Color(r,g,b));
        lb2.setBackground(new java.awt.Color(29,29,27));
        lb3.setBackground(new java.awt.Color(29,29,27));
    }
    
    //Esta funcion genera IDs para la creacion de nuevos datos en el programa
    public static String IDgener(){
        String abc = "0123456789abcdef";
        String ID = "";
        
        for (int i = 0; i < 6; i++) {
            ID += String.valueOf(abc.charAt(rdm.nextInt(abc.length()-1)));
        }
        return ID;
    }
    
    //Esta funcion solo permite la escritura de numeros
    public static void numbers(java.awt.event.KeyEvent evt){
        int key = evt.getKeyChar();
        boolean numeros = key >=48 && key <=57 || key==46;;
        if (!numeros) {
            evt.consume();
        }
    }
    
    //Esta funcion valida que la ID sea de maximo 6 digitos
    public static void validarID(java.awt.event.KeyEvent evt, JTextField tf){
        int key = evt.getKeyChar();
        if (tf.getText().length()>5) {
            evt.consume();
        }
    }
    
    public static void listeners(ArrayList<JSlider> sl, ArrayList<JProgressBar> pb,ArrayList<JSpinner> sp){
        for (int i = 0; i < sl.size(); i++) {
            int pos = i;
            sp.get(pos).addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    pb.get(pos).setValue((int)sp.get(pos).getValue());
                    sl.get(pos).setValue((int)sp.get(pos).getValue());
                }
            });
            sl.get(pos).addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    pb.get(pos).setValue((int)sl.get(pos).getValue());
                    sp.get(pos).setValue((int)sl.get(pos).getValue());
                    
                    if ((int)sp.get(pos).getValue() < 3500) {
                        sp.get(pos).getEditor().getComponent(0).setBackground(Color.RED);
                    }else{
                        sp.get(pos).getEditor().getComponent(0).setBackground(Color.white);
                    }
                }
            });
        }
    }
    
    public static void salir() {
        int salir = JOptionPane.showOptionDialog(null, "¿Desea salir?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sí", "No"},"No");
        if (salir == JOptionPane.YES_OPTION && usuarios.getTipo()!=3) {
            System.exit(0);
        }else if (usuarios.getTipo() == 3) {
            JOptionPane.showMessageDialog(null, "Usted no puede salir del prgrama\nllame a algun administrador");
        }
    }
    
    public static void insertarP(String ID, String name, String precio, String existencia, String gasGar, int tipoInd, String tipo){
        if (!name.equals("") && !precio.equals("") && !existencia.equals("") && !gasGar.equals("") && tipoInd != 0) {

            if (ID.equals("")) {
                ID = functions.IDgener();
            }

            if (SQLquerys.canUseNombre("Producto", name)) {
                SQLquerys.insertProductos(ID, name, Double.parseDouble(precio), Integer.parseInt(existencia), tipo, Double.parseDouble(gasGar));
            }else{
                JOptionPane.showMessageDialog(null, "Ese nombre ya esta en uso\nUse otro por favor");
            }

        }else{
            JOptionPane.showMessageDialog(null, "Agrega los datos necesarios");
        }
    }
    
    public static void editarP(String wid, String ID, String name, String precio, String existencia, String gasGar, int tipoInd, String tipo, boolean ni){
        if (!name.equals("") && !precio.equals("") && !existencia.equals("") && !gasGar.equals("") && tipoInd != 0) {

            if (ID.equals("")) {
                ID = functions.IDgener();
            }

            if (SQLquerys.canUseNombre("Producto", name) || ni) {
                SQLquerys.editarProducto(wid,ID, name, Double.parseDouble(precio), Integer.parseInt(existencia), tipo, Integer.parseInt(gasGar));
            }else{
                JOptionPane.showMessageDialog(null, "Ese nombre ya esta en uso\nUse otro por favor");
            }

        }else{
            JOptionPane.showMessageDialog(null, "Agrega los datos necesarios");
        }
    }
    
    public static void editarU(String user, String persona, String nUsu, String pass, String pass2, int tipo, boolean ni){
        if (!persona.isBlank() && !nUsu.isBlank() && tipo!=0 && (pass.equals(pass2))) {
            int p=0;
            if (SQLquerys.canUseNombre("Usuario", nUsu) || ni) {
                if (pass.equals("")) {
                    p=1;
                }
                SQLquerys.editarUsu(user, pass, nUsu, tipo, persona, p);
            }else {
                JOptionPane.showMessageDialog(null, "Ese nombre ya esta en uso\nUse otro por favor");
            }
        }else if(!pass.equals(pass2)){
            JOptionPane.showMessageDialog(null, "Las contraseñas deben coincidir");
        }else{
            JOptionPane.showMessageDialog(null, "Agrega los datos necesarios");
        }
    }
    
    public static void time(JLabel lb){
        Timer timer = new Timer();
        TimerTask hora = new TimerTask() {
            @Override
            public void run() {
                LocalTime horaActual = LocalTime.now().minusHours(1);
                DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm");
                String hora = horaActual.format(format);
                lb.setText(hora);
            }
        };
        timer.scheduleAtFixedRate(hora, 1, 1);
        
        TimerTask segundo = new TimerTask() {
            @Override
            public void run() {
                if (second.equals(":")) {
                    second = " ";
                }else{
                    second = ":";
                }
            }
        };
        timer.scheduleAtFixedRate(segundo, 1000, 1000);
    }
    
    public static void eliminar(String ID, String nombre, String tabla){
        try {
            int del = JOptionPane.showOptionDialog(null, "Esta seguro de eliminar el producto\n"+nombre.toUpperCase(), "CONFIRMAR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sí", "No"},"No");
            if (del == JOptionPane.YES_OPTION) {
                SQLquerys.eliminar(ID, tabla);
            }
        } catch (Exception e) {
        }
    }
    
    public static void setGarValue(ArrayList<JSpinner> sp){
        try {
            for (int i = 0; i < sp.size(); i++) {
                sp.get(i).setValue(SQLquerys.garrafaValue(sp.get(i).getName()));
            }
        } catch (Exception e) {
        }
    }
    
    public static void guardarValues(ArrayList<JSpinner> sp){
        try {
            for (int i = 0; i < sp.size(); i++) {
                JSpinner s = sp.get(i);
                SQLquerys.guardarGarValues((int) s.getValue(), s.getName());
            }
        } catch (Exception e) {
        }
    }
    
    public static void soltarCb(JComboBox cb, JComboBox cb2, JTextField tf){
        
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cb.getSelectedIndex()!=0) {
                    cb2.setModel(SQLquerys.saborProd(SQLquerys.tipoProd(cb.getSelectedItem().toString())));

                    String[] datos = SQLquerys.tabProd(cb.getSelectedItem().toString());

                    productos.setDatos(datos);

                    tf.setText(datos[2]);
                }
            }
        });
    }
    
    public static void agregarProducto(DefaultTableModel dtm, int cant){
        venta.setID_producto(productos.getID());
        venta.setNameProducto(productos.getName());
        venta.setPrecio(productos.getPrecio());
        venta.setCant(cant);
        venta.setTotalCantidad();
        SQLquerys.idSabor();
        
        dtm.addRow(venta.datosTabla());
        venta.setTotal(venta.getTotalProd());
    }
    
    public static void eliminarPVenta(JTable tb, JFrame jf, JLabel total){

        try{
            if (tb.getSelectedRowCount()<=1) {
                int row = tb.getSelectedRow();
                
                double t = Double.parseDouble(tb.getValueAt(row, 6).toString());
                int cant = Integer.parseInt(tb.getValueAt(row, 5).toString());
                
                DefaultTableModel dtm = (DefaultTableModel) tb.getModel();
                venta.setCant(-cant);
                venta.setTotalCantidad();
                dtm.removeRow(row);
                venta.editarTotal(t);
                total.setText("$"+venta.getTotal());
                jf.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione solo un producto, por favor");
            }

        }catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "No esta seleccionado ningun producto\nSeleccione uno por favor");
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
    
    public static void eliminarUsu(String nombre){
        try {
            int del = JOptionPane.showOptionDialog(null, "Esta seguro de eliminar el usuario\n"+nombre.toUpperCase(), "CONFIRMAR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sí", "No"},"No");
            if (del == JOptionPane.YES_OPTION) {
                SQLquerys.eliminarUsu(nombre);
            }
        } catch (Exception e) {
        }
    }
}
