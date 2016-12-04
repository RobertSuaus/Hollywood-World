/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author che_i
 */
public class Retention {
    
    public Retention(){
        this.taxPerIMSS = 0;
        this.ISR = 0;
    }
    
    public Retention(double taxPerIMSS, double ISR){
        this.taxPerIMSS = taxPerIMSS;
        this.ISR = ISR;
    }

    public double getTaxPerIMSS() {
        return taxPerIMSS;
    }

    public void setTaxPerIMSS(double taxPerIMSS) {
        this.taxPerIMSS = taxPerIMSS;
    }

    public double getISR() {
        return ISR;
    }

    public void setISR(double ISR) {
        this.ISR = ISR;
    }
    
    private double taxPerIMSS;
    private double ISR;
}
