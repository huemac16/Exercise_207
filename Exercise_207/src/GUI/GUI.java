package GUI;

import BL.TableCellRenderer;
import BL.TableModel;
import javax.swing.JOptionPane;

public class GUI extends javax.swing.JFrame {

    private TableModel bl = new TableModel();

    public GUI() {
        initComponents();
        table.setModel(bl);
        table.setDefaultRenderer(Object.class, new TableCellRenderer());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        menueBar = new javax.swing.JMenuBar();
        mStations = new javax.swing.JMenu();
        miAdd = new javax.swing.JMenuItem();
        miRemove = new javax.swing.JMenuItem();
        mValues = new javax.swing.JMenu();
        miTemp = new javax.swing.JMenuItem();
        miHumi = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
    }//GEN-LAST:event_miTempActionPerformed

    private void miHumiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miHumiActionPerformed
        int newHumi = Integer.parseInt(JOptionPane.showInputDialog(this, "New Humidity:"));
    }//GEN-LAST:event_miHumiActionPerformed

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
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mStations;
    private javax.swing.JMenu mValues;
    private javax.swing.JMenuBar menueBar;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miHumi;
    private javax.swing.JMenuItem miRemove;
    private javax.swing.JMenuItem miTemp;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
