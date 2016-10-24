package Controller;

/**
 *
 * @author Robert
 */
public interface ValidateClientInterface {
    
    public boolean isClientNameValid(String clientName);
    public boolean isClientLastNameValid(String clientLastName);
    public boolean isClientAddressValid(String clientAddress);
    public boolean isClientTelephoneValid(String clientTelephone);
    
    public void assignClientName(String clientName);
    public void assignClientLastName(String clientLastName);
    public void assignClientAddress(String clientAddress);
    public void assignClientTelephone(String clientTelephone);
    public void assignMembershipStatus(/*boolean o MembershipStatus enum*/);
    
    public int getLastId();
    
    
}
