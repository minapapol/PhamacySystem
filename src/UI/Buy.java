/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Date;

/**
 *
 * @author Napapol
 */
public class Buy extends javax.swing.JFrame {

    /**
     * Creates new form Buy
     */
    public int id;
    
    public Buy() {
        initComponents();
        java.sql.Date temp = new java.sql.Date(new Date().getTime());
        DP_buy.setDate(temp);
    }

    public Buy(MedicineDetail md) {
        initComponents();
        id = md.id;
        
        barcode.setText(md.barcode);
        medicine_code.setText(md.medicine_code);
        size.setText(md.size);
        try {
            MySQLAccess db = new MySQLAccess();
            medicine_name.setText(db.get_medicine_name(md.barcode));
            if( medicine_name.getText().equals("none") ) barcode_err.setText("*รายการนี้ไม่มีอยู่ในฐานข้อมูล");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        company_name.setText(md.company_name);
        lot_no.setText(md.lot_no);
        selling_price.setText(md.selling_price+"");
        buying_price.setText(md.buying_price+"");
        amount.setText(md.amount+"");
        unit.setText(md.unit);
        
        DP_buy.setDate(md.buying_date);
        DP_exp.setDate(md.expired_date);
        DP_ini.setDate(md.initialize_date);
        
        switch(md.type){
            case "ยาอันตราย":
                medicine_type.setSelectedIndex(0);
                break;
            case "ยาควบคุมพิเศษ":
                medicine_type.setSelectedIndex(1);
                break;
            case "ยาทั่วไป":
                medicine_type.setSelectedIndex(2);
                break;        
        }
        
        addButton.setText("Update");
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        barcode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        medicine_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        medicine_code = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        company_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lot_no = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        buying_price = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        selling_price = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        unit = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        DP_exp = new org.jdesktop.swingx.JXDatePicker();
        DP_ini = new org.jdesktop.swingx.JXDatePicker();
        DP_buy = new org.jdesktop.swingx.JXDatePicker();
        barcode_err = new javax.swing.JLabel();
        code_err = new javax.swing.JLabel();
        company_err = new javax.swing.JLabel();
        lot_err = new javax.swing.JLabel();
        buy_err = new javax.swing.JLabel();
        sell_err = new javax.swing.JLabel();
        amount_err = new javax.swing.JLabel();
        unit_err = new javax.swing.JLabel();
        ini_err = new javax.swing.JLabel();
        exp_err = new javax.swing.JLabel();
        medicine_type = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        size = new javax.swing.JTextField();
        size_err = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("CordiaUPC", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("รายการสินค้า (ซื้อ)");

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        jLabel4.setText("รหัส");

        medicine_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicine_codeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel5.setText("ชื่อบริษัท");

        company_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                company_nameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel6.setText("Lot ที่");

        lot_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lot_noActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel7.setText("วันที่ซื้อ");

        jLabel8.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel8.setText("ราคาซื้อ");

        buying_price.setText("0.0");
        buying_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buying_priceActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel9.setText("ราคาขาย");

        selling_price.setText("0.0");
        selling_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selling_priceActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel10.setText("จำนวน");

        amount.setText("0");
        amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel11.setText("หน่วย");

        unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel13.setText("วันผลิต");

        jLabel14.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel14.setText("วันหมดอายุ");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        barcode_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        barcode_err.setForeground(new java.awt.Color(255, 0, 51));
        barcode_err.setText("*");

        code_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        code_err.setForeground(new java.awt.Color(255, 0, 51));
        code_err.setText("*");

        company_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        company_err.setForeground(new java.awt.Color(255, 0, 51));
        company_err.setText("*");

        lot_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        lot_err.setForeground(new java.awt.Color(255, 0, 51));
        lot_err.setText("*");

        buy_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        buy_err.setForeground(new java.awt.Color(255, 0, 51));
        buy_err.setText("*");

        sell_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        sell_err.setForeground(new java.awt.Color(255, 0, 51));
        sell_err.setText("*");

        amount_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        amount_err.setForeground(new java.awt.Color(255, 0, 51));
        amount_err.setText("*");

        unit_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        unit_err.setForeground(new java.awt.Color(255, 0, 51));
        unit_err.setText("*");

        ini_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        ini_err.setForeground(new java.awt.Color(255, 0, 51));
        ini_err.setText("*");

        exp_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        exp_err.setForeground(new java.awt.Color(255, 0, 51));
        exp_err.setText("*");

        medicine_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ยาอันตราย", "ยาควบคุมพิเศษ", "ยาทั่วไป" }));

        jLabel12.setFont(new java.awt.Font("CordiaUPC", 0, 20)); // NOI18N
        jLabel12.setText("ขนาด");

        size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeActionPerformed(evt);
            }
        });

        size_err.setFont(new java.awt.Font("Cordia New", 0, 20)); // NOI18N
        size_err.setForeground(new java.awt.Color(255, 0, 51));
        size_err.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(25, 25, 25)
                                .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(45, 45, 45)
                                .addComponent(medicine_name, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(15, 15, 15))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(8, 8, 8)))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buying_price, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DP_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DP_exp, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exp_err, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ini_err, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(269, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(medicine_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(barcode_err, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sell_err, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amount_err, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(unit_err, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buy_err, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DP_buy, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(lot_no, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(company_name, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(medicine_code, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lot_err, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(company_err, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(code_err, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(size_err, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barcode_err))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(medicine_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medicine_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(code_err)
                        .addComponent(medicine_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(size_err))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ini_err)
                        .addGap(4, 4, 4)
                        .addComponent(exp_err))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(company_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(company_err)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lot_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(lot_err))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buying_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buy_err))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(sell_err))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(amount_err)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(unit_err))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(DP_ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(DP_exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(jLabel7)
                    .addComponent(DP_buy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(464, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        UI newUi = new UI();
        newUi.setLocationRelativeTo(this);
        newUi.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void medicine_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicine_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicine_nameActionPerformed

    private void medicine_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicine_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicine_codeActionPerformed

    private void company_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_company_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_company_nameActionPerformed

    private void lot_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lot_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lot_noActionPerformed

    private void buying_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buying_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buying_priceActionPerformed

    private void selling_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selling_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selling_priceActionPerformed

    private void amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountActionPerformed

    private void unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        boolean checked = true;
        
        barcode_err.setText(""); 
        code_err.setText("");
        company_err.setText("");
        lot_err.setText("");
        unit_err.setText("");
        ini_err.setText("");
        exp_err.setText("");
        sell_err.setText("");
        buy_err.setText("");
        amount_err.setText("");
        size_err.setText("");
        
        float buying_price_ = 0;
        float selling_price_ = 0;
        int back_stock = 0;
        int amount_;
        String size_ = size.getText();

        String barcode_ = barcode.getText();
        String medicine_code_ = medicine_code.getText();
        String company_name_ = company_name.getText();
        String lot_no_ = lot_no.getText();
        String unit_ = unit.getText();
        
        java.sql.Date buying_date = new java.sql.Date(DP_buy.getDate().getTime());
        java.sql.Date initailize_date = null;
        java.sql.Date expired_date = null;
        
        if(barcode_.length() == 0) { barcode_err.setText("*โปรดใส่รหัส"); checked = false; }
        if(medicine_code_.length() == 0 ) { code_err.setText("*โปรดใส่รหัส"); checked = false; }
        if(company_name_.length() == 0 ) { company_err.setText("*โปรดใส่ชื่อบริษัท"); checked = false; }
        if(lot_no_.length() == 0 ) { lot_err.setText("*โปรดใส่เลขที่ LOT"); checked = false; }
        if(unit_.length() == 0 ) { unit_err.setText("*โปรดใส่หน่วยของสินค้า"); checked = false; }
        if(DP_ini.getDate() == null) { ini_err.setText("*โปรดใส่วันที่ผลิต"); checked = false; } else { initailize_date = new java.sql.Date(DP_ini.getDate().getTime()); }
        if(DP_exp.getDate() == null) { exp_err.setText("*โปรดใส่วันที่หมดอายุ"); checked = false; } else { expired_date = new java.sql.Date(DP_exp.getDate().getTime()); }
        
        try {
            buying_price_ = Float.parseFloat(buying_price.getText());
            if(buying_price_ == 0.0) buy_err.setText("*โปรดใส่ราคาซื้อ"); 
        } catch (NumberFormatException e) {
            buy_err.setText("*ราคาซื้อ ผิดรูปแบบ");
            checked = false; 
        }

        try {
            selling_price_ = Float.parseFloat(selling_price.getText());
            if(selling_price_ == 0.0) sell_err.setText("*โปรดใส่ราคาขาย"); 
        } catch (NumberFormatException e) {
            sell_err.setText("*ราคาขาย ผิดรูปแบบ");
            checked = false; 
        }
                
        try {
            back_stock = Integer.parseInt(amount.getText());
            amount_ = Integer.parseInt(amount.getText());
            if(amount_ == 0) { 
                amount_err.setText("*ใส่จำนวนสินค้า");
                back_stock =  amount_;
            }
        } catch (NumberFormatException e) {
            amount_err.setText("*จำนวน ผิดรูปแบบ");
            checked = false; 
        }
        
        System.out.print(medicine_type.getSelectedIndex());
        
        if (checked) {
            try {
                MySQLAccess db = new MySQLAccess();
                
                if (addButton.getText().equals("Add")) {
                    db.insert_medicine_details(barcode_, medicine_code_, company_name_, lot_no_, medicine_type.getSelectedIndex(), back_stock, buying_price_, selling_price_, back_stock, unit_, buying_date, initailize_date, expired_date, size_);
                    db.insert_buy_histories(barcode_, lot_no_, buying_date, back_stock, (back_stock*buying_price_));
                } else {
                    db.update_medicine_details(id,barcode_, medicine_code_, company_name_, lot_no_, medicine_type.getSelectedIndex(), back_stock, buying_price_, selling_price_, back_stock, unit_, buying_date, initailize_date, expired_date, size_);
                }
                this.setVisible(false);
                new UI().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeActionPerformed
        // TODO add your handling code here:
        System.out.print(evt.getActionCommand());
        barcode_err.setText("");
        
        try {
            MySQLAccess db = new MySQLAccess();
            medicine_name.setText(db.get_medicine_name(evt.getActionCommand()));
            if( medicine_name.getText().equals("none") ) barcode_err.setText("*รายการนี้ไม่มีอยู่ในฐานข้อมูล");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_barcodeActionPerformed

    private void sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeActionPerformed

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
            java.util.logging.Logger.getLogger(Buy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Buy newUi = new Buy();
                newUi.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker DP_buy;
    private org.jdesktop.swingx.JXDatePicker DP_exp;
    private org.jdesktop.swingx.JXDatePicker DP_ini;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField amount;
    private javax.swing.JLabel amount_err;
    private javax.swing.JTextField barcode;
    private javax.swing.JLabel barcode_err;
    private javax.swing.JLabel buy_err;
    private javax.swing.JTextField buying_price;
    private javax.swing.JLabel code_err;
    private javax.swing.JLabel company_err;
    private javax.swing.JTextField company_name;
    private javax.swing.JLabel exp_err;
    private javax.swing.JLabel ini_err;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lot_err;
    private javax.swing.JTextField lot_no;
    private javax.swing.JTextField medicine_code;
    private javax.swing.JTextField medicine_name;
    private javax.swing.JComboBox<String> medicine_type;
    private javax.swing.JLabel sell_err;
    private javax.swing.JTextField selling_price;
    private javax.swing.JTextField size;
    private javax.swing.JLabel size_err;
    private javax.swing.JTextField unit;
    private javax.swing.JLabel unit_err;
    // End of variables declaration//GEN-END:variables
}
