/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    vendor (3);
    
    UserPermissions(int permissionLevel){
        this.permissionLevel = permissionLevel;
    }
    
    public int getPermissionLevel(){
        return permissionLevel;
    }
    
    private final int permissionLevel;
}
