package Controller;

import Model.User;
import Model.UserDAO;
import View.LoginUI;
import View.MainMenuUI;
import java.awt.Window;

/**
 *
 * @author Robert
 */
public class SessionManager {
    /*Clase encargada de la funcionalidad del sistema de login
    Autentifica los usuarios e inicia sesión con sus datos*/
    
    public static void initiateSession(User user){
        
        String userName = user.getUserName();
        User authenticatedUser = UserDAO.obtainRegistry(userName);
        
        new MainMenuUI (authenticatedUser);
    
    }
    
    public static void terminateSession(){
        
        closeAllWindows();
        openNewLoginWindow();
        
    }
    
    private static void closeAllWindows(){
        System.gc();
        for (Window window : Window.getWindows()){
            window.dispose();
        }
    }
    
    private static void openNewLoginWindow(){
        new LoginUI();
    }
}
