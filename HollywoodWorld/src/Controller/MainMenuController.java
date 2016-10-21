package Controller;

import Model.Employee;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class MainMenuController implements ValidateMainMenuInterface {
    /*Clase encargada de la funcionalidad del menú principal.
    Verifica que el empleado usando el sistema tenga acceso a las secciones
    correspondientes.*/
    
    public MainMenuController(Employee loggedEmployee){
        this.loggedEmployee = loggedEmployee;
        mainMenuUI = new MainMenuUI(this);
    }
    
    @Override
    public void handleRentOption(){
        if(employeeHasPosition("Vendor")){
            
        }else{
            JOptionPane.showMessageDialog(null, 
                "No puedes acceder a esta función"
            );
        }
    }
    
    @Override
    public void handleHumanResourcesOption(){
        
    }
    
    @Override
    public void handleManagingOption(){
        
    }
    
    @Override
    public void terminateSession(){
        
    }
    
    private boolean employeeHasPosition(String position){
        //Verifica que el empleado tenga el puesto indicado
        String employeePosition = loggedEmployee.getPosition().toString();
        
        return employeePosition.equals(position);
    }
    
    private Employee loggedEmployee;
    private MainMenuUI mainMenuUI;
}
