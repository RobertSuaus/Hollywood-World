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
public class Bonus {
    
    public Bonus(){
        this.christmasBox = 0;
        this.holiday = 0;
        this.dominical = 0;
    }
    
    public Bonus(double christmasBox, double holidayBonus, double dominical) {
        this.christmasBox = christmasBox;
        this.holiday = holidayBonus;
        this.dominical = dominical;
    }

    public double getChristmasBox() {
        return christmasBox;
    }

    public void setChristmasBox(double christmasBox) {
        this.christmasBox = christmasBox;
    }

    public double getHolidayBonus() {
        return holiday;
    }

    public void setHolidayBonus(double holidayBonus) {
        this.holiday = holidayBonus;
    }

    public double getDominical() {
        return dominical;
    }

    public void setDominical(double dominical) {
        this.dominical = dominical;
    }
    
    private double christmasBox;
    private double holiday;
    private double dominical;
}
