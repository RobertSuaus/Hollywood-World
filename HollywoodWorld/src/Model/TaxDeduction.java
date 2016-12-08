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
public class TaxDeduction {
    
    public TaxDeduction(double boundaryBotom,
        double boundaryTop,
        double fixedQuota,
        double percentajeApplied
    ){
      this.boundaryBotom = boundaryBotom;
      this.boundaryTop = boundaryTop;
      this.fixedQuota = fixedQuota;
      this.percentageApplied = percentageApplied;
    }

    public double getBoundaryBotom() {
        return boundaryBotom;
    }

    public void setBoundaryBotom(double boundaryBotom) {
        this.boundaryBotom = boundaryBotom;
    }

    public double getBoundaryTop() {
        return boundaryTop;
    }

    public void setBoundaryTop(double boundaryTop) {
        this.boundaryTop = boundaryTop;
    }

    public double getFixedQuota() {
        return fixedQuota;
    }

    public void setFixedQuota(double fixedQuota) {
        this.fixedQuota = fixedQuota;
    }

    public double getPercentageApplied() {
        return percentageApplied;
    }

    public void setPercentageApplied(double percentageApplied) {
        this.percentageApplied = percentageApplied;
    }
    
    private double boundaryBotom; //En pesos
    private double boundaryTop;   //En pesos
    private double fixedQuota;    //En pesos
    private double percentageApplied;//Porcentaje
}
