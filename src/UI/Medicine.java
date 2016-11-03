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
    
    public Medicine(String barcode, String name){
        this.barcode = barcode;
        this.name = name;
    }

    String getBarcode() {
        return barcode;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
       this.name = name; 
    }

    void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
