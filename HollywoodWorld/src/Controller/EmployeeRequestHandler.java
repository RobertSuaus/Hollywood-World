/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Employee;
import Model.EmployeeDAO;
import Model.StatusValidator;
import View.RegisterEmployeeForm;
import View.ModifyEmployeeForm;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author che_i
 */
public class EmployeeRequestHandler {
    
    public EmployeeRequestHandler(RegisterEmployeeForm registerEmployeeForm) {
        
        this.registerEmployeeForm = registerEmployeeForm;
        this.employee = new Employee(
            generateNextEmployeeId()
        );
        handleWindowInitialization();        
    }
    
    public EmployeeRequestHandler(ModifyEmployeeForm modifyEmployeeForm) {
        
        this.modifyEmployeeForm = modifyEmployeeForm;
        this.employee = new Employee(
            generateNextEmployeeId()
        );
    }
    
    public String handleRegistration(String[] userInputs) throws ParseException{
        
        setEmployeeInformation(userInputs);
        if(isEmployeeDataValid()){
            //Validar código de empleado, Que no está ocupado
            return EmployeeAdministrator.registerEmployee(employee);
        }
        return INVALID_DATA_MSG;
    }
    
    public String handleModification(String[] userInputs) throws ParseException{
        
        setEmployeeInformation(userInputs);
        if(isEmployeeDataValid()){
            return EmployeeAdministrator.modifyEmployee(employee);
        }        
        return INVALID_DATA_MSG;
    }
    
    public String handleRetrieval(String employeeIdInput){
        
        if(isValidInputNumber(employeeIdInput)){
            int employeeId = Integer.valueOf(employeeIdInput);
            employee = EmployeeAdministrator.getEmployeeInfo(employeeId);
            modifyEmployeeForm.fillExistingEmployeeForm(employee);
            return "Mostrando datos de: "+employee.getName();
        }
        return INVALID_DATA_MSG;
    }
    
    private void handleWindowInitialization(){
        int nextId = generateNextEmployeeId();
        registerEmployeeForm.fillEmployeeIdField(nextId);
    }

    private void setEmployeeInformation(String[] userInputs) throws ParseException{
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date admissionDate = new Date();
        
        employee.setName(userInputs[0]);
        employee.setLastName(userInputs[1]);
        employee.setTelephone(userInputs[2]);
        employee.setAddress(userInputs[3]);
        employee.setId(Integer.parseInt(userInputs[4]));
        employee.setRfc(userInputs[5]);
        employee.setBasicSalary(Double.parseDouble(userInputs[6]));        
        admissionDate = dateFormat.parse(userInputs[7]);
        employee.setAdmissionDate(admissionDate);
        employee.setPosition(userInputs[8]);
        
    }
    
    public int generateNextEmployeeId(){
        
        int lastRegisteredId = EmployeeDAO.getLastRegistryIndex();
        int nextId = lastRegisteredId + 1;
        
        return nextId;
    }
    
    private boolean isEmployeeIdAvailable(int employeeId){
        
        boolean isAvailable;
        if(EmployeeDAO.registryExists(employeeId) ){
            isAvailable = false;
        }else{
            isAvailable = true;
        }
        return isAvailable;
    }
    
    private boolean isEmployeeDataValid(){
        
        if(isValidInputText( employee.getName() )&& 
            isValidInputText( employee.getLastName() )&&
            isValidInputTelephone( employee.getTelephone() )&&
            isValidInputAddress( employee.getAddress() ) &&
            isValidInputText( employee.getRfc() )&&
            isValidInputBasicSalary( String.valueOf(employee.getBasicSalary() ) )&&
            isValidInputDate(employee.getAdmissionDate() ) &&
            isValidInputText( employee.getPosition() ) 
        ){
            return true;
        }
        else{
            return false;
        }
    }
    
    private boolean isValidInputText(String input){
        
        if (input.matches("([A-Za-z]|\\s)*") 
            && input.equals(" ") == false 
            && input.equals("") == false){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isValidInputBasicSalary(String input){
        if (input.matches("(|[0-9])*.([0-9])*") && 
            input.equals(" ") == false && 
            input.equals("") == false
            ){
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "aaaaaa");
                return false;
            }
    }
    
    private boolean isValidInputAddress(String input){
        
        if (input.matches("([A-Za-z]|\\s|[0-9]|#|-)*") 
            && input.equals(" ") == false 
            && input.equals("") == false){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isValidInputTelephone(String input){
        
        if (input.matches("([0-9]|\\s)*") 
            && input.equals(" ") == false 
            && input.equals("") == false){
            return true;
        }else{
            return false;
        }
    }
       
    private boolean isValidInputNumber(String input){
        if (input.matches("([0-9]|\\s)*") 
            && input.equals(" ") == false 
            && input.equals("") == false){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isValidInputDate(Date date){
        
        if (date!=null){
            return true;
        }else{
            return false;
        }
    }
    
    private Employee employee;
    private RegisterEmployeeForm registerEmployeeForm;
    private ModifyEmployeeForm modifyEmployeeForm;
    private final String INVALID_DATA_MSG = "Los datos ingresados no son validos";
}
