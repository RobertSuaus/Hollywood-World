package Controller;

import Model.User;
import Model.UserDAO;
import View.LoginUI;

/**
 *
 * @author Robert
 */
public class LoginController implements ValidateLoginInterface {
    /*Clase encargada de la funcionalidad del sistema de login
    Autentifica los usuarios e inicia sesión con sus datos*/
    
    public LoginController(){
        userDAO = new UserDAO();
        loginUI = new LoginUI(this);
    }
    
    @Override
    public boolean authenticateUser(User user){
        /*Verificar que en la base de datos se encuentre
        el usuario con la contraseña correspondiente*/
        
        boolean isInfoValid = userDAO.isUserInfoCoincident(user);
        
        return isInfoValid;
    }
    
    @Override
    public void initiateSession(User user){
        /*Iniciar el sistema con la sesión de usuario correspondiente*/
        
        String userName = user.getUserName();
        User authenticatedUser = userDAO.getUserInfo(userName);
        
        new MainMenuController (authenticatedUser);
        loginUI.dispose();
    }
    
    private UserDAO userDAO;
    private LoginUI loginUI;
}
