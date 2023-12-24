/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package windows;

import functions.SQLquerys;
import functions.Ticket;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.caja;
import modelos.productos;
import modelos.sabor;
import modelos.sell;
import modelos.venta;

/**
 *
 * @author jony1
 */
public class confirmarPago extends javax.swing.JFrame {
    
    private static JTable tb;
    private static JLabel totalPrice;
    private static JFrame jf;
        
    public confirmarPago() {
        initComponents();
    }

    public static void setJf(JFrame jf) {
        confirmarPago.jf = jf;
    }
    
    public static void setCantidad(int cantidad) {
        LBshowCant.setText(String.valueOf(cantidad));
    }

    public static void setTotal(double total) {
        LBshowTotal.setText("$"+String.valueOf(total));
    }

    public static void setTb(JTable tb) {
        confirmarPago.tb = tb;
    }

    public static void setTotalPrice(JLabel totalPrice) {
        confirmarPago.totalPrice = totalPrice;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LBproductos = new javax.swing.JLabel();
        LBtotal = new javax.swing.JLabel();
        BTconfirmar = new javax.swing.JButton();
        LBshowCant = new javax.swing.JLabel();
        LBshowTotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(112, 214, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 48, 71), 2));

        LBproductos.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        LBproductos.setForeground(new java.awt.Color(2, 48, 71));
        LBproductos.setText("Productos:");

        LBtotal.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        LBtotal.setForeground(new java.awt.Color(2, 48, 71));
        LBtotal.setText("Total:");

        BTconfirmar.setBackground(new java.awt.Color(52, 255, 99));
        BTconfirmar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        BTconfirmar.setText("CONFIRMAR");
        BTconfirmar.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTconfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTconfirmarActionPerformed(evt);
            }
        });

        LBshowCant.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        LBshowCant.setForeground(new java.awt.Color(2, 48, 71));
        LBshowCant.setText("0");

        LBshowTotal.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        LBshowTotal.setForeground(new java.awt.Color(2, 48, 71));
        LBshowTotal.setText("$0.00");

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CANCELAR");
        jButton1.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBproductos)
                            .addComponent(LBtotal)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LBshowCant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LBshowTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(BTconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBshowCant, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBshowTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTconfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTconfirmarActionPerformed
        try{
            DefaultTableModel dtm = (DefaultTableModel) tb.getModel();
            sell.setTotal(Double.parseDouble(totalPrice.getText().substring(1)));
            SQLquerys.crearVenta();
            for (int i = 0; i < tb.getRowCount(); i++) {
                productos.setID(tb.getValueAt(i, 0).toString());
                productos.setPrecio((double) tb.getValueAt(i, 4));
                sabor.setId(tb.getValueAt(i, 2).toString());
                productos.setCant((int)tb.getValueAt(i, 5));
                SQLquerys.agregarPVenta();
            }
            caja.setCantidad(sell.getTotal());
            Ticket.crear(tb, LBshowTotal.getText());
            dtm.setRowCount(0);
            venta.reinTotal();
            totalPrice.setText("$"+venta.getTotal());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error\nCompruebe que todo esta bien, si persiste el error contacte con el proveedor");
            System.err.println("Error: "+e);
        }
        venta.reinTC();
        jf.setEnabled(true);
        dispose();
    }//GEN-LAST:event_BTconfirmarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jf.setEnabled(true);
        jf.show();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(confirmarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(confirmarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(confirmarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(confirmarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new confirmarPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTconfirmar;
    private javax.swing.JLabel LBproductos;
    private static javax.swing.JLabel LBshowCant;
    private static javax.swing.JLabel LBshowTotal;
    private javax.swing.JLabel LBtotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
