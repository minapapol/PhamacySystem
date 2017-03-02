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
public class MedicineDetail {

    int id;
    int back_stock;
    int front_stock;
    int amount;
    float buying_price;
    float selling_price;
    String type;
    String barcode;
    String medicine_code;
    String company_name;
    String lot_no;
    String size;
    String unit;
    Date buying_date;
    Date initialize_date;
    Date expired_date;
    int pack_amount;
    float pack_price;
    
    public MedicineDetail(int id, int back_stock, int front_stock, int amount,
            float buying_price, float selling_price,
            String type, String barcode, String medicine_code, String company_name,
            String lot_no, String size, String unit,
            Date buying_date, Date initialize_date, Date expired_date,
            int pack_amount, float pack_price) {
        this.id = id;
        this.back_stock = back_stock;
        this.front_stock = front_stock;
        this.amount = amount;
        this.buying_price = buying_price;
        this.selling_price = selling_price;
        this.type = type;
        this.barcode = barcode;
        this.medicine_code = medicine_code;
        this.company_name = company_name;
        this.lot_no = lot_no;
        this.size = size;
        this.unit = unit;
        this.buying_date = buying_date;
        this.initialize_date = initialize_date;
        this.expired_date = expired_date;
        this.pack_amount = pack_amount;
        this.pack_price = pack_price;
    }
    
    public int get_front_stock(){
        return front_stock;
    }
    
    public int get_back_stock(){
        return back_stock;
    }

    public String getType() {
        return type;
    }

    public String getCompanyName() {
        return company_name;
    }

    public float pricePerUnit() {
        return buying_price;
    }

    public String getLot() {
        return lot_no;
    }

    public String getExpiredDateString() {
        return expired_date.toString();
    }
    
}
