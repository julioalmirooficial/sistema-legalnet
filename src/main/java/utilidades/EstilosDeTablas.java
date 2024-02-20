
package utilidades;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class EstilosDeTablas  {
    public JTableHeader pintar (JTable table){
        JTableHeader Theader = table.getTableHeader();
        
        Theader.setBackground(new Color(33,122,206)); // change the Background color
        Theader.setForeground(new Color(255,255,255)); // change the Foreground
        
        Theader.setFont(new Font("Tahome", Font.BOLD, 15)); // font name style size
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER); // center header text
        return Theader;
    }

}
