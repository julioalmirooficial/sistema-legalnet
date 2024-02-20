
package principal;

import utilidades.CambiarPanel;
import vistas.VistaArticulos;
import vistas.VistaCategorias;
import vistas.VistaForos;
import vistas.VistaUsuarios;

public class Dashboard extends javax.swing.JFrame {

   public static int idUsuario = 0;
    public Dashboard() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        mnuPrincipal = new javax.swing.JButton();
        mnuForo = new javax.swing.JButton();
        mnuEstadistica = new javax.swing.JButton();
        mnuArticulos = new javax.swing.JButton();
        mnuAbogados = new javax.swing.JButton();
        mnuUsuarios = new javax.swing.JButton();
        mnuCerrarSesion = new javax.swing.JButton();
        mnuConfiguraciones = new javax.swing.JButton();
        mnuCategorias = new javax.swing.JButton();
        window = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(4, 73, 130));

        lblUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Hola:");

        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setText("Rol:");

        mnuPrincipal.setBackground(new java.awt.Color(1, 77, 140));
        mnuPrincipal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mnuPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        mnuPrincipal.setText("PRINCIPAL");
        mnuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPrincipalActionPerformed(evt);
            }
        });

        mnuForo.setBackground(new java.awt.Color(1, 77, 140));
        mnuForo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mnuForo.setForeground(new java.awt.Color(255, 255, 255));
        mnuForo.setText("FOROS");
        mnuForo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuForoActionPerformed(evt);
            }
        });

        mnuEstadistica.setBackground(new java.awt.Color(1, 77, 140));
        mnuEstadistica.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mnuEstadistica.setForeground(new java.awt.Color(255, 255, 255));
        mnuEstadistica.setText("ESTADISTICA");

        mnuArticulos.setBackground(new java.awt.Color(1, 77, 140));
        mnuArticulos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mnuArticulos.setForeground(new java.awt.Color(255, 255, 255));
        mnuArticulos.setText("ARTICULOS");
        mnuArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArticulosActionPerformed(evt);
            }
        });

        mnuAbogados.setBackground(new java.awt.Color(1, 77, 140));
        mnuAbogados.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mnuAbogados.setForeground(new java.awt.Color(255, 255, 255));
        mnuAbogados.setText("ABOGADOS");

        mnuUsuarios.setBackground(new java.awt.Color(1, 77, 140));
        mnuUsuarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mnuUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        mnuUsuarios.setText("USUARIOS");
        mnuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuariosActionPerformed(evt);
            }
        });

        mnuCerrarSesion.setBackground(new java.awt.Color(255, 192, 0));
        mnuCerrarSesion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mnuCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        mnuCerrarSesion.setText("CERRAR SESION");

        mnuConfiguraciones.setBackground(new java.awt.Color(1, 77, 140));
        mnuConfiguraciones.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mnuConfiguraciones.setForeground(new java.awt.Color(255, 255, 255));
        mnuConfiguraciones.setText("CONFIGURACIONES");

        mnuCategorias.setBackground(new java.awt.Color(1, 77, 140));
        mnuCategorias.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mnuCategorias.setForeground(new java.awt.Color(255, 255, 255));
        mnuCategorias.setText("CATEGORIAS");
        mnuCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCategoriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mnuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mnuForo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mnuArticulos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mnuEstadistica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mnuAbogados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mnuCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(lblRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(mnuConfiguraciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mnuCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mnuUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRol)
                .addGap(86, 86, 86)
                .addComponent(mnuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mnuForo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mnuArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mnuEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mnuAbogados, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mnuConfiguraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mnuCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mnuUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addComponent(mnuCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        window.setBackground(new java.awt.Color(255, 255, 255));
        window.setLayout(new javax.swing.BoxLayout(window, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(window, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(window, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPrincipalActionPerformed
       
//        new ChangePanel(PrincipalHomes, new Shopping());
    }//GEN-LAST:event_mnuPrincipalActionPerformed

    private void mnuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuariosActionPerformed
       new CambiarPanel(window, new VistaUsuarios());
    }//GEN-LAST:event_mnuUsuariosActionPerformed

    private void mnuCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCategoriasActionPerformed
        new CambiarPanel(window, new VistaCategorias());
    }//GEN-LAST:event_mnuCategoriasActionPerformed

    private void mnuArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArticulosActionPerformed
        new CambiarPanel(window, new VistaArticulos());        
    }//GEN-LAST:event_mnuArticulosActionPerformed

    private void mnuForoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuForoActionPerformed
        new CambiarPanel(window, new VistaForos());
    }//GEN-LAST:event_mnuForoActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lblRol;
    public static javax.swing.JLabel lblUsuario;
    public static javax.swing.JButton mnuAbogados;
    public static javax.swing.JButton mnuArticulos;
    public static javax.swing.JButton mnuCategorias;
    private javax.swing.JButton mnuCerrarSesion;
    public static javax.swing.JButton mnuConfiguraciones;
    public static javax.swing.JButton mnuEstadistica;
    public static javax.swing.JButton mnuForo;
    public static javax.swing.JButton mnuPrincipal;
    public static javax.swing.JButton mnuUsuarios;
    private javax.swing.JPanel window;
    // End of variables declaration//GEN-END:variables
}
