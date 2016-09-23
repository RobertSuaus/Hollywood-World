/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robert
 */
package Model;

public class Person {
    //Clase base de la que se derivan los clientes y empleados
    
    public Person(
        String name,
        String lastName,
        String telephone,
        String address
    ){
        this.name = name;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }
    
    private String name;
    private String lastName;
    private String telephone;
    private String address;
}
