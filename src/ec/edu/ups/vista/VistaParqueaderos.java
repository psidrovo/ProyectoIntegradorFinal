package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorTicket;
import ec.edu.ups.modelo.ExpresionRegular;
import ec.edu.ups.modelo.HiloMovimiento;
import ec.edu.ups.modelo.Parqueadero;
import ec.edu.ups.modelo.Tarifa;
import ec.edu.ups.modelo.Ticket;
import ec.edu.ups.modelo.ValidarSesion;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VistaParqueaderos extends javax.swing.JFrame {

    public List<JLabel> lblParqueaderos;
    private VistaParqueaderos vistaParqueaderos;
    private int valorDado;

    public VistaParqueaderos() {
        vistaParqueaderos = this;
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/ec/edu/ups/iconos/Icono.png")).getImage());
        this.setResizable(false);
        lblT1.setVisible(false);
        lblT2.setVisible(false);
        lblT3.setVisible(false);
        List<Tarifa> listaTarifas = new Tarifa().TarifasRegular();
        lblT1.setText(listaTarifas.get(0).getValorTarifa() + "");
        lblT2.setText(listaTarifas.get(1).getValorTarifa() + "");
        lblT3.setText(listaTarifas.get(2).getValorTarifa() + "");
        txtCodigoTicket.setForeground(Color.GRAY);
        espaciosParqueadero();
    }

    private void espaciosParqueadero() {
        pnlParqueaderos.removeAll();
        lblParqueaderos = new ArrayList<>();
        List<Parqueadero> listaParqueadero = new Parqueadero().getParqueaderos();
        int cont = 1;
        int pos = 1;
        int posicionX = 20;
        int posicionY = 20;
        for (Parqueadero parqueadero : listaParqueadero) {
            JLabel labelParqueadero = new JLabel(cont + "");
            labelParqueadero.setVerticalTextPosition(JLabel.CENTER);
            labelParqueadero.setHorizontalTextPosition(JLabel.CENTER);
            Random r = new Random();
            valorDado = r.nextInt(3) + 1;
            if (parqueadero.getEstado().equals("DISPONIBLE")) {
                labelParqueadero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/espacioLibre.png")));
            } else {
                labelParqueadero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/v" + valorDado + ".png")));
            }
            labelParqueadero.setBounds(posicionX, posicionY, 90, 250);
            labelParqueadero.setFont(new Font("Verdana", Font.BOLD, 18));

            labelParqueadero.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String icono = labelParqueadero.getIcon().toString();
                    if (icono.equals("file:/C:/Programas%20Java/UPS/3ROCICLO/Parqueadero/build/classes/ec/edu/ups/iconos/espacioLibre.png")) {
                        /*int numero = Integer.parseInt(labelParqueadero.getText()) - 1;
                        var thread = new Thread(new HiloMovimiento(vistaParqueaderos, numero));
                        thread.start();*/
                        vistaParqueaderos.setEnabled(false);
                        VistaCliente cl = new VistaCliente(vistaParqueaderos, Integer.parseInt(labelParqueadero.getText()));
                        cl.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "ESPACIO YA OCUPADO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
            pnlParqueaderos.add(labelParqueadero);
            lblParqueaderos.add(labelParqueadero);
            cont++;
            pos++;
            posicionX += 90;
            if (pos > 10) {
                pnlParqueaderos.setPreferredSize(new java.awt.Dimension(posicionX, pnlParqueaderos.getHeight() - 40));
                posicionX = 20;
                posicionY += 300;
                pos = 1;
            }
        }
        pnlParqueaderos.setPreferredSize(new java.awt.Dimension(pnlParqueaderos.getHeight(), posicionY + 400));
        scpParqueaderos.updateUI();
        pnlParqueaderos.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scpParqueaderos = new javax.swing.JScrollPane();
        pnlParqueaderos = new javax.swing.JPanel();
        btnPagar = new javax.swing.JButton();
        txtCodigoTicket = new javax.swing.JTextField();
        btnPagar1 = new javax.swing.JButton();
        lblT1 = new javax.swing.JLabel();
        lblT2 = new javax.swing.JLabel();
        lblT3 = new javax.swing.JLabel();

        pnlParqueaderos.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout pnlParqueaderosLayout = new javax.swing.GroupLayout(pnlParqueaderos);
        pnlParqueaderos.setLayout(pnlParqueaderosLayout);
        pnlParqueaderosLayout.setHorizontalGroup(
            pnlParqueaderosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1336, Short.MAX_VALUE)
        );
        pnlParqueaderosLayout.setVerticalGroup(
            pnlParqueaderosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );

        scpParqueaderos.setViewportView(pnlParqueaderos);

        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/exit.png"))); // NOI18N
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        txtCodigoTicket.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtCodigoTicket.setText("INGRESE CODIGO PAGAR");
        txtCodigoTicket.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoTicketFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoTicketFocusLost(evt);
            }
        });

        btnPagar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/pagos.png"))); // NOI18N
        btnPagar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagar1ActionPerformed(evt);
            }
        });

        lblT1.setText("jLabel2");

        lblT2.setText("jLabel3");

        lblT3.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpParqueaderos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtCodigoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPagar1)
                .addGap(75, 75, 75)
                .addComponent(lblT1)
                .addGap(56, 56, 56)
                .addComponent(lblT2)
                .addGap(58, 58, 58)
                .addComponent(lblT3)
                .addGap(536, 536, 536)
                .addComponent(btnPagar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigoTicket)
                            .addComponent(btnPagar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblT1)
                            .addComponent(lblT2)
                            .addComponent(lblT3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(scpParqueaderos, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoTicketFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoTicketFocusGained
        if (txtCodigoTicket.getText().equals("INGRESE CODIGO PAGAR")) {
            txtCodigoTicket.setText("");
            txtCodigoTicket.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtCodigoTicketFocusGained

    public int getValorDado() {
        return valorDado;
    }

    public List<JLabel> getLblParqueaderos() {
        return lblParqueaderos;
    }

    public void setLblParqueaderos(List<JLabel> lblParqueaderos) {
        this.lblParqueaderos = lblParqueaderos;
        scpParqueaderos.updateUI();
        pnlParqueaderos.updateUI();
    }

    private void txtCodigoTicketFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoTicketFocusLost
        if (txtCodigoTicket.getText().isEmpty()) {
            txtCodigoTicket.setForeground(Color.GRAY);
            txtCodigoTicket.setText("INGRESE CODIGO PAGAR");
        }
    }//GEN-LAST:event_txtCodigoTicketFocusLost

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        ValidarSesion vlSesion = ValidarSesion.getValidarSesion(0, "");
        vlSesion.setId(0);
        vlSesion.setTipo("");
        this.setVisible(false);
        VistaInicioSesion in = new VistaInicioSesion();
        in.setVisible(true);
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnPagar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagar1ActionPerformed
        ExpresionRegular exp = new ExpresionRegular();
        exp.ingresarRegex("^\\d+$");
        if (exp.validar(txtCodigoTicket.getText())) {
            Ticket tk = new Ticket();
            tk = tk.recuperarDatos(Integer.parseInt(txtCodigoTicket.getText()));
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date tiempo = null;
            try {
                tiempo = formato.parse(tk.getFechaEntrada());
            } catch (ParseException ex) {
                Logger.getLogger(VistaParqueaderos.class.getName()).log(Level.SEVERE, null, ex);
            }
            Date actual = new Date();

            double minutos = (actual.getTime() - tiempo.getTime()) / 60000;
            int horas = (int) minutos / 60;
            int mediaHora = 0;
            int cuartoHora = 0;
            double minutosExtras = minutos / 60;
            minutosExtras = minutosExtras - horas;
            if (minutosExtras > 0.5) {
                horas++;
            } else {
                mediaHora = (int) (minutosExtras * 2);
                minutosExtras = (minutosExtras * 2) - mediaHora;
                if (minutosExtras > 0.5) {
                    mediaHora++;
                } else {
                    cuartoHora++;
                }
            }
            double total = (horas * Double.parseDouble(lblT1.getText())) + (mediaHora * Double.parseDouble(lblT2.getText())) + (cuartoHora * Double.parseDouble(lblT3.getText()));
            DecimalFormat df = new DecimalFormat("#.00");
            int confirmado = JOptionPane.showConfirmDialog(null, "EL VALOR A PAGAR ES DE $" + df.format(total) + " CONTINUAR ?");

            if (JOptionPane.OK_OPTION == confirmado) {
                ControladorTicket controladorTicket = new ControladorTicket();
                tk.setValor(total);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                tk.setFechaSalida(simpleDateFormat.format(new Date()));
                controladorTicket.setPagarParqueadero(tk);
                espaciosParqueadero();
            }
        } else {
            JOptionPane.showMessageDialog(null, "CODIGO NO VALIDO", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPagar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPagar1;
    private javax.swing.JLabel lblT1;
    private javax.swing.JLabel lblT2;
    private javax.swing.JLabel lblT3;
    public javax.swing.JPanel pnlParqueaderos;
    private javax.swing.JScrollPane scpParqueaderos;
    private javax.swing.JTextField txtCodigoTicket;
    // End of variables declaration//GEN-END:variables
}
