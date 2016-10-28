package Model;
import java.util.Date;
/**
 *
 * @author Robert
 */
public class Employee extends Person {
    //Representa un empleado que trabaja en el negocio
    
    public Employee(
        String name,
        String lastName,
        String telephone,
        String address,
        int id,
        String rfc,
        double basicSalary,
        Date admissionDate,
        String position
        ){
            super(name, lastName, telephone, address);
            this.id = id;
            this.rfc = rfc;
            this.basicSalary = basicSalary;
            this.admissionDate = admissionDate;
            this.position = position;
        }
    
    public Employee(int id){
        super("","","","");
        this.id = id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setRfc(String rfc){
        this.rfc = rfc;
    }
    
    public void setBasicSalary(double basicSalary){
        this.basicSalary = basicSalary;
    }
    
    public void setAdmissionDate(Date admissionDate){
        this.admissionDate = admissionDate;
    }
    
    public void setPosition(String position){
        this.position = position;
    }
    
    public int getId(){
        return id;
    }
    
    public String getRfc(){
        return rfc;
    }
    
    public double getBasicSalary(){
        return basicSalary;
    }
    
    public Date getAdmissionDate(){
        return admissionDate;
    }
    
    public String getPosition(){
        return position;
    }
    
    private int id;
    private String rfc;
    private double basicSalary;
    private Date admissionDate;
    private String position;
}
