/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EmployeeRequestHandler;
import Model.Employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class ModifyEmployeeForm extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeUI
     */
    public ModifyEmployeeForm() {
        initComponents();
        this.setVisible(true);
        existingEmployeePanel.setVisible(false);
        
        this.employeeRequestHandler = new EmployeeRequestHandler(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editEmployeePanel = new javax.swing.JPanel();
        existingEmployeePanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        editNameTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        editLastNameTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        editTelephoneTxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        editAddressTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        editIdTxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        editRfcTxt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        editSalaryTxt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        editAdmissionDate = new org.jdesktop.swingx.JXDatePicker();
        jLabel21 = new javax.swing.JLabel();
        editPositionTxt = new javax.swing.JTextField();
        saveChangesBtn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        searchEmployeeIdTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hollywood World - Manage Employees");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Name:");

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Last name:");

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setText("Telephone:");

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Address:");

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setText("Employee number:");

        editIdTxt.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setText("RFC:");

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Basic Salary:");

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel20.setText("Admission Date:");

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel21.setText("Employee Position:");

        saveChangesBtn.setText("Save Changes");
        saveChangesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout existingEmployeePanelLayout = new javax.swing.GroupLayout(existingEmployeePanel);
        existingEmployeePanel.setLayout(existingEmployeePanelLayout);
        existingEmployeePanelLayout.setHorizontalGroup(
            existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, existingEmployeePanelLayout.createSequentialGroup()
                .addContainerGap(319, Short.MAX_VALUE)
                .addComponent(saveChangesBtn)
                .addGap(33, 33, 33))
            .addGroup(existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(existingEmployeePanelLayout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addGroup(existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16)
                        .addComponent(jLabel17)
                        .addComponent(jLabel20)
                        .addComponent(jLabel21))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(editNameTxt)
                        .addComponent(editLastNameTxt)
                        .addComponent(editTelephoneTxt)
                        .addComponent(editAddressTxt)
                        .addComponent(editIdTxt)
                        .addComponent(editRfcTxt)
                        .addComponent(editSalaryTxt)
                        .addComponent(editAdmissionDate, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addComponent(editPositionTxt))
                    .addContainerGap(73, Short.MAX_VALUE)))
        );
        existingEmployeePanelLayout.setVerticalGroup(
            existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, existingEmployeePanelLayout.createSequentialGroup()
                .addGap(0, 311, Short.MAX_VALUE)
                .addComponent(saveChangesBtn))
            .addGroup(existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(existingEmployeePanelLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(editNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(editLastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(editTelephoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(editAddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(editIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(editRfcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(editSalaryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(editAdmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(existingEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(editPositionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(35, Short.MAX_VALUE)))
        );

        jLabel19.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jLabel19.setText("Modify Employee");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Employee Number:");

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editEmployeePanelLayout = new javax.swing.GroupLayout(editEmployeePanel);
        editEmployeePanel.setLayout(editEmployeePanelLayout);
        editEmployeePanelLayout.setHorizontalGroup(
            editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editEmployeePanelLayout.createSequentialGroup()
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editEmployeePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(existingEmployeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editEmployeePanelLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel19))
                    .addGroup(editEmployeePanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchEmployeeIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBtn)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        editEmployeePanelLayout.setVerticalGroup(
            editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editEmployeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(searchEmployeeIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(existingEmployeePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(editEmployeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(editEmployeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveChangesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesBtnActionPerformed
        
        String[] userInputs = gatherAllUserInput();

        String operationStatus;
        try {
            operationStatus =
                    employeeRequestHandler.handleModification(userInputs);
            JOptionPane.showMessageDialog(null, operationStatus);
        } catch (ParseException ex) {
            Logger.getLogger(ModifyEmployeeForm.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_saveChangesBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed

        String employeeId = searchEmployeeIdTxt.getText();
        
        String operationStatus = employeeRequestHandler.handleRetrieval(employeeId);
        existingEmployeePanel.setVisible(true);
    }//GEN-LAST:event_searchBtnActionPerformed
    
    private String[] gatherAllUserInput(){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] userInput = new String[9];
        userInput[0] = editNameTxt.getText();
        userInput[1] = editLastNameTxt.getText();
        userInput[2] = editTelephoneTxt.getText();
        userInput[3] = editAddressTxt.getText();
        userInput[4] = editIdTxt.getText();
        userInput[5] = editRfcTxt.getText();
        userInput[6] = editSalaryTxt.getText();
        userInput[7] =  dateFormat.
                format( editAdmissionDate.getDate() );
        userInput[8] = editPositionTxt.getText();
        
        return userInput;
    }
    
    public void fillExistingEmployeeForm(Employee employee){
        
        editNameTxt.setText(employee.getName() );
        editLastNameTxt.setText(employee.getLastName() );
        editTelephoneTxt.setText(employee.getTelephone() );
        editAddressTxt.setText(employee.getAddress() );
        editIdTxt.setText(String.valueOf(employee.getId() ) );
        editRfcTxt.setText(employee.getRfc() );
        editSalaryTxt.setText(
                String.valueOf(employee.getBasicSalary() )
                );
        editAdmissionDate.setDate(employee.getAdmissionDate() );
        editPositionTxt.setText(employee.getPosition() );
    }

    private EmployeeRequestHandler employeeRequestHandler;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField editAddressTxt;
    private org.jdesktop.swingx.JXDatePicker editAdmissionDate;
    private javax.swing.JPanel editEmployeePanel;
    private javax.swing.JTextField editIdTxt;
    private javax.swing.JTextField editLastNameTxt;
    private javax.swing.JTextField editNameTxt;
    private javax.swing.JTextField editPositionTxt;
    private javax.swing.JTextField editRfcTxt;
    private javax.swing.JTextField editSalaryTxt;
    private javax.swing.JTextField editTelephoneTxt;
    private javax.swing.JPanel existingEmployeePanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JButton saveChangesBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchEmployeeIdTxt;
    // End of variables declaration//GEN-END:variables
}