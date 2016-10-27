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
public final class StatusValidator {
    
    public static final boolean success(int status){
        if (status == SUCCESS){
            return true;
        }else{
            return false;
        }
    }
    
    public static final boolean error(int status){
        if (status == ERROR){
            return true;
        }else{
            return false;
        }
    }
            
    public static final int ERROR = -1;
    public static final int SUCCESS = 0;
}
