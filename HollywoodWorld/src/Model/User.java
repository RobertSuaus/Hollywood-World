package Model;

/**
 *
 * @author Robert
 */
public class User {
    //Representa una usuario que interactua con el sistema.
    
    public User(
        String name,
        String lastName,
        String userName, //El alias o login
        String password,
        UserPermissions userPermissions
        
        ){
            this.name = name;
            this.lastName = lastName;
            this.userName = userName;
            this.password = password;
            this.userPermissions = userPermissions;
        }
    
    //
    public User(){
        userName = "";
        password = "";
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setUserPermissions(UserPermissions userPermissions){
        this.userPermissions = userPermissions;
    }
    
    public String getName(){
        return name;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public UserPermissions getUserPermissions(){
        return userPermissions;
    }
    
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private UserPermissions userPermissions;
}
