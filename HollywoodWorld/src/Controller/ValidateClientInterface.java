package Controller;

import Model.Client;

/**
 *
 * @author Robert
 */
public interface ValidateClientInterface {
    
    public boolean isMembershipIdAvailable(int membershipId);
    
    public Client getClientInfo(int membershipId);
    public int getNextMembershipId();
    
    public void addClient(Client client);
    public void modifyClient(Client client);
    
}
