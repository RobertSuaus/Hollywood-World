/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AccountingAnalyst;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Robert
 */
public class PatreonPayrollUI extends javax.swing.JFrame {

    /**
     * Creates new form PatreonPayrollUI
     */
    public PatreonPayrollUI() {
        initComponents();
        setVisible(true);
        
        accountingAnalyst = new AccountingAnalyst(this);
    }
    
    public void fillRegistryTable(String[] registries){
        
        Vector <String> title = new Vector<String>();
        Vector<Vector<Object>> data= new Vector<Vector<Object>>();
        
        title.add("ISR");
        title.add("Seguro");
        title.add("Aguinaldo");
        title.add("Vacaciones");
        title.add("Dias trabajados");
        title.add("Prima vacacional");
        title.add("Total");
        title.add("Salario");
        
        Vector<Object> row= new Vector<Object>();
            
        row.add(((String)registries[0] ) );
        row.add(((String)registries[1] ) );
            
        data.add(row);
        
        DefaultTableModel modelo= new javax.swing.table.DefaultTableModel(data, title);
        payrollSummaryTable.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        startDate = new org.jdesktop.swingx.JXDatePicker();
        endDate = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        generateBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        payrollSummaryTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Sumario de pago de nómina");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Fecha de inicio");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Fecha final");

        generateBtn.setText("Generar sumario");
        generateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBtnActionPerformed(evt);
            }
        });

        payrollSummaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISR", "Seguro", "Aguinaldo", "Vacaciones", "Dias trabajados", "Prima vacacional", "Total", "Salario"
            }
        ));
        jScrollPane1.setViewportView(payrollSummaryTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(334, 334, 334)
                                .addComponent(generateBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(274, 274, 274)
                                .addComponent(jLabel4)))
                        .addGap(0, 216, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(generateBtn)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBtnActionPerformed
        // TODO add your handling code here:
        Date startDateInput = startDate.getDate();
        Date endDateInput = endDate.getDate();
        accountingAnalyst.requestPayrollSummary(startDateInput, endDateInput);
    }//GEN-LAST:event_generateBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private AccountingAnalyst accountingAnalyst;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker endDate;
    private javax.swing.JButton generateBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable payrollSummaryTable;
    private org.jdesktop.swingx.JXDatePicker startDate;
    // End of variables declaration//GEN-END:variables
}