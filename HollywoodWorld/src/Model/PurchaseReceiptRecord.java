/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Robert
 */
public class PurchaseReceiptRecord {
    /*Un registro del recibo de compra*/
    
    public PurchaseReceiptRecord(
        String productName,
        double unitPrice,
        int quantity
        ){
            this.productName = productName;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
            this.totalPrice = computeTotalPrice();
        }
    
    public String getProductName(){
        return productName;
    }
    
    public double getUnitPrice(){
        return unitPrice;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public double getTotalPrice(){
        return totalPrice;
    }
    
    public final double computeTotalPrice(){
        double total;
        total = unitPrice * quantity;
        return total;
    }
    
    private String productName;
    private double unitPrice;
    private int quantity;
    private double totalPrice;
}
