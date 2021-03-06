package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.modelo.ValidarSesion;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Paul Idrovo
 */
public class VistaInicioSesion extends javax.swing.JFrame {

    private ControladorUsuario controladorUsuario;

    public VistaInicioSesion() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/ec/edu/ups/iconos/Icono.png")).getImage());
        this.setResizable(false);
        controladorUsuario = new ControladorUsuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btIniciar1 = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        pswContraseña = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btIniciar1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        btIniciar1.setText("INICIAR SESION");
        btIniciar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btIniciar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 238, -1));

        lblUsuario.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/usuario.png"))); // NOI18N
        lblUsuario.setText("CORREO");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 152, 220, 40));

        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("PARQUE DE LA MADRE - EMOV");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 660, 50));

        lblContraseña.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lblContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/contraseña.png"))); // NOI18N
        lblContraseña.setText("CONTRASEÑA");
        getContentPane().add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 240, 40));

        pswContraseña.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        pswContraseña.setMinimumSize(new java.awt.Dimension(90, 30));
        pswContraseña.setPreferredSize(new java.awt.Dimension(90, 30));
        getContentPane().add(pswContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 290, 40));

        txtUsuario.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        txtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsuario.setMaximumSize(new java.awt.Dimension(90, 30));
        txtUsuario.setMinimumSize(new java.awt.Dimension(90, 30));
        txtUsuario.setPreferredSize(new java.awt.Dimension(90, 30));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 290, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/fondo.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIniciar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciar1ActionPerformed
        // TODO add your handling code here:

        String passwordDeco = "";
        char[] password = pswContraseña.getPassword();
        for (int x = 0; x < password.length; x++) {
            passwordDeco += password[x];
        }

        Usuario us = controladorUsuario.inicioSesion(new Usuario(txtUsuario.getText(), passwordDeco));
        if (us != null) {
            ValidarSesion vlSesion = ValidarSesion.getValidarSesion(us.getId(), us.getTipo());
            vlSesion.setId(us.getId());
            vlSesion.setTipo(us.getTipo());
            JOptionPane.showMessageDialog(null, "BIENVENIDO", "LOGIN", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            if (us.getTipo().equals("ADMINISTRADOR")) {
                VistaAdministrador vsAdministrador = new VistaAdministrador();
                vsAdministrador.setVisible(true);
            } else {
                VistaParqueaderos vsParqueaderos = new VistaParqueaderos();
                vsParqueaderos.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "CORREO Y/O CONTRASEÑA INCORRECTOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btIniciar1ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                } catch (Exception e) {

                }
                new VistaInicioSesion().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIniciar1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pswContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
