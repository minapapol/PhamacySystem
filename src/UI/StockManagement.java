/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.ArrayList;

/**
 *
 * @author Napapol
 */
public class StockManagement extends javax.swing.JFrame {
    
    private int id;
    

    /**
     * Creates new form StockManagement
     */
    public StockManagement() {
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
        jLabel2 = new javax.swing.JLabel();
        barcode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        medicine_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        stock_place = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        front_stock = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        back_stock = new javax.swing.JTextField();
        update_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        barcode_err = new javax.swing.JLabel();
        lotList = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        amout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("CordiaUPC", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("จัดการยา");

        jLabel2.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel2.setText("บาร์โค๊ด");

        barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcodeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel3.setText("ชื่อยา");

        medicine_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicine_nameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel4.setText("ลอตที่");

        jLabel6.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel6.setText("สตอค");

        stock_place.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        stock_place.setText("ข้างบน/ ข้างล่าง");

        jLabel8.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel8.setText("หน้าร้าน");

        front_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                front_stockActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel9.setText("หลังร้าน");

        back_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_stockActionPerformed(evt);
            }
        });

        update_button.setText("Update");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        barcode_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        barcode_err.setForeground(new java.awt.Color(255, 0, 51));
        barcode_err.setText("*");

        lotList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        lotList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lotListActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel10.setText("ทั้งหมด");

        amout.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        amout.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(update_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back_button))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(back_stock)
                            .addComponent(front_stock)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barcode)
                            .addComponent(stock_place, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(medicine_name, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(barcode_err, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lotList, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(amout)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(medicine_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barcode_err))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lotList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(stock_place))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(front_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(back_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(amout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update_button)
                    .addComponent(back_button))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeActionPerformed
        // TODO add your handling code here:
        System.out.print(evt.getActionCommand());
        barcode_err.setText("");
        
        try {
            MySQLAccess db = new MySQLAccess();
            
            medicine_name.setText(db.get_medicine_name(evt.getActionCommand()));
            
            if( medicine_name.getText().equals("none") ) barcode_err.setText("*รายการนี้ไม่มีอยู่ในฐานข้อมูล");
            
            if(db.list_lot(evt.getActionCommand()).length > 0 && !db.list_lot(evt.getActionCommand())[0].isEmpty()) { 
                lotList.setModel(new javax.swing.DefaultComboBoxModel<>(db.list_lot(evt.getActionCommand())));
                front_stock.requestFocus();
            } else {
                lotList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none" }));
                barcode_err.setText("*ไม่มีสินค้าในสต๊อก");
            }
            
            ArrayList<String[]> datas = db.list_medicine_details(evt.getActionCommand(), "" ,"");
            
            for(int i = 0; i < datas.size(); i++){
                if(datas.get(i)[4].equals(lotList.getSelectedItem().toString())){
                    stock_place.setText(datas.get(i)[16]);
                    front_stock.setText(datas.get(i)[6]);
                    back_stock.setText(datas.get(i)[5]);
                    id = Integer.parseInt(datas.get(i)[0]);
                    amout.setText(datas.get(i)[10]);
                    break;
                } 
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_barcodeActionPerformed

    private void medicine_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicine_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicine_nameActionPerformed

    private void front_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_front_stockActionPerformed
        // TODO add your handling code here:
        int front_ = Integer.parseInt(evt.getActionCommand());
        back_stock.setText((Integer.parseInt(amout.getText()) - front_)+"");
    }//GEN-LAST:event_front_stockActionPerformed

    private void back_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back_stockActionPerformed

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        // TODO add your handling code here:
        System.out.println("stock is updated: " + id);
        try {
            MySQLAccess db = new MySQLAccess();
            db.update_stock(id, Integer.parseInt(front_stock.getText()), Integer.parseInt(back_stock.getText()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_update_buttonActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        // TODO add your handling code here:
        UI newUi = new UI();
        newUi.setLocationRelativeTo(this);
        newUi.setVisible(true);
        dispose();
    }//GEN-LAST:event_back_buttonActionPerformed

    private void lotListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lotListActionPerformed
        // TODO add your handling code here:

        System.out.println("Lot is changed");
        try {
            MySQLAccess db = new MySQLAccess();

            ArrayList<String[]> datas = db.list_medicine_details(barcode.getText(), "" ,"");
            
            for(int i = 0; i < datas.size(); i++){
                if(datas.get(i)[4].equals(lotList.getSelectedItem().toString())){
                    stock_place.setText(datas.get(i)[16]);
                    front_stock.setText(datas.get(i)[6]);
                    back_stock.setText(datas.get(i)[5]);
                    id = Integer.parseInt(datas.get(i)[0]);
                    amout.setText(datas.get(i)[10]);
                    break;
                } 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lotListActionPerformed

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
            java.util.logging.Logger.getLogger(StockManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amout;
    private javax.swing.JButton back_button;
    private javax.swing.JTextField back_stock;
    private javax.swing.JTextField barcode;
    private javax.swing.JLabel barcode_err;
    private javax.swing.JTextField front_stock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> lotList;
    private javax.swing.JTextField medicine_name;
    private javax.swing.JLabel stock_place;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables
}
