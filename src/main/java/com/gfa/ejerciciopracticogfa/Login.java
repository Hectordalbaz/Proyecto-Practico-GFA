/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gfa.ejerciciopracticogfa;

import static com.gfa.ejerciciopracticogfa.Colores.*;
import com.password4j.Password;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Hecto
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public boolean user, pass;

    public static String clavedb, contdb, nomdb, idusu;
    private final conexionBD sql = new conexionBD();
    private final Connection con = sql.conexion();

    public Login() {
        initComponents();
        inicializar();
        setLocationRelativeTo(null);

    }

    //Limpiar los campos, ocultar etiquetas y regresar a colores originales los bordes
    public void inicializar() {
        jTFUsuario.setText("");
        jPFCont.setText("");
        jLErrorUsu.setForeground(error);
        jLErrorCont.setForeground(error);
        jLErrorUsu.setVisible(false);
        jLErrorCont.setVisible(false);
        jTFUsuario.setBorder(new JTextField().getBorder());
        jPFCont.setBorder(new JTextField().getBorder());
         jBIniSes.setBackground(new Color(1, 81, 152));
        jBIniSes.setForeground(Color.WHITE);

    }

    //Obtenemos los datos de la clave ingresada
    public void obtenerDatos(String clave) {
        if (con != null) {
            try (PreparedStatement ps = con.prepareStatement("SELECT id_usuario,clave,nombre,contrasena FROM Usuarios WHERE clave=\"" + clave + "\";")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    idusu=rs.getString("id_usuario");
                    clavedb = rs.getString("clave");
                    nomdb = rs.getString("nombre");
                    contdb = rs.getString("contrasena");
                }
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se pudieron obtener los datos de registro: " + e, "Atención", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

   
    public void validarDatos() {
        String usu = jTFUsuario.getText(), contrasena = jPFCont.getText();
         //Indicar los campos que son obligatorios
        if (usu.isEmpty() || contrasena.isEmpty()) {
            if (jTFUsuario.getText().isEmpty()) {
                jLErrorUsu.setVisible(true);
                jLErrorUsu.setText("*Campo obligatorio");
                jTFUsuario.setBorder(BorderFactory.createLineBorder(error, 2));
            }
            if (jPFCont.getText().isEmpty()) {
                jLErrorCont.setVisible(true);
                jLErrorCont.setText("*Campo obligatorio");
                jPFCont.setBorder(BorderFactory.createLineBorder(error, 2));
            }
        } else {
           //Obtenemos los datos y verificamos que existan
            obtenerDatos(usu);
            //Verificamos la contraseña cifrada
            boolean verificar=Password.check(contrasena, contdb).withBcrypt();
            //Verificamos que el usuario exista
            if (!usu.equals(clavedb)) {
                jLErrorUsu.setVisible(true);
                jLErrorUsu.setText("*El usuario no existe");
                jTFUsuario.setBorder(BorderFactory.createLineBorder(error, 2));
                //Verificamos que la contraseña sea la correcta
            } else if (usu.equals(clavedb) && !verificar) {
                jLErrorCont.setVisible(true);
                jLErrorCont.setText("*La contraseña es incorrecta");
                jPFCont.setBorder(BorderFactory.createLineBorder(error, 2));
                //Si es correcto registramos el inicio en la bd
            } else if (usu.equals(clavedb) && verificar) {
                try (PreparedStatement ps = con.prepareStatement("INSERT INTO Sesiones(id_usuario,fec_hor_ini_ses) VALUES (" + idusu + ",now());")) {
                    ps.executeUpdate();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "No se pudieron obtener los datos de registro: " + e, "Atención", JOptionPane.ERROR_MESSAGE);
                }
                //Abrimos el menu
                if (Menu.menu.isActive()) {
                    Menu.menu.toFront();
                } else {
                    Menu.menu.setDato(nomdb);
                    Menu.menu.setVisible(true);
           
                    this.dispose();
                    inicializar();
                }
                //guardamos en el archivo log
                Date todayDate = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String fecHor = sdf.format(todayDate);
                generarLog(clavedb + " " + nomdb + " " + fecHor+"\n");
            }
        }
    }

    //Metodo que crea en caso de que no exista el archivo log, si existe agrega los nuevos datos
    public void generarLog(String ultReg) {
        try {
            File archivo = new File("Log.txt");
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            String datosAnt = new String(Files.readAllBytes(Paths.get("Log.txt")));
            String textCompl = ultReg + datosAnt;
            Files.write(Paths.get("Log.txt"), textCompl.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
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
        jLIniSes = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLLogUsuario = new javax.swing.JLabel();
        jLErrorUsu = new javax.swing.JLabel();
        jTFUsuario = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLLogCont = new javax.swing.JLabel();
        jLErrorCont = new javax.swing.JLabel();
        jPFCont = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        jBIniSes = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Fondo.setFocusable(false);
        Fondo.setOpaque(false);
        Fondo.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 184));
        jPanel1.setLayout(new java.awt.GridLayout(6, 0, 0, 5));

        jLIniSes.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLIniSes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLIniSes.setText("Iniciar sesión");
        jPanel1.add(jLIniSes);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jLLogUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLLogUsuario.setText("Clave de usuario:");
        jPanel7.add(jLLogUsuario, java.awt.BorderLayout.WEST);

        jLErrorUsu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLErrorUsu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLErrorUsu.setText("Error");
        jPanel7.add(jLErrorUsu, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel7);

        jTFUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTFUsuario.setPreferredSize(new java.awt.Dimension(200, 30));
        jTFUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFUsuarioFocusGained(evt);
            }
        });
        jPanel1.add(jTFUsuario);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jLLogCont.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLLogCont.setText("Contraseña:");
        jPanel8.add(jLLogCont, java.awt.BorderLayout.WEST);

        jLErrorCont.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLErrorCont.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLErrorCont.setText("Error");
        jPanel8.add(jLErrorCont, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel8);

        jPFCont.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPFCont.setPreferredSize(new java.awt.Dimension(200, 30));
        jPFCont.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPFContFocusGained(evt);
            }
        });
        jPanel1.add(jPFCont);

        jBIniSes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBIniSes.setText("Iniciar sesión");
        jBIniSes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBIniSes.setPreferredSize(new java.awt.Dimension(150, 40));
        jBIniSes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIniSesActionPerformed(evt);
            }
        });
        jPanel6.add(jBIniSes);

        jPanel1.add(jPanel6);

        Fondo.add(jPanel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Fondo.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Fondo.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );

        Fondo.add(jPanel4, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );

        Fondo.add(jPanel5, java.awt.BorderLayout.LINE_START);

        getContentPane().add(Fondo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBIniSesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIniSesActionPerformed
        validarDatos();
    }//GEN-LAST:event_jBIniSesActionPerformed
    //Regresa el color original al ser enfocado
    private void jTFUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFUsuarioFocusGained
        jLErrorUsu.setVisible(false);
        jTFUsuario.setBorder(new JTextField().getBorder());
    }//GEN-LAST:event_jTFUsuarioFocusGained
    //Regresa el color original al ser enfocado
    private void jPFContFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPFContFocusGained
        jLErrorCont.setVisible(false);
        jPFCont.setBorder(new JTextField().getBorder());
    }//GEN-LAST:event_jPFContFocusGained

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton jBIniSes;
    private javax.swing.JLabel jLErrorCont;
    private javax.swing.JLabel jLErrorUsu;
    private javax.swing.JLabel jLIniSes;
    private javax.swing.JLabel jLLogCont;
    private javax.swing.JLabel jLLogUsuario;
    private javax.swing.JPasswordField jPFCont;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTFUsuario;
    // End of variables declaration//GEN-END:variables
}
