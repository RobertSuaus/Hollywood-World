/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RentalOrderRequestHandler;
import Controller.ReturnsRequestHandler;
import Model.Lease;
import Model.RentalOrder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Robert
 */
public class ReturnsUI extends javax.swing.JFrame {

    /**
     * Creates new form ReturnsUI
     */
    public ReturnsUI() {
        initComponents();
        this.setVisible(true);
        
        this.returnsHandler = new ReturnsRequestHandler(this);
    }
    
    public void fillRentalOrderField(RentalOrder rentalOrder){
        //Llena los datos
        folioTxt.setText(String.valueOf(rentalOrder.getFolio() ) );
        clientNameTxt.setText(rentalOrder.getClientName() );
        employeeNameTxt.setText(rentalOrder.getEmployeeName() );
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        returnDateTxt.setText(
            dateFormat.format(rentalOrder.getReturnDate() )
        );
        
        currentDateTxt.setText(
            dateFormat.format(new Date() )
        );
        
        //additionalCostTxt.setText(rentalOrder.getAdditionalImport() );
        this.fillLeaseTable(rentalOrder.getLeases());
    }
    
    private void fillLeaseTable(ArrayList leases){
        
        Vector <String> title = new Vector<String>();
        Vector<Vector<Object>> data= new Vector<Vector<Object>>();
        
        title.add("Id película");
        title.add("Título");
        
        for(int i=0; i<leases.size(); i++){
            Vector<Object> row= new Vector<Object>();
            
            row.add(((Lease)leases.get(i)).getMovieId() );
            row.add(((Lease)leases.get(i)).getMovieTitle() );
            
            data.add(row);
        }
        
        DefaultTableModel modelo= new javax.swing.table.DefaultTableModel(data, title);
        leaseTable.setModel(modelo);
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
        rentOrderInformation = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        folioTxt = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        clientNameTxt = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        employeeNameTxt = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        returnDateTxt = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        currentDateTxt = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        additionalCostTxt = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        leaseTable = new javax.swing.JTable();
        memebershipIdTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JToggleButton();
        terminateRentBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Devolución de películas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Id de membresía:");

        rentOrderInformation.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Folio:");

        jLabel4.setText("Detalles de la Renta");

        folioTxt.setText("####");

        jLabel5.setText("Nombre de cliente:");

        clientNameTxt.setText("####");

        jLabel6.setText("Empleado que lo antendió:");

        employeeNameTxt.setText("####");

        jLabel7.setText("Fecha de devolución");

        returnDateTxt.setText("####");

        jLabel8.setText("Fecha actual:");

        currentDateTxt.setText("####");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Importe Adicional:");

        additionalCostTxt.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        additionalCostTxt.setText("####");

        jLabel11.setText("MXN");

        leaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Id", "Título de película"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(leaseTable);

        javax.swing.GroupLayout rentOrderInformationLayout = new javax.swing.GroupLayout(rentOrderInformation);
        rentOrderInformation.setLayout(rentOrderInformationLayout);
        rentOrderInformationLayout.setHorizontalGroup(
            rentOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rentOrderInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rentOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rentOrderInformationLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentDateTxt))
                    .addGroup(rentOrderInformationLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(additionalCostTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11))
                    .addGroup(rentOrderInformationLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(folioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rentOrderInformationLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clientNameTxt))
                    .addGroup(rentOrderInformationLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(employeeNameTxt))
                    .addGroup(rentOrderInformationLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnDateTxt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rentOrderInformationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(216, 216, 216))
        );
        rentOrderInformationLayout.setVerticalGroup(
            rentOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rentOrderInformationLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rentOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rentOrderInformationLayout.createSequentialGroup()
                        .addGroup(rentOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(folioTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rentOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(clientNameTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rentOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(employeeNameTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rentOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(returnDateTxt))
                        .addGap(18, 18, 18)
                        .addGroup(rentOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(currentDateTxt))
                        .addGap(18, 18, 18)
                        .addGroup(rentOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(additionalCostTxt)
                            .addComponent(jLabel11))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        searchBtn.setText("Buscar");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        terminateRentBtn.setText("Terminar renta");
        terminateRentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminateRentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(memebershipIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rentOrderInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(terminateRentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memebershipIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addGap(18, 18, 18)
                .addComponent(rentOrderInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(terminateRentBtn)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        
        String operationStatus;
        try {
            operationStatus = returnsHandler.handleRetrieval(memebershipIdTxt.getText() );
        } catch (ParseException ex) {
            operationStatus = "Error de parseo de fechas";
        }
        JOptionPane.showMessageDialog(null,operationStatus);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void terminateRentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminateRentBtnActionPerformed
        // TODO add your handling code here:
        
        String operationStatus = returnsHandler.handleStatusModification();
        JOptionPane.showMessageDialog(null, operationStatus);
    }//GEN-LAST:event_terminateRentBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private ReturnsRequestHandler returnsHandler;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel additionalCostTxt;
    private javax.swing.JLabel clientNameTxt;
    private javax.swing.JLabel currentDateTxt;
    private javax.swing.JLabel employeeNameTxt;
    private javax.swing.JLabel folioTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable leaseTable;
    private javax.swing.JTextField memebershipIdTxt;
    private javax.swing.JPanel rentOrderInformation;
    private javax.swing.JLabel returnDateTxt;
    private javax.swing.JToggleButton searchBtn;
    private javax.swing.JButton terminateRentBtn;
    // End of variables declaration//GEN-END:variables
}
