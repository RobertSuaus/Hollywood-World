package View;

import Controller.ClientServiceAgent;
import Model.Client;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class ModifyClientForm extends javax.swing.JFrame {

    /**
     * Creates new form ClientUI
     */
    public ModifyClientForm() {
        
        initComponents(); //Componentes visuales de Swing
        this.setVisible(true);
        this.existingClientInfoPanel.setVisible(false);
        
        this.clientServiceAgent = new ClientServiceAgent(this);
    }
    
    public void fillExistingClientForm(Client client){
        
        editNameTxt.setText(client.getName() );
        editLastNameTxt.setText(client.getLastName() );
        editTelephoneTxt.setText(client.getTelephone() );
        editAddressTxt.setText(client.getAddress() );
        
        String membershipNumber = String.valueOf(
            client.getMembership().getId()
            );
        
        editMembershipTxt.setText(membershipNumber);
        
        membershipStatus.setSelectedIndex(
            getStatusIndex(client.getMembership().getStatus() )
            );
        
        existingClientInfoPanel.setVisible(true);
    }
    
    public void nextSheet(){
        
        searchMembershipTxt.setText("");
        editNameTxt.setText("");
        editLastNameTxt.setText("");
        editAddressTxt.setText("");
        editTelephoneTxt.setText("");
        editMembershipTxt.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Nombre:");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Apellido:");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Teléfono:");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Dirección:");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Número de membresia:");

        editMembershipTxt.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Estado de membresia:");

        membershipStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        saveChangesBtn.setText("Guardar cambios");
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
                .addContainerGap()
                .addGroup(existingClientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(existingClientInfoPanelLayout.createSequentialGroup()
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
                            .addComponent(editMembershipTxt)
                            .addComponent(membershipStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, existingClientInfoPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveChangesBtn)))
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(saveChangesBtn))
        );

        javax.swing.GroupLayout editClientPanelLayout = new javax.swing.GroupLayout(editClientPanel);
        editClientPanel.setLayout(editClientPanelLayout);
        editClientPanelLayout.setHorizontalGroup(
            editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editClientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(existingClientInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        editClientPanelLayout.setVerticalGroup(
            editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editClientPanelLayout.createSequentialGroup()
                .addComponent(existingClientInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jLabel18.setText("Modificar información de cliente");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Número de membresia");

        searchClientBtn.setText("Buscar");
        searchClientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchClientBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editClientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchMembershipTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchClientBtn))
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(searchMembershipTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchClientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editClientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchClientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchClientBtnActionPerformed
        
        String membershipIdInput = searchMembershipTxt.getText();
        
        String operationStatus = 
                clientServiceAgent.requestClientRetrieval(membershipIdInput);
        JOptionPane.showMessageDialog(null, operationStatus);
        
    }//GEN-LAST:event_searchClientBtnActionPerformed

    private void saveChangesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesBtnActionPerformed
        
        String[] userInputs = gatherAllUserInput();
        String operationStatus = 
                clientServiceAgent.requestClientModification(userInputs);
        JOptionPane.showMessageDialog(null, operationStatus);
    }//GEN-LAST:event_saveChangesBtnActionPerformed

    private String[] gatherAllUserInput(){
        
        String[] userInput = new String[6];
        userInput[0] = editNameTxt.getText();
        userInput[1] = editLastNameTxt.getText();
        userInput[2] = editTelephoneTxt.getText();
        userInput[3] = editAddressTxt.getText();
        userInput[4] = editMembershipTxt.getText();
        userInput[5] = String.valueOf(
                membershipStatus.getSelectedItem() 
                );
        
        return userInput;
        
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
    
    private ClientServiceAgent clientServiceAgent;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField editAddressTxt;
    private javax.swing.JPanel editClientPanel;
    private javax.swing.JTextField editLastNameTxt;
    private javax.swing.JTextField editMembershipTxt;
    private javax.swing.JTextField editNameTxt;
    private javax.swing.JTextField editTelephoneTxt;
    private javax.swing.JPanel existingClientInfoPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> membershipStatus;
    private javax.swing.JButton saveChangesBtn;
    private javax.swing.JButton searchClientBtn;
    private javax.swing.JTextField searchMembershipTxt;
    // End of variables declaration//GEN-END:variables
    
}
