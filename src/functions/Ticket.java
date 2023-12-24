/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import java.awt.Desktop;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
import modelos.usuarios;

public class Ticket {
    
    
    
    public static void crear(JTable tb, String ttl){
        LocalDateTime ldt = LocalDateTime.now().minusHours(1);
        DateTimeFormatter formatN = DateTimeFormatter.ofPattern("yy-MM-dd HHmmss");
        DateTimeFormatter showFecha = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
        DateTimeFormatter formatC = DateTimeFormatter.ofPattern("yy-MM-dd");
        String nameN = ldt.format(formatN),
            nameC = ldt.format(formatC),
            fecha = ldt.format(showFecha),
            space = "                     ",
            space2 = "                                      ";
        
        try {
            File carpeta = new File("C:/Tickets/"+nameC);
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }
            FileWriter ticket = new FileWriter("C:/Tickets/"+nameC+"/"+nameN+".txt");
            ticket.write("\t\t\t\t\t\tHeladeria ANDINOS\n");
            ticket.write("\t\t\t\t\t      Lo mejor del helado\n\n");
            ticket.write(space2.substring(usuarios.getnUsuario().length()/2)+"Atendido por: "+usuarios.getNombre()+"\n");
            ticket.write("\t\t\t\t\t   Fecha: "+fecha+"\n\n");
            ticket.write("|Producto\t\t\t|Sabor\t\t\t|Cantidad\t|Precio\t|\tTotal\t|\n");
            ticket.write("-------------------------------------------------------------------------------------\n");
            for (int i = 0; i < tb.getRowCount(); i++) {
                String producto = tb.getValueAt(i, 1).toString(),
                    sabor = tb.getValueAt(i, 3).toString(),
                    cantidad = tb.getValueAt(i, 5).toString(),
                    precio = tb.getValueAt(i, 4).toString(),
                    total = tb.getValueAt(i, 6).toString();
                
                ticket.write("|"+producto+space.substring(producto.length())+"\t|"+sabor+space.substring(sabor.length())+"\t|"+cantidad+"\t\t|"+precio+"\t\t|\t"+total+"\t|\n");
            }
            ticket.write("\n\t\t\t\t\t\t\t\t\t\t\t\tTotal: "+ttl+"\n\n");
            ticket.write("\t\t\t\t\t    GRACIAS POR SU COMPRA\n");
            ticket.write("\t\t\t\t\t\t  Vuelva pronto");
            ticket.close();
            System.out.println("Archivo creado exitosamente.");
            
            Desktop.getDesktop().open(new File("C:/Tickets/"+nameC+"/"+nameN+".txt"));
        } catch (Exception e) {
            System.out.println("Ocurrió un error al crear el ticket.");
            System.out.println(e);
        }
    }
}
