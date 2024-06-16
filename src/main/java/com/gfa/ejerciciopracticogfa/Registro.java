/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gfa.ejerciciopracticogfa;

import static com.gfa.ejerciciopracticogfa.Colores.error;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Hecto
 */
public class Registro extends javax.swing.JFrame {

    private final conexionBD sql = new conexionBD();
    private final Connection con = sql.conexion();

    public Registro() {
        initComponents();
        setLocationRelativeTo(null);
        inicializar();
    }

    public final void inicializar() {
        jLErrorClave.setVisible(false);
        jLErrorNombre.setVisible(false);
        jLErrorCont.setVisible(false);
        jLErrorClave.setVisible(false);
        jLErrorCont.setVisible(false);
        lista();
    }

    public boolean validarClave(String clave) {
        int count = 0;
        if (con != null) {
            try (PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM Usuarios WHERE clave=\"" + clave + "\";")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                }
                rs.close();
            } catch (SQLException e) {
            }
        }
        return count <= 0;
    }

    public void validarDatos() {
        String clave = jTFClave.getText(), nombre = jTFNombre.getText(), cont1 = jTFCont1.getText(), cont2 = jTFCont2.getText();
        if (clave.isEmpty() || nombre.isEmpty() || cont1.isEmpty() || cont2.isEmpty()) {
            if (clave.isEmpty()) {
                jLErrorClave.setVisible(true);
                jLErrorClave.setText("*Campo obligatorio");
                jTFClave.setBorder(BorderFactory.createLineBorder(error, 2));
            }
            if (nombre.isEmpty()) {
                jLErrorNombre.setVisible(true);
                jLErrorNombre.setText("*Campo obligatorio");
                jTFNombre.setBorder(BorderFactory.createLineBorder(error, 2));
            }
            if (cont1.isEmpty() || cont2.isEmpty()) {
                jLErrorCont.setVisible(true);
                jLErrorCont.setText("*Campo obligatorio");
                jTFCont1.setBorder(BorderFactory.createLineBorder(error, 2));
                jTFCont2.setBorder(BorderFactory.createLineBorder(error, 2));
            }
        } else {
            if (!validarClave(clave)) {
                jLErrorClave.setVisible(true);
                jLErrorClave.setText("*Clave no disponible");
                jTFClave.setBorder(BorderFactory.createLineBorder(error, 2));
            } else if (!cont1.equals(cont2)) {
                jLErrorCont.setVisible(true);
                jLErrorCont.setText("*Las contraseñas no coinciden");
                jTFCont1.setBorder(BorderFactory.createLineBorder(error, 2));
                jTFCont2.setBorder(BorderFactory.createLineBorder(error, 2));
            } else {
                try (PreparedStatement ps = con.prepareStatement("INSERT INTO Usuarios(clave,nombre,contrasena,Estado,Fec_Hor_Creacion,Fec_Hor_Ult_Mod,Usu_Ult_Mod) VALUES (\"" + clave + "\",\"" + nombre + "\",\"" + cont1 + "\",true,now(),now(),\"" + clave + "\");")) {
                    ps.executeUpdate();
                    ps.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                Listas rol = (Listas) jCBRoles.getSelectedItem();
                try (PreparedStatement ps = con.prepareStatement("INSERT INTO Roles_Usuarios(id_rol,id_usuario, Fec_Hor_Creacion,Fec_Hor_Ult_Mod) VALUES (" + rol.getID() + ",(SELECT id_usuario FROM USUARIOS WHERE clave=\"" + clave + "\"),now(),now());")) {
                    ps.executeUpdate();
                    ps.close();
                    JOptionPane.showMessageDialog(null, "El usuario se registro con exito!", "Atención", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void lista() {
        DefaultComboBoxModel value;
        value = new DefaultComboBoxModel();
        jCBRoles.setModel(value);
        if (con != null) {
            try (PreparedStatement ps = con.prepareStatement("SELECT id_rol,Nombre FROM roles;")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    value.addElement(new Listas(rs.getString(2), rs.getString(1)));
                }
                rs.close();
            } catch (SQLException e) {
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLRegTitulo = new javax.swing.JLabel();
        jPClave = new javax.swing.JPanel();
        jLRegClave = new javax.swing.JLabel();
        jLErrorClave = new javax.swing.JLabel();
        jTFClave = new javax.swing.JTextField();
        jPNombre = new javax.swing.JPanel();
        jLRegNombre = new javax.swing.JLabel();
        jLErrorNombre = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jPCont1 = new javax.swing.JPanel();
        jLRegCont1 = new javax.swing.JLabel();
        jLErrorCont = new javax.swing.JLabel();
        jTFCont1 = new javax.swing.JTextField();
        jLRegCont2 = new javax.swing.JLabel();
        jTFCont2 = new javax.swing.JTextField();
        jLRol = new javax.swing.JLabel();
        jCBRoles = new javax.swing.JComboBox<>();
        jPEspacio = new javax.swing.JPanel();
        jPBotones = new javax.swing.JPanel();
        jBGuardar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(13, 0, 0, 5));

        jLRegTitulo.setText("REGISTRAR USUARIO");
        jPanel1.add(jLRegTitulo);

        jPClave.setLayout(new java.awt.BorderLayout());

        jLRegClave.setText("Clave de usuario:");
        jPClave.add(jLRegClave, java.awt.BorderLayout.WEST);

        jLErrorClave.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLErrorClave.setText("Error");
        jPClave.add(jLErrorClave, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPClave);

        jTFClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFClaveFocusGained(evt);
            }
        });
        jPanel1.add(jTFClave);

        jPNombre.setLayout(new java.awt.BorderLayout());

        jLRegNombre.setText("Nombre de usuario:");
        jPNombre.add(jLRegNombre, java.awt.BorderLayout.WEST);

        jLErrorNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLErrorNombre.setText("Error");
        jPNombre.add(jLErrorNombre, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPNombre);

        jTFNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFNombreFocusGained(evt);
            }
        });
        jPanel1.add(jTFNombre);

        jPCont1.setLayout(new java.awt.BorderLayout());

        jLRegCont1.setText("Contraseña:");
        jPCont1.add(jLRegCont1, java.awt.BorderLayout.WEST);

        jLErrorCont.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLErrorCont.setText("Error");
        jPCont1.add(jLErrorCont, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPCont1);

        jTFCont1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFCont1FocusGained(evt);
            }
        });
        jPanel1.add(jTFCont1);

        jLRegCont2.setText("Confirmar contraseña:");
        jPanel1.add(jLRegCont2);

        jTFCont2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFCont2FocusGained(evt);
            }
        });
        jPanel1.add(jTFCont2);

        jLRol.setText("Rol:");
        jPanel1.add(jLRol);

        jCBRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jCBRoles);

        jPEspacio.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPEspacio);

        jPBotones.setPreferredSize(new java.awt.Dimension(150, 30));
        jPBotones.setLayout(new java.awt.BorderLayout(0, 5));

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPBotones.add(jBGuardar, java.awt.BorderLayout.WEST);

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });
        jPBotones.add(jBCancelar, java.awt.BorderLayout.EAST);

        jPanel1.add(jPBotones);

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Fondo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFClaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFClaveFocusGained
        jLErrorClave.setVisible(false);
        jTFClave.setBorder(new JTextField().getBorder());
    }//GEN-LAST:event_jTFClaveFocusGained

    private void jTFNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFNombreFocusGained
        jLErrorNombre.setVisible(false);
        jTFNombre.setBorder(new JTextField().getBorder());
    }//GEN-LAST:event_jTFNombreFocusGained

    private void jTFCont1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFCont1FocusGained
        jLErrorCont.setVisible(false);
        jTFCont1.setBorder(new JTextField().getBorder());
    }//GEN-LAST:event_jTFCont1FocusGained

    private void jTFCont2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFCont2FocusGained
        jLErrorCont.setVisible(false);
        jTFCont2.setBorder(new JTextField().getBorder());
    }//GEN-LAST:event_jTFCont2FocusGained

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        validarDatos();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        this.dispose();
        Menu menu = new Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_jBCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JComboBox<String> jCBRoles;
    private javax.swing.JLabel jLErrorClave;
    private javax.swing.JLabel jLErrorCont;
    private javax.swing.JLabel jLErrorNombre;
    private javax.swing.JLabel jLRegClave;
    private javax.swing.JLabel jLRegCont1;
    private javax.swing.JLabel jLRegCont2;
    private javax.swing.JLabel jLRegNombre;
    private javax.swing.JLabel jLRegTitulo;
    private javax.swing.JLabel jLRol;
    private javax.swing.JPanel jPBotones;
    private javax.swing.JPanel jPClave;
    private javax.swing.JPanel jPCont1;
    private javax.swing.JPanel jPEspacio;
    private javax.swing.JPanel jPNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFClave;
    private javax.swing.JTextField jTFCont1;
    private javax.swing.JTextField jTFCont2;
    private javax.swing.JTextField jTFNombre;
    // End of variables declaration//GEN-END:variables
}
