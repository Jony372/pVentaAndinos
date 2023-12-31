package windows;

import java.sql.Connection;
import functions.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import modelos.caja;
public class inicio extends javax.swing.JFrame {
    
    public static mainWindow mw;
    
    public inicio() {
        initComponents();
        
        Connection cn = SQLconector.conectar();                                     //Generea la conexion con la base de datos
        
        setSize(955, 637);                                                          //Le da un tamaño predefinido a la ventana
        functions.setBg("src/images/bg/inicio2.jpg", LBbackground);                  //
        functions.setBg("src/images/logo.png", LBLogo);                             //Reajusta las imagenes a los labels por defecto
        functions.setBg("src/images/icons/user.png", LBuserIcon);                   //
        functions.setBg("src/images/icons/pass.png", LBpassIcon);                   //
        this.repaint();
        
        TextPrompt placeholder1 = new TextPrompt("Ingresa tu usuario", TFUsuario);  //Agrega un placeholder a los textfield
        TextPrompt.format(placeholder1);                                            //
        
        TextPrompt placeholder2 = new TextPrompt("*******", TFPass);
        TextPrompt.format(placeholder2);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                functions.salir();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBLogo = new javax.swing.JLabel();
        LBUsuario = new javax.swing.JLabel();
        TFUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        LBPass = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        TFPass = new javax.swing.JPasswordField();
        LBpassIcon = new javax.swing.JLabel();
        LBuserIcon = new javax.swing.JLabel();
        BTIniciar = new javax.swing.JButton();
        LBbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(LBLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 260, 170));

        LBUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LBUsuario.setForeground(new java.awt.Color(0, 0, 0));
        LBUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBUsuario.setText("Usuario");
        getContentPane().add(LBUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 60, 20));

        TFUsuario.setBackground(new java.awt.Color(210, 228, 232));
        TFUsuario.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        TFUsuario.setForeground(new java.awt.Color(0, 0, 0));
        TFUsuario.setBorder(null);
        getContentPane().add(TFUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 360, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 370, 5));

        LBPass.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LBPass.setForeground(new java.awt.Color(0, 0, 0));
        LBPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBPass.setText("Contraseña");
        getContentPane().add(LBPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 80, 20));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 370, 5));

        TFPass.setBackground(new java.awt.Color(209, 227, 229));
        TFPass.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        TFPass.setForeground(new java.awt.Color(0, 0, 0));
        TFPass.setBorder(null);
        getContentPane().add(TFPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 360, 30));
        getContentPane().add(LBpassIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 45, 45));
        getContentPane().add(LBuserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 45, 45));

        BTIniciar.setBackground(new java.awt.Color(254, 124, 77));
        BTIniciar.setText("Iniciar Sesion");
        BTIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(BTIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 120, 40));
        getContentPane().add(LBbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTIniciarActionPerformed
        if (SQLquerys.login(TFUsuario.getText(), TFPass.getText())) {           //
            
            if (SQLquerys.existCaja()) {
                SQLquerys.llenarCaja();
            }
            
            if (caja.getDinInicial() != null) {
                mw = new mainWindow();
                mw.setVisible(true);
                dispose();
            }
            while(caja.getDinInicial()==null){
                try {
                    String val = JOptionPane.showInputDialog("Escribe con cuanto dinero inicias la caja");
                    if (val != null) {
                        caja.setDinInicial(Double.parseDouble(val));
                        
                        mw = new mainWindow();
                        mw.setVisible(true);  
                        SQLquerys.crearCaja(Double.parseDouble(val)); //Activar para la creacion de la caja al abrir el sistema
                        dispose();   
                    }
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Escriba un numero por favor");
                    System.err.println("Error: "+e);
                }
            }                                              //Verifica que el usuario este dentro de la base de datos
        }else{                                                                  //
            JOptionPane.showMessageDialog(null, "Datos incorrectos\nintentelo otra vez");                           //
        }
        
    }//GEN-LAST:event_BTIniciarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTIniciar;
    private javax.swing.JLabel LBLogo;
    private javax.swing.JLabel LBPass;
    private javax.swing.JLabel LBUsuario;
    private javax.swing.JLabel LBbackground;
    private javax.swing.JLabel LBpassIcon;
    private javax.swing.JLabel LBuserIcon;
    private javax.swing.JPasswordField TFPass;
    private javax.swing.JTextField TFUsuario;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
