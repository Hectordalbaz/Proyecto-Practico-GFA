/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gfa.ejerciciopracticogfa;

import static com.gfa.ejerciciopracticogfa.Colores.*;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Hecto
 */
public class ColorTabla extends DefaultTableCellRenderer {

    //Metodo que agrega colores a las filas de la tabla
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        if (row % 2 == 0) {
                setBackground(filtab1);
                setForeground(letra);
            } else {
                setBackground(filtab2);
                setForeground(letra);
            }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    }

}
