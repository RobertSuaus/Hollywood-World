package Controller;

import Model.Employee;
import Model.EmployeeDAO;
import Model.StatusValidator;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class HumanResourcesManager {
    
    public static String registerEmployee(Employee employee){

        if(StatusValidator.success(EmployeeDAO.save(employee) ) ){
            return "Employee succesfully registered";
        }else{
            return "Couldn't register employee...";
        }
    }
    
    public static String modifyEmployee(Employee employee){
        
        if(StatusValidator.success(EmployeeDAO.update(employee) ) ){
            return "Employee information updated!";
        }else{
            return "Couldn't update employee information...";
        }
    }
    
    public static Employee getEmployeeInfo(int employeeId){
        
        Employee employeeInfo = null;
        try {
            employeeInfo = EmployeeDAO.getRegistry(employeeId);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Date conversion error");
        }
        return employeeInfo;
    }
    
}
