/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Accountant;
import Model.PayrollBreakdown;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Robert
 */
public class GeneratePayrollUI extends javax.swing.JFrame {

    /**
     * Creates new form GeneratePayrollUI
     */
    public GeneratePayrollUI() {
        initComponents();
        setVisible(true);
        
        accountant = new Accountant(this);
    }
    
    public void fillPayrollBreakdownTable(PayrollBreakdown payrollBreakdown){
        
        Vector <String> title = new Vector<String>();
        Vector<Vector<Object>> data= new Vector<Vector<Object>>();
        
        title.add("Id Desglose");
        title.add("Clave Empleado");
        title.add("ISR");
        title.add("Seguro");
        title.add("Aguinaldo");
        title.add("Vacaciones");
        title.add("Prima dominical");
        title.add("Dias trabajados");
        title.add("Total");
        title.add("Salario");
        title.add("Fecha");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        Vector<Object> row= new Vector<Object>();
            
        row.add((String.valueOf(payrollBreakdown.getDesgloseId() ) ) );
        row.add((String.valueOf(payrollBreakdown.getEmployeeId() ) ) );
        row.add((String.valueOf(payrollBreakdown.getRetention().getISR() ) ) );
        row.add((String.valueOf(payrollBreakdown.getRetention().getTaxPerIMSS() ) ) );
        row.add((String.valueOf(payrollBreakdown.getBonus().getChristmasBox() ) ) );
        row.add((String.valueOf(payrollBreakdown.getBonus().getHolidayBonus() ) ) );
        row.add((String.valueOf(payrollBreakdown.getBonus().getDominical() ) ) );
        row.add((String.valueOf(payrollBreakdown.getWorkedDays() ) ) );
        row.add((String.valueOf(payrollBreakdown.getTotalPayment() ) ) );
        row.add((String.valueOf(payrollBreakdown.getIntegratedWage() ) ) );
        row.add((dateFormat.format(payrollBreakdown.getBreakdownDate()  ) ) );
            
        data.add(row);
        
        DefaultTableModel modelo= new javax.swing.table.DefaultTableModel(data, title);
        payrollBreakdownTable.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        employeeIdField = new javax.swing.JTextField();
        workedDaysField = new javax.swing.JTextField();
        generateBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        payrollBreakdownTable = new javax.swing.JTable();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Generar desglose de nómina");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Clave de empleado:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Días trabajados:");

        generateBtn.setText("Generar");
        generateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBtnActionPerformed(evt);
            }
        });

        payrollBreakdownTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Clave Empleado", "ISR", "Seguro", "Aguinaldo", "Vacaciones", "Prima dominical", "Dias trabajados", "Total", "Salario", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(payrollBreakdownTable);

        saveBtn.setText("Guardar");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 373, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employeeIdField)
                            .addComponent(workedDaysField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(394, 394, 394))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(426, 426, 426)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(454, 454, 454)
                        .addComponent(generateBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(employeeIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(workedDaysField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(generateBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(saveBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBtnActionPerformed
        // TODO add your handling code here:
        String[] userInputs = new String[2];
        userInputs[0] = employeeIdField.getText();
        userInputs[1] = workedDaysField.getText();
        
        String operationStatus;
        try {
            operationStatus = accountant.createPayrollBreakdown(userInputs);
            JOptionPane.showMessageDialog(null, operationStatus);
        } catch (ParseException ex) {
            Logger.getLogger(GeneratePayrollUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_generateBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        
        String operationStatus = accountant.requestPayrollArchiving();
        JOptionPane.showMessageDialog(null, operationStatus);
    }//GEN-LAST:event_saveBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private Accountant accountant;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField employeeIdField;
    private javax.swing.JButton generateBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable payrollBreakdownTable;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField workedDaysField;
    // End of variables declaration//GEN-END:variables
}
