/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gfa.ejerciciopracticogfa;

/**
 *
 * @author Hecto
 */
public class Registro extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
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
        jLRegClave = new javax.swing.JLabel();
        jTFClave = new javax.swing.JTextField();
        jLRegNombre = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jLCont1 = new javax.swing.JLabel();
        jTFCont1 = new javax.swing.JTextField();
        jLCont2 = new javax.swing.JLabel();
        jTFCont2 = new javax.swing.JTextField();
        jLRol = new javax.swing.JLabel();
        jCBRoles = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(11, 0));

        jLRegTitulo.setText("REGISTRAR USUARIO");
        jPanel1.add(jLRegTitulo);

        jLRegClave.setText("Clave de usuario:");
        jPanel1.add(jLRegClave);
        jPanel1.add(jTFClave);

        jLRegNombre.setText("Nombre de usuario:");
        jPanel1.add(jLRegNombre);
        jPanel1.add(jTFNombre);

        jLCont1.setText("Contraseña:");
        jPanel1.add(jLCont1);
        jPanel1.add(jTFCont1);

        jLCont2.setText("Confirmar contraseña:");
        jPanel1.add(jLCont2);
        jPanel1.add(jTFCont2);

        jLRol.setText("Rol:");
        jPanel1.add(jLRol);

        jCBRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jCBRoles);

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        getContentPane().add(Fondo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JComboBox<String> jCBRoles;
    private javax.swing.JLabel jLCont1;
    private javax.swing.JLabel jLCont2;
    private javax.swing.JLabel jLRegClave;
    private javax.swing.JLabel jLRegNombre;
    private javax.swing.JLabel jLRegTitulo;
    private javax.swing.JLabel jLRol;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFClave;
    private javax.swing.JTextField jTFCont1;
    private javax.swing.JTextField jTFCont2;
    private javax.swing.JTextField jTFNombre;
    // End of variables declaration//GEN-END:variables
}
