package View;

import Controller.ValidateClientInterface;
import Model.Client;
import Model.ClientMembership;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class ClientUI extends javax.swing.JFrame {

    /**
     * Creates new form ClientUI
     */
    public ClientUI(ValidateClientInterface validateClient) {
        
        initComponents(); //Componentes visuales de Swing
        this.setVisible(true);
        this.existingClientInfoPanel.setVisible(false);
        
        this.validateClient = validateClient;
        this.newClient = new Client(
            new ClientMembership(
                    this.validateClient.getNextMembershipId(),
                    "Active"
                )
            );
        fillMembershipField();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        newClientPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        newNameTxt = new javax.swing.JTextField();
        newLastNameTxt = new javax.swing.JTextField();
        newTelephoneTxt = new javax.swing.JTextField();
        newAddressTxt = new javax.swing.JTextField();
        newMembershipTxt = new javax.swing.JTextField();
        registerNewClientBtn = new javax.swing.JButton();
        editClientPanel = new javax.swing.JPanel();
        existingClientInfoPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        editNameTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        editLastNameTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        editTelephoneTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        editAddressTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        editMembershipTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        membershipStatus = new javax.swing.JComboBox<>();
        saveChangesBtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        searchMembershipTxt = new javax.swing.JTextField();
        searchClientBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hollywood World - Manage Clients");
        setResizable(false);

        jLabel17.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jLabel17.setText("Client Registration");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Last name:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Telephone:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Address:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Membership number:");

        newNameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                newNameTxtFocusLost(evt);
            }
        });

        newLastNameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                newLastNameTxtFocusLost(evt);
            }
        });

        newTelephoneTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                newTelephoneTxtFocusLost(evt);
            }
        });

        newMembershipTxt.setEditable(false);

        registerNewClientBtn.setText("Register new client");
        registerNewClientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerNewClientBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newClientPanelLayout = new javax.swing.GroupLayout(newClientPanel);
        newClientPanel.setLayout(newClientPanelLayout);
        newClientPanelLayout.setHorizontalGroup(
            newClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newClientPanelLayout.createSequentialGroup()
                .addGroup(newClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newClientPanelLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel17))
                    .addGroup(newClientPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(newClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(newClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newNameTxt)
                            .addComponent(newLastNameTxt)
                            .addComponent(newTelephoneTxt)
                            .addComponent(newAddressTxt)
                            .addComponent(newMembershipTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))))
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newClientPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(registerNewClientBtn)
                .addGap(85, 85, 85))
        );
        newClientPanelLayout.setVerticalGroup(
            newClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newClientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(newClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(newNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(newLastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(newTelephoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(newAddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(newMembershipTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(registerNewClientBtn)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Register new client", newClientPanel);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Name:");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Last name:");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Telephone:");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Address:");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Membership number:");

        editMembershipTxt.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Membership status:");

        membershipStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));

        saveChangesBtn.setText("Save Changes");
        saveChangesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout existingClientInfoPanelLayout = new javax.swing.GroupLayout(existingClientInfoPanel);
        existingClientInfoPanel.setLayout(existingClientInfoPanelLayout);
        existingClientInfoPanelLayout.setHorizontalGroup(
            existingClientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(existingClientInfoPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(existingClientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(28, 28, 28)
                .addGroup(existingClientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editNameTxt)
                    .addComponent(editLastNameTxt)
                    .addComponent(editTelephoneTxt)
                    .addComponent(editAddressTxt)
                    .addComponent(editMembershipTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(membershipStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, existingClientInfoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveChangesBtn)
                .addGap(68, 68, 68))
        );
        existingClientInfoPanelLayout.setVerticalGroup(
            existingClientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(existingClientInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(existingClientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(editNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(existingClientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(editLastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(existingClientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(editTelephoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(existingClientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(editAddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(existingClientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(editMembershipTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(existingClientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(membershipStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(saveChangesBtn))
        );

        jLabel18.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jLabel18.setText("Modify client information");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Membership number:");

        searchClientBtn.setText("Search");
        searchClientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchClientBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editClientPanelLayout = new javax.swing.GroupLayout(editClientPanel);
        editClientPanel.setLayout(editClientPanelLayout);
        editClientPanelLayout.setHorizontalGroup(
            editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editClientPanelLayout.createSequentialGroup()
                .addGroup(editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editClientPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(existingClientInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(editClientPanelLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(editClientPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchMembershipTxt))
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchClientBtn)
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
        );
        editClientPanelLayout.setVerticalGroup(
            editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editClientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(searchMembershipTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchClientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(existingClientInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Modify client information", editClientPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerNewClientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerNewClientBtnActionPerformed
        
        //Antes de obtener la información, validar
        gatherNewClientInformation();
        ClientMembership newMembership = newClient.getMembership();
        int newMembershipId = newMembership.getId();
        
        if(validateClient.isMembershipIdAvailable(newMembershipId) ){
            String operationStatus;
            operationStatus= validateClient.addClient(newClient);
            JOptionPane.showMessageDialog(null, operationStatus);
        }else{
            JOptionPane.showMessageDialog(null, "Membership number already in use");
        }
    }//GEN-LAST:event_registerNewClientBtnActionPerformed

    private void searchClientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchClientBtnActionPerformed
        
        int membershipId = Integer.valueOf(searchMembershipTxt.getText() );
        if(!validateClient.isMembershipIdAvailable(membershipId) ){
            
            existingClient = validateClient.getClientInfo(membershipId);
            existingClientInfoPanel.setVisible(true);
            fillExistingClientForm();
        }else{
            JOptionPane.showMessageDialog(null, "That membership number doesn't exist");
        }
    }//GEN-LAST:event_searchClientBtnActionPerformed

    private void saveChangesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesBtnActionPerformed
        
        //Antes de obtener la información, validar
        gatherExistingClientInformation();
        String operationStatus;
        operationStatus= validateClient.modifyClient(existingClient);
        
        JOptionPane.showMessageDialog(null, operationStatus);
    }//GEN-LAST:event_saveChangesBtnActionPerformed

    private void newNameTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newNameTxtFocusLost
        if(!isValidInputText(newNameTxt.getText())){
            JOptionPane.showMessageDialog(null, "Invalid client name");
        }
    }//GEN-LAST:event_newNameTxtFocusLost

    private void newLastNameTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newLastNameTxtFocusLost
        if(!isValidInputText(newLastNameTxt.getText())){
            JOptionPane.showMessageDialog(null, "Invalid client last name");
        }
    }//GEN-LAST:event_newLastNameTxtFocusLost

    private void newTelephoneTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newTelephoneTxtFocusLost
        if(!isValidInputTelephone(newTelephoneTxt.getText())){
             JOptionPane.showMessageDialog(null, "Invalid client telephone");
        }
    }//GEN-LAST:event_newTelephoneTxtFocusLost

    private void gatherNewClientInformation(){
        
        newClient.setName(newNameTxt.getText() );
        newClient.setLastName(newLastNameTxt.getText() ); 
        newClient.setTelephone(newTelephoneTxt.getText() );
        newClient.setAddress(newAddressTxt.getText() );
        
    }
    
    private void gatherExistingClientInformation(){
        
        existingClient.setName(editNameTxt.getText() );
        existingClient.setLastName(editLastNameTxt.getText() );
        existingClient.setTelephone(editTelephoneTxt.getText() );
        existingClient.setAddress(editAddressTxt.getText());
        
        int currentId = existingClient.getMembership().getId();
        String currentStatus = String.valueOf(
                membershipStatus.getSelectedItem() 
                );
        
        existingClient.setMembership(
                new ClientMembership(currentId, currentStatus)
                );
        
    }
    
    private void fillMembershipField(){
        
        newMembershipTxt.setText(
                String.valueOf(newClient.getMembership().getId() ) );
    }
    
    private void fillExistingClientForm(){
        
        editNameTxt.setText(existingClient.getName() );
        editLastNameTxt.setText(existingClient.getLastName() );
        editTelephoneTxt.setText(existingClient.getTelephone() );
        editAddressTxt.setText(existingClient.getAddress() );
        
        String membershipNumber = String.valueOf(
            existingClient.getMembership().getId()
            );
        
        editMembershipTxt.setText(membershipNumber);
        
        membershipStatus.setSelectedIndex(
            getStatusIndex(existingClient.getMembership().getStatus() )
            );
    }
    
    private int getStatusIndex(String membershipStatus){
        
        int statusIndex;
        
        switch(membershipStatus){
            case "Active" : statusIndex = 0;
                break;
            case "Inactive" : statusIndex = 1;
                break;
            default : statusIndex = ERROR;
        }
        return statusIndex;
    }
    
    private ValidateClientInterface validateClient;
    private Client newClient;
    private Client existingClient;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField editAddressTxt;
    private javax.swing.JPanel editClientPanel;
    private javax.swing.JTextField editLastNameTxt;
    private javax.swing.JTextField editMembershipTxt;
    private javax.swing.JTextField editNameTxt;
    private javax.swing.JTextField editTelephoneTxt;
    private javax.swing.JPanel existingClientInfoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> membershipStatus;
    private javax.swing.JTextField newAddressTxt;
    private javax.swing.JPanel newClientPanel;
    private javax.swing.JTextField newLastNameTxt;
    private javax.swing.JTextField newMembershipTxt;
    private javax.swing.JTextField newNameTxt;
    private javax.swing.JTextField newTelephoneTxt;
    private javax.swing.JButton registerNewClientBtn;
    private javax.swing.JButton saveChangesBtn;
    private javax.swing.JButton searchClientBtn;
    private javax.swing.JTextField searchMembershipTxt;
    // End of variables declaration//GEN-END:variables
    
}
