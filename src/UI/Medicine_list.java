/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Napapol
 */
public class Medicine_list extends javax.swing.JFrame {

    DefaultTableModel model;
    /**
     * Creates new form Medicine_list
     */
    public Medicine_list() {
        initComponents();
        
        DefaultTableModel model = (DefaultTableModel) listTable.getModel();
        
        try {
            MySQLAccess medicines_table = new MySQLAccess();
            ArrayList<String[]> datas = medicines_table.list_medicines();
            
            for(int i = 0; i < datas.size(); i++){
                Object[] data_list = {
                    i+1,
                    datas.get(i)[0],
                    datas.get(i)[1],
                    datas.get(i)[2],
                    datas.get(i)[3],
                    datas.get(i)[4],
                    datas.get(i)[5],
                    datas.get(i)[6],
                };
                model.addRow(data_list);          
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
     public Medicine_list(String barcode_) {
        initComponents();
        searchMedicine(barcode_);
        barcode.setText(barcode_);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        update_button = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        delete_button = new javax.swing.JButton();
        barcode = new javax.swing.JTextField();
        search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        update_button.setText("Edit");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        listTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "No.", "บาร์โค๊ด", "ชื่อยา", "เลขทะเบียนยา", "ขนาด", "ราคาขาย", "ที่อยู่สต๊อก", "ประเภท"
            }
        ));
        jScrollPane1.setViewportView(listTable);

        jLabel1.setFont(new java.awt.Font("CordiaUPC", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("รายการยา");

        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcodeActionPerformed(evt);
            }
        });

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(delete_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update_button)
                        .addGap(10, 10, 10)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(delete_button)
                    .addComponent(update_button))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Database newUi = new Database();
        newUi.setLocationRelativeTo(this);
        newUi.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        // TODO add your handling code here:
        int selRow = listTable.getSelectedRow();
        String name = listTable.getValueAt(selRow, 2).toString();
        String barcode = listTable.getValueAt(selRow, 1).toString();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "คุณแน่ใจที่จะลบ\n"+barcode+" "+name+"\nรายการนี้ทิ้ง","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            // Saving code here
            System.out.println(dialogResult);

            //int selCol = listTable.getSelectedColumn();

            try {
                MySQLAccess db = new MySQLAccess();
                db.delete_medicines(barcode);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Delete successfully");
                model = (DefaultTableModel) listTable.getModel();
                model.removeRow(selRow);
            }
        }
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        // TODO add your handling code here:
        int selRow = listTable.getSelectedRow();
        String name = listTable.getValueAt(selRow, 2).toString();
        String barcode = listTable.getValueAt(selRow, 1).toString();
        String size = listTable.getValueAt(selRow, 4).toString();
        String code = listTable.getValueAt(selRow, 3).toString();
        float price = Float.parseFloat(listTable.getValueAt(selRow, 5).toString());
        String stock_type = listTable.getValueAt(selRow, 6) + "";
        String medicine_type = listTable.getValueAt(selRow, 7).toString();
        int stock_type_int = 0;
        int medicine_type_int = 0;
        
        switch(stock_type) {
            case "ข้างบน":
                stock_type_int = 0;
                break;
            case "ข้างล่าง":
                stock_type_int = 1;
                break;
        }
        
        switch(medicine_type) {
            case "ยาอันตราย":
                medicine_type_int = 0;
                break;
            case "ยาควบคุมพิเศษ":
                medicine_type_int = 1;
                break;
            case "ยาทั่วไป":
                medicine_type_int = 2;
                break;
            case "อื่นๆ":
                medicine_type_int = 3;
                break;
        }
        
        Medicine m = new Medicine(barcode, name,
                code, size, price, stock_type_int, medicine_type_int);
        Adding m_page = new Adding(m);
        m_page.setLocationRelativeTo(this);
        m_page.setVisible(true);
        dispose();
    }//GEN-LAST:event_update_buttonActionPerformed
    
    private void searchMedicine (String barcode_) {
        
        DefaultTableModel model = (DefaultTableModel) listTable.getModel();
        model.setRowCount(0);
        
        try {
            MySQLAccess medicines_table = new MySQLAccess();
            ArrayList<String[]> datas = medicines_table.list_medicines(barcode_);
            
            for(int i = 0; i < datas.size(); i++){
                Object[] data_list = {
                    i+1,
                    datas.get(i)[0],
                    datas.get(i)[1],
                    datas.get(i)[2],
                    datas.get(i)[3],
                    datas.get(i)[4],
                    datas.get(i)[5],
                    datas.get(i)[6],
                };
                model.addRow(data_list);          
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeActionPerformed
        // TODO add your handling code here:
        searchMedicine(barcode.getText());
    }//GEN-LAST:event_barcodeActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        searchMedicine(barcode.getText());
    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(Medicine_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Medicine_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Medicine_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Medicine_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Medicine_list().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barcode;
    private javax.swing.JButton delete_button;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listTable;
    private javax.swing.JButton search;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables
}
