/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import UI.MySQLAccess;

/**
 *
 * @author Napapol
 */
public class Adding extends javax.swing.JFrame {
    
    /**
     * Creates new form Adding
     */
    String temp_barcode;
    Medicine m;
    
    public Adding() {
        initComponents();
    }
    
    public Adding(Medicine m) {
        initComponents();
        this.m = m;
        temp_barcode = m.getBarcode();
        barcode.setText(temp_barcode);
        medicine_name.setText(m.getName());
        medicine_code.setText(m.getCode());
        size.setText(m.getSize());
        medicine_type.setSelectedIndex(m.getMedicineType());
        stock_type.setSelectedIndex(m.getStockType());
        selling_price.setText(m.getPrice()+"");
        medicine_code.setText(m.getCode());
        add_button.setText("Update");
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
        add_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        medicine_type = new javax.swing.JComboBox<>();
        medicine_code = new javax.swing.JTextField();
        size = new javax.swing.JTextField();
        selling_price = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        code_err = new javax.swing.JLabel();
        size_err = new javax.swing.JLabel();
        sell_err = new javax.swing.JLabel();
        medicine_name_err = new javax.swing.JLabel();
        barcode_err = new javax.swing.JLabel();
        stock_type = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("CordiaUPC", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("เพิ่มสินค้า");

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

        add_button.setText("Add");
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });

        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        medicine_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ยาอันตราย", "ยาควบคุมพิเศษ", "ยาทั่วไป", "อื่นๆ" }));
        medicine_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicine_typeActionPerformed(evt);
            }
        });

        medicine_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicine_codeActionPerformed(evt);
            }
        });

        size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeActionPerformed(evt);
            }
        });

        selling_price.setText("0.0");
        selling_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selling_priceActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel4.setText("รหัส");

        jLabel12.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel12.setText("ขนาด");

        jLabel9.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel9.setText("ราคาขาย");

        jLabel10.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel10.setText("ประเภท");

        code_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        code_err.setForeground(new java.awt.Color(255, 0, 51));
        code_err.setText("*");

        size_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        size_err.setForeground(new java.awt.Color(255, 0, 51));
        size_err.setText("*");

        sell_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        sell_err.setForeground(new java.awt.Color(255, 0, 51));
        sell_err.setText("*");

        medicine_name_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        medicine_name_err.setForeground(new java.awt.Color(255, 0, 51));
        medicine_name_err.setText("*");

        barcode_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        barcode_err.setForeground(new java.awt.Color(255, 0, 51));
        barcode_err.setText("*");

        stock_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ข้างบน", "ข้างล่าง" }));
        stock_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_typeActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel15.setText("ที่อยู่สต๊อก");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(add_button)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selling_price)
                            .addComponent(size)
                            .addComponent(medicine_code)
                            .addComponent(back_button)
                            .addComponent(medicine_name, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(barcode, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(medicine_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stock_type, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sell_err, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(code_err, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(size_err, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medicine_name_err, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barcode_err, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barcode_err))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(medicine_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medicine_name_err))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medicine_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(code_err))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medicine_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(size_err))
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(sell_err))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stock_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_button)
                    .addComponent(back_button))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(339, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barcodeActionPerformed

    private void medicine_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicine_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicine_nameActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        // TODO add your handling code here:
        if(add_button.getText().equals("Update")) {
            Medicine_list newUi = new Medicine_list();
            newUi.setLocationRelativeTo(this);
            newUi.setVisible(true);
            dispose();
        } else {
            Database newUi = new Database();
            newUi.setLocationRelativeTo(this);
            newUi.setVisible(true);
            dispose();    
        }
    }//GEN-LAST:event_back_buttonActionPerformed

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        // TODO add your handling code here: 
        
        sell_err.setText("");
        medicine_name_err.setText("");
        size_err.setText("");
        code_err.setText("");
        barcode_err.setText("");
        
        Boolean checked = true;

        float selling_price_ = 0;

        
        String size_ = size.getText();

        String barcode_ = barcode.getText();
        String medicine_name_ = medicine_name.getText();
        String medicine_code_ = medicine_code.getText();

        if(barcode_.length() == 0) { barcode_err.setText("*โปรดใส่บาร์โค๊ด"); checked = false; }
        if(medicine_code_.length() == 0 ) { code_err.setText("*โปรดใส่รหัส"); checked = false; }
        if(medicine_name_.length() == 0 ) { medicine_name_err.setText("*โปรดใส่ชื่อยา"); checked = false; }
        if(size_.length() == 0 ) { size_err.setText("*โปรดใส่ขนาด"); checked = false; }
        
        try {
            selling_price_ = Float.parseFloat(selling_price.getText());
            if(selling_price_ == 0.0) sell_err.setText("*โปรดใส่ราคาขาย"); 
        } catch (NumberFormatException e) {
            sell_err.setText("*ราคาขาย ผิดรูปแบบ");
            checked = false; 
        }
        
        try {
            MySQLAccess db = new MySQLAccess();
            if (checked) {
                if(add_button.getText().equals("Update")) {
                    m.setBarcode(barcode_);
                    m.setName(medicine_name_);
                    m.setCode(medicine_code_);
                    m.setSize(size_);
                    m.setPrice(selling_price_);
                    m.setMedicineType(medicine_type.getSelectedIndex());
                    m.setStockType(stock_type.getSelectedIndex());
                    db.update_medicine(temp_barcode, m);
                } else {
                    m = new Medicine(barcode_, medicine_name_, medicine_code_, size_, selling_price_, medicine_type.getSelectedIndex(), stock_type.getSelectedIndex());
                    db.insert_medicines(m);
                    db.list_medicines();
                }

                Medicine_list newUi = new Medicine_list();
                newUi.setLocationRelativeTo(this);
                newUi.setVisible(true);
                dispose(); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_add_buttonActionPerformed

    private void medicine_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicine_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicine_typeActionPerformed

    private void medicine_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicine_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicine_codeActionPerformed

    private void sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeActionPerformed

    private void selling_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selling_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selling_priceActionPerformed

    private void stock_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stock_typeActionPerformed

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
            java.util.logging.Logger.getLogger(Adding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adding().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JButton back_button;
    private javax.swing.JTextField barcode;
    private javax.swing.JLabel barcode_err;
    private javax.swing.JLabel code_err;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField medicine_code;
    private javax.swing.JTextField medicine_name;
    private javax.swing.JLabel medicine_name_err;
    private javax.swing.JComboBox<String> medicine_type;
    private javax.swing.JLabel sell_err;
    private javax.swing.JTextField selling_price;
    private javax.swing.JTextField size;
    private javax.swing.JLabel size_err;
    private javax.swing.JComboBox<String> stock_type;
    // End of variables declaration//GEN-END:variables
}
