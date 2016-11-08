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
public class EmployeeAdministrator {
    
    public static String registerEmployee(Employee employee){
        
        if(isEmployeeIdAvailable(employee.getId() ) ){
            if(StatusValidator.success(EmployeeDAO.save(employee) ) ){
                return "Employee succesfully registered";
            }else{
                return "Couldn't register employee...";
            }
        }else{
            return "Employee number not available";
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
    
    public static int generateNextEmployeeId(){
        
        int lastRegisteredId = EmployeeDAO.getLastRegistryIndex();
        int nextId = lastRegisteredId + 1;
        
        return nextId;
    }
    
    private static boolean isEmployeeIdAvailable(int employeeId){
        
        boolean isAvailable;
        if(EmployeeDAO.registryExists(employeeId) ){
            return false;
        }else{
            return true;
        }
    }
    
}
