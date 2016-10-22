package Controller;

import Model.User;
import Model.UserDAO;

/**
 *
 * @author Robert
 */
public class LoginController implements ValidateLoginInterface {
    /*Clase encargada de la funcionalidad del sistema de login*/
    
    public LoginController(){
        userDAO = new UserDAO();
        user = new User();
        loginUI = new LoginUI(this);
    }
    
    //Métodos para la validación de datos de usuario
    @Override
    public void validateUserName(String inUserName){
        
        int minNameLength = 4;
        int inNameLength = inUserName.length();
        
        if (inNameLength >= minNameLength){
            user.setUserName(inUserName);
        }
    }
    
    @Override
    public void validatePassword(String inPassword){
        
        int minPasswordLength = 4;
        int inPasswordLength = inPassword.length();
        
        if(inPasswordLength >= minPasswordLength){
            user.setPassword(inPassword);
        }
    }
    
    @Override
    public boolean authenticateUser(){
        /*Verificar que en la base de datos se encuentre
        el usuario con la contraseña correspondiente*/
        
        boolean isInfoValid = userDAO.isUserInfoCoincident(user);
        return isInfoValid;
    }
    
    @Override
    public void initiateSession(){
        /*Iniciar el sistema con la sesión de usuario correspondiente*/
        
        String userName = user.getUserName();
        User authenticatedUser = userDAO.getUserInfo(userName);
        
        new MainMenuController (authenticatedUser);
    }
    
    private UserDAO userDAO;
    private User user;
    private LoginUI loginUI;
}
