/**
 *
 * @author Robert
 */
package Model;

public class Person {
    /*Clase base de la que se derivan los clientes y empleados que interactuan
    con el sistema*/
    
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

    public String getTelephone() {
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
