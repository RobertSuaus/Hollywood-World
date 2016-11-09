/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Controller.MainMenuRequestHandler;
import Controller.SessionRequestHandler;
import Model.User;
import javax.swing.JOptionPane;

/**
 *
 * @author che_i
 */
public class MainMenuUI extends javax.swing.JFrame {

    /** Creates new form MainMenuIU */
    public MainMenuUI(User user) {
        initComponents(); //Componentes visuales de Swing
        this.setVisible(true);
        
        this.sessionRequestHandler = new SessionRequestHandler();
        this.mainMenuRequestHandler = new MainMenuRequestHandler(user, this);
    }
    
    public void displayPermissionError(){
        JOptionPane.showMessageDialog(null, "No tienes permisos para acceder a la función");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        RentButton = new javax.swing.JButton();
        RestorationButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        ClientButton = new javax.swing.JMenu();
        clientButton = new javax.swing.JMenuItem();
        filmsButton = new javax.swing.JMenuItem();
        employeeButton = new javax.swing.JMenuItem();
        usersSubMenu = new javax.swing.JMenu();
        userRegistrationBtn = new javax.swing.JMenuItem();
        userModificationBtn = new javax.swing.JMenuItem();
        ReportsMenu = new javax.swing.JMenu();
        payrollMenu = new javax.swing.JMenu();
        Session = new javax.swing.JMenu();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hollywood World - Main Menu");

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 3, 48)); // NOI18N
        jLabel3.setText("Hollywood World!");

        RentButton.setFont(new java.awt.Font("Berlin Sans FB", 3, 18)); // NOI18N
        RentButton.setText("Rent");
        RentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RentButtonActionPerformed(evt);
            }
        });

        RestorationButton.setFont(new java.awt.Font("Berlin Sans FB", 3, 24)); // NOI18N
        RestorationButton.setText("Restoration");
        RestorationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestorationButtonActionPerformed(evt);
            }
        });

        ClientButton.setText("Manage");

        clientButton.setText("Clients");
        clientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientButtonActionPerformed(evt);
            }
        });
        ClientButton.add(clientButton);

        filmsButton.setText("Films");
        filmsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmsButtonActionPerformed(evt);
            }
        });
        ClientButton.add(filmsButton);

        employeeButton.setText("Employees");
        employeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeButtonActionPerformed(evt);
            }
        });
        ClientButton.add(employeeButton);

        usersSubMenu.setText("Users");

        userRegistrationBtn.setText("Register user");
        userRegistrationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userRegistrationBtnActionPerformed(evt);
            }
        });
        usersSubMenu.add(userRegistrationBtn);

        userModificationBtn.setText("Edit user");
        userModificationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userModificationBtnActionPerformed(evt);
            }
        });
        usersSubMenu.add(userModificationBtn);

        ClientButton.add(usersSubMenu);

        jMenuBar1.add(ClientButton);

        ReportsMenu.setText("Reports");
        jMenuBar1.add(ReportsMenu);

        payrollMenu.setText("Payroll");
        jMenuBar1.add(payrollMenu);

        Session.setText("Terminate Session");
        Session.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SessionMouseClicked(evt);
            }
        });
        jMenuBar1.add(Session);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(RestorationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel3)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RestorationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addGap(0, 55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RentButtonActionPerformed
        
        mainMenuRequestHandler.processNewRentWindowRequest();
    }//GEN-LAST:event_RentButtonActionPerformed

    private void RestorationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestorationButtonActionPerformed
        
        mainMenuRequestHandler.processReturnsWindowRequest();
    }//GEN-LAST:event_RestorationButtonActionPerformed

    private void clientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientButtonActionPerformed
        
        mainMenuRequestHandler.processClientRegistrationWindowRequest();
    }//GEN-LAST:event_clientButtonActionPerformed

    private void filmsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmsButtonActionPerformed
        
        mainMenuRequestHandler.processMovieInventoryWindowRequest();
    }//GEN-LAST:event_filmsButtonActionPerformed

    private void employeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeButtonActionPerformed
        
        mainMenuRequestHandler.processEmployeeRegistrationWindowRequest();
    }//GEN-LAST:event_employeeButtonActionPerformed

    private void SessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SessionMouseClicked
        
        sessionRequestHandler.processLogoutRequest();
    }//GEN-LAST:event_SessionMouseClicked

    private void userRegistrationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userRegistrationBtnActionPerformed
        
        mainMenuRequestHandler.processUserRegistrationWindowRequest();
    }//GEN-LAST:event_userRegistrationBtnActionPerformed

    private void userModificationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userModificationBtnActionPerformed
        
        mainMenuRequestHandler.processUserModificationWindowRequest();
    }//GEN-LAST:event_userModificationBtnActionPerformed

    
    private MainMenuRequestHandler mainMenuRequestHandler;
    private SessionRequestHandler sessionRequestHandler;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ClientButton;
    private javax.swing.JButton RentButton;
    private javax.swing.JMenu ReportsMenu;
    private javax.swing.JButton RestorationButton;
    private javax.swing.JMenu Session;
    private javax.swing.JMenuItem clientButton;
    private javax.swing.JMenuItem employeeButton;
    private javax.swing.JMenuItem filmsButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenu payrollMenu;
    private javax.swing.JMenuItem userModificationBtn;
    private javax.swing.JMenuItem userRegistrationBtn;
    private javax.swing.JMenu usersSubMenu;
    // End of variables declaration//GEN-END:variables
    
}
