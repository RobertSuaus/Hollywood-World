package View;

import Controller.MovieRequestHandler;
import Model.Movie;
import Model.MovieProfile;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 * 
 * Interfaz gráfica del manejador de películas. Permite agregar
 * películas al inventario, crear nuevos perfiles de películas y editarlos
 */
public class RegisterMovieForm extends javax.swing.JFrame {

    public RegisterMovieForm() {
        initComponents(); //Componentes visuales de swing
        this.setVisible(true);
        
        this.movieRequestHandler = new MovieRequestHandler(this );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        inventoryPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addSerialCodeTxt = new javax.swing.JTextField();
        amountToAddTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        movieId = new javax.swing.JTextField();
        addMoviesBtn = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hollywood World - Manage Movies");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Movie serial code:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Amount to add:");

        addSerialCodeTxt.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Movie(s) code(s):");

        movieId.setEditable(false);

        addMoviesBtn.setText("Add movies");
        addMoviesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMoviesBtnActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jLabel17.setText("Add movies");

        javax.swing.GroupLayout inventoryPanelLayout = new javax.swing.GroupLayout(inventoryPanel);
        inventoryPanel.setLayout(inventoryPanelLayout);
        inventoryPanelLayout.setHorizontalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventoryPanelLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addMoviesBtn)
                            .addGroup(inventoryPanelLayout.createSequentialGroup()
                                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(44, 44, 44)
                                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addSerialCodeTxt)
                                    .addComponent(amountToAddTxt)
                                    .addComponent(movieId, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))))
                    .addGroup(inventoryPanelLayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel17)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        inventoryPanelLayout.setVerticalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(addSerialCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(amountToAddTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(movieId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(addMoviesBtn)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(inventoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addComponent(inventoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMoviesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMoviesBtnActionPerformed
        
        String[] userInputs = gatherAllUserInput();
        
        String operationStatus;
        operationStatus = movieRequestHandler.handleAddToInventory(userInputs);
        JOptionPane.showMessageDialog(null, operationStatus);          
    }//GEN-LAST:event_addMoviesBtnActionPerformed
    
    private String[] gatherAllUserInput(){
        
        String[] userInput = new String[3];
        userInput[0] = addSerialCodeTxt.getText();
        userInput[1] = amountToAddTxt.getText();
        userInput[2] = movieId.getText();
        
        return userInput;
    }
    
    private void fillMovieIdField(int id){
        this.movieId.setText(String.valueOf(id ) );
    }
    
    private MovieRequestHandler movieRequestHandler;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMoviesBtn;
    private javax.swing.JTextField addSerialCodeTxt;
    private javax.swing.JTextField amountToAddTxt;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField movieId;
    // End of variables declaration//GEN-END:variables
}
