package UI;

import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Napapol
 */
public class UI extends javax.swing.JFrame {    
    
    /**
     * Creates new form UI
     */
    public UI() {
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

        jLabel1 = new javax.swing.JLabel();
        reminder = new javax.swing.JButton();
        report = new javax.swing.JButton();
        selling = new javax.swing.JButton();
        buying = new javax.swing.JButton();
        database = new javax.swing.JButton();
        stockManagement = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("CordiaUPC", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("สหสามห้าฟาร์มาซี");

        reminder.setText("เตือนสินค้าหมดอายุ/สต๊อก");
        reminder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reminderMouseClicked(evt);
            }
        });
        reminder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reminderActionPerformed(evt);
            }
        });

        report.setText("รายงาน");
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportMouseClicked(evt);
            }
        });
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });

        selling.setText("ขาย");
        selling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellingMouseClicked(evt);
            }
        });
        selling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellingActionPerformed(evt);
            }
        });

        buying.setText("ซื้อ");
        buying.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buyingMouseClicked(evt);
            }
        });
        buying.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyingActionPerformed(evt);
            }
        });

        database.setText("ฐานข้อมูล");
        database.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                databaseMouseClicked(evt);
            }
        });
        database.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databaseActionPerformed(evt);
            }
        });

        stockManagement.setText("จัดการสต็อค");
        stockManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockManagementMouseClicked(evt);
            }
        });
        stockManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockManagementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(report, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(database, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(stockManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(reminder, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(selling, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(buying, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reminder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selling, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buying, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(database, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(report, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportActionPerformed

    private void buyingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyingActionPerformed

    private void reminderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reminderMouseClicked
        // TODO add your handling code here:
        Reminder newUi = new Reminder();
        newUi.setLocationRelativeTo(this);
        newUi.setVisible(true);
        dispose();
    }//GEN-LAST:event_reminderMouseClicked

    private void reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseClicked
        // TODO add your handling code here:
        Report newUi = new Report();
        newUi.setLocationRelativeTo(this);
        newUi.setVisible(true);
        dispose();
    }//GEN-LAST:event_reportMouseClicked

    private void sellingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellingMouseClicked
        // TODO add your handling code here:
        Sell newUi = new Sell();
        newUi.setLocationRelativeTo(this);
        newUi.setVisible(true);
        dispose();
    }//GEN-LAST:event_sellingMouseClicked

    private void buyingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyingMouseClicked
        // TODO add your handling code here:
        Buy newUi = new Buy();
        newUi.setLocationRelativeTo(this);
        newUi.setVisible(true);
        dispose();
    }//GEN-LAST:event_buyingMouseClicked

    private void databaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_databaseMouseClicked
        // TODO add your handling code here:
        Database newUi = new Database();
        newUi.setLocationRelativeTo(this);
        newUi.setVisible(true);
        dispose();
    }//GEN-LAST:event_databaseMouseClicked

    private void reminderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reminderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reminderActionPerformed

    private void databaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_databaseActionPerformed

    private void sellingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellingActionPerformed

    private void stockManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockManagementMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stockManagementMouseClicked

    private void stockManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockManagementActionPerformed
        // TODO add your handling code here:
        StockManagement newUi = new StockManagement();
        newUi.setLocationRelativeTo(this);
        newUi.setVisible(true);
        dispose();
    }//GEN-LAST:event_stockManagementActionPerformed

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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buying;
    private javax.swing.JButton database;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton reminder;
    private javax.swing.JButton report;
    private javax.swing.JButton selling;
    private javax.swing.JButton stockManagement;
    // End of variables declaration//GEN-END:variables
}
