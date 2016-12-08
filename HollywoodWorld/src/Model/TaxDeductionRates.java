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
public enum TaxDeductionRates {
    
    taxDeduction1(0.01,244.80,0.00,1.92),
    taxDeduction2(244.81,2077.50,4.65,6.40),
    taxDeduction3(2077.51,3651.00,121.95,10.88),
    taxDeduction4(3651.01,4244.10,293.25,16.00),
    taxDeduction5(4244.11,5081.40,388.05,17.92),
    taxDeduction6(5081.41,10248.45,538.20,21.36),
    taxDeduction7(10248.46,16156.05,1641.75,23.52),
    taxDeduction8(16153.06,30838.80,3030.60,30.00),
    taxDeduction9(30838.81,41118.45,7436.25,32.00),
    taxDeduction10(41118.46,123355.20,10725.75,34.00);
    
    TaxDeductionRates(double boundaryBotom,
        double boundaryTop,
        double fixedQuota,
        double percentageApplied
    ){
        this.boundaryBotom = boundaryBotom;
        this.boundaryTop = boundaryTop;
        this.fixedQuota = fixedQuota;
        this.percentageApplied = percentageApplied;    
    }    

    public double getBoundaryBotom() {
        return boundaryBotom;
    }

    public double getBoundaryTop() {
        return boundaryTop;
    }

    public double getFixedQuota() {
        return fixedQuota;
    }

    public double getPercentageApplied() {
        return percentageApplied;
    }
        
    private final double boundaryBotom; //En pesos
    private final double boundaryTop;   //En pesos
    private final double fixedQuota;    //En pesos
    private final double percentageApplied;//Porcentaje
}
