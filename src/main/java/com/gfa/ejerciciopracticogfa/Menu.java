/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gfa.ejerciciopracticogfa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hecto
 */
public class Menu extends javax.swing.JFrame {

    private final conexionBD sql = new conexionBD();
    private final Connection con = sql.conexion();
    private String dato;

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
      
    }
    
    public void setDato(String dato){
        this.dato=dato;
          jLBienvenida.setText("Hola "+dato+"!");
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
        jLBienvenida = new javax.swing.JLabel();
        jLBienvenida1 = new javax.swing.JLabel();
        jBRegistros = new javax.swing.JButton();
        jBUltSes = new javax.swing.JButton();
        jBCerrarSes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new java.awt.GridLayout(6, 0, 0, 10));

        jLBienvenida.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLBienvenida.setText("jLabel1");
        jPanel1.add(jLBienvenida);

        jLBienvenida1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLBienvenida1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLBienvenida1.setText("¿Que quieres hacer hoy?");
        jPanel1.add(jLBienvenida1);

        jBRegistros.setText("Registrar nuevo usuario");
        jBRegistros.setPreferredSize(new java.awt.Dimension(200, 40));
        jBRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrosActionPerformed(evt);
            }
        });
        jPanel1.add(jBRegistros);

        jBUltSes.setText("Consultar últimos 10\n inicios de sesión");
        jBUltSes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUltSesActionPerformed(evt);
            }
        });
        jPanel1.add(jBUltSes);

        jBCerrarSes.setText("Cerrar sesión");
        jBCerrarSes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCerrarSesActionPerformed(evt);
            }
        });
        jPanel1.add(jBCerrarSes);

        Fondo.add(jPanel1);

        getContentPane().add(Fondo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBUltSesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUltSesActionPerformed
        Sesiones ses = new Sesiones();
        ses.setVisible(true);
    }//GEN-LAST:event_jBUltSesActionPerformed

    private void jBRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrosActionPerformed
        Registro reg = new Registro();
        reg.setVisible(true);
    }//GEN-LAST:event_jBRegistrosActionPerformed

    private void jBCerrarSesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCerrarSesActionPerformed

        try {
            con.close();
             if (EjercicioPracticoGFA.reg.isActive()||EjercicioPracticoGFA.ses.isActive()) {
                    EjercicioPracticoGFA.reg.dispose();
                    EjercicioPracticoGFA.ses.dispose();
                }
            this.dispose();
            EjercicioPracticoGFA.login.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBCerrarSesActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton jBCerrarSes;
    private javax.swing.JButton jBRegistros;
    private javax.swing.JButton jBUltSes;
    public javax.swing.JLabel jLBienvenida;
    public javax.swing.JLabel jLBienvenida1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
