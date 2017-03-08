/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Napapol
 */
public class Medicine {
    String barcode;
    String name;
    String code;
    String size;
    float price;
    int stock_type;
    int medicine_type;
    
    public Medicine(String barcode, String name, String code,
            String size, float price, int stock_type, int medicine_type){
        this.barcode = barcode;
        this.name = name;
        this.code = code;
        this.size = size;
        this.price = price;
        this.stock_type = stock_type;
        this.medicine_type = medicine_type;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }
    
    public String getCode() {
        return code;
    }
        
    public String getSize() {
        return size;
    }
            
    public float getPrice() {
        return price;
    }
    
    public int getMedicineType () {
        return medicine_type;
    }
                
    public int getStockType () {
        return stock_type;
    }
                
    public String getMedicineTypeString() {
        switch(medicine_type) {
            case 0:
                return "ยาอันตราย";
            case 1:
                return "ยาควบคุมพิเศษ";
            case 2:
                return "ยาทั่วไป";
            case 3:
                return "อื่นๆ";
        }
        
        return "error";
    }
                    
    public String getStockTypeString() {
        switch(stock_type) {
            case 0:
                return "ข้างบน";
            case 1:
                return "ข้างล่าง";
        }
        return name;
    }

    public void setName(String name) {
       this.name = name; 
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
    public void setCode(String code) {
       this.code = code; 
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    public void setPrice(float price) {
       this.price = price; 
    }

    public void setStockType(int stock_type) {
        this.stock_type = stock_type;
    }
    
    public void setMedicineType(int medicine_type) {
       this.medicine_type = medicine_type; 
    }

}
