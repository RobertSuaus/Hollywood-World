package Model;

/**
 *
 * @author Robert
 */
public enum UserPermissions
{
    administrator (0),
    manager (1),
    humanResources (2),
    renter (3);
    
    UserPermissions(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
    
    private final int value;
}
