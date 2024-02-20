/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author julio
 */
public class EstilosDeTablas implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent jComponent = null;
        if (value instanceof String) {
            jComponent = new JLabel((String) value);
            ((JLabel) jComponent).setHorizontalAlignment(SwingConstants.CENTER);
            ((JLabel) jComponent).setSize(30, jComponent.getWidth());
            ((JLabel) jComponent).setPreferredSize(new Dimension(6, jComponent.getWidth()));
        }
        jComponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, Color.yellow));
        jComponent.setOpaque(true);
        jComponent.setBackground(new Color(0, 0, 0));
        jComponent.setToolTipText("");
        jComponent.setForeground(Color.white);
        return jComponent;
    }

}
