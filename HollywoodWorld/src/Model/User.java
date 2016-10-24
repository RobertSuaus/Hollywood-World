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
        UserPermissions permissions
        
        ){
            this.name = name;
            this.lastName = lastName;
            this.userName = userName;
            this.password = password;
            this.permissions = permissions;
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
    
    public void setPermissions(UserPermissions permissions){
        this.permissions = permissions;
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
    
    public UserPermissions getPermissions(){
        return permissions;
    }
    
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private UserPermissions permissions;
}
