package GUI;

import BL.TableCellRenderer;
import BL.TableModel;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GUI extends javax.swing.JFrame {

    private TableModel bl = new TableModel();
    private File f = new File("/save.ser");

    public GUI() throws IOException {
        initComponents();
        table.setModel(bl);
        table.setDefaultRenderer(Object.class, new TableCellRenderer());

        if (!(f.exists())) {
            f.createNewFile();
        }

        bl.load(f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        miHide = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        menueBar = new javax.swing.JMenuBar();
        mStations = new javax.swing.JMenu();
        miAdd = new javax.swing.JMenuItem();
        miRemove = new javax.swing.JMenuItem();
        mValues = new javax.swing.JMenu();
        miTemp = new javax.swing.JMenuItem();
        miHumi = new javax.swing.JMenuItem();

        miHide.setText("Ausblenden");
        jPopupMenu1.add(miHide);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        mStations.setText("Stations");

        miAdd.setText("Add Weather Station");
        miAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddActionPerformed(evt);
            }
        });
        mStations.add(miAdd);

        miRemove.setText("Remove Weather Station");
        miRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemoveActionPerformed(evt);
            }
        });
        mStations.add(miRemove);

        menueBar.add(mStations);

        mValues.setText("Values");

        miTemp.setText("Set Temperature");
        miTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTempActionPerformed(evt);
            }
        });
        mValues.add(miTemp);

        miHumi.setText("Set Humidity");
        miHumi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miHumiActionPerformed(evt);
            }
        });
        mValues.add(miHumi);

        menueBar.add(mValues);

        setJMenuBar(menueBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddActionPerformed
        Dialog dlg = new Dialog(this, true);
        dlg.setVisible(true);

        if (dlg.isOk()) {
            bl.add(dlg.getS());
        }
    }//GEN-LAST:event_miAddActionPerformed

    private void miTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTempActionPerformed
        double newTemp = Double.parseDouble(JOptionPane.showInputDialog(this, "New Temperature:"));
        try {
            bl.changeTemp(table.getSelectedRow(), newTemp);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_miTempActionPerformed

    private void miHumiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miHumiActionPerformed
        int newHumi = Integer.parseInt(JOptionPane.showInputDialog(this, "New Humidity:"));
        try {
            bl.changeHumi(table.getSelectedRow(), newHumi);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_miHumiActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            bl.save(f);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void miRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemoveActionPerformed
        int[] values = table.getSelectedRows();
        bl.remove(values);
    }//GEN-LAST:event_miRemoveActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mStations;
    private javax.swing.JMenu mValues;
    private javax.swing.JMenuBar menueBar;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miHide;
    private javax.swing.JMenuItem miHumi;
    private javax.swing.JMenuItem miRemove;
    private javax.swing.JMenuItem miTemp;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
