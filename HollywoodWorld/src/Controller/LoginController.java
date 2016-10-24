package Controller;

import Model.User;
import Model.UserDAO;
import View.LoginUI;

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
    
    @Override
    public boolean isUserNameValid(String userName){
        
        int minNameLength = 4;
        int nameLength = userName.length();
        
        if (nameLength >= minNameLength){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean isPasswordValid(String password){
        
        int minPasswordLength = 4;
        int passwordLength = password.length();
        
        if(passwordLength >= minPasswordLength){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public void assignUserName(String userName){
        user.setUserName(userName);
    }
    
    @Override
    public void assignPassword(String password){
        user.setPassword(password);
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
        loginUI.dispose();
    }
    
    private UserDAO userDAO;
    private User user;
    private LoginUI loginUI;
}
