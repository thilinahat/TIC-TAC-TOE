/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class CreateProfileForm extends javax.swing.JFrame {

    private PlayersDatabaseAccessor databaseAccessor=new PlayersDatabaseAccessor();
    String playerName;
    String password;
    boolean checker=false;
    /**
     * Creates new form CreateProfileForm
     */
    public CreateProfileForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CreateProfile_lbl_name = new javax.swing.JLabel();
        CreateProfile_tfield_name = new javax.swing.JTextField();
        CreateProfile_button_create = new javax.swing.JButton();
        CreateProfile_lbl_password = new javax.swing.JLabel();
        CreateProfile_lbl_password2 = new javax.swing.JLabel();
        CreateProfile_passwordfield_password = new javax.swing.JPasswordField();
        CreateProfile_passwordfield_password2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CreateProfile_lbl_name.setText("Enter Profile Name");

        CreateProfile_tfield_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateProfile_tfield_nameActionPerformed(evt);
            }
        });

        CreateProfile_button_create.setText("Create");
        CreateProfile_button_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateProfile_button_createActionPerformed(evt);
            }
        });

        CreateProfile_lbl_password.setText("Enter Password");

        CreateProfile_lbl_password2.setText("Confirm Your Password");

        CreateProfile_passwordfield_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateProfile_passwordfield_passwordActionPerformed(evt);
            }
        });

        CreateProfile_passwordfield_password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateProfile_passwordfield_password2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CreateProfile_button_create)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreateProfile_lbl_name)
                    .addComponent(CreateProfile_lbl_password)
                    .addComponent(CreateProfile_lbl_password2))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CreateProfile_tfield_name, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(CreateProfile_passwordfield_password)
                    .addComponent(CreateProfile_passwordfield_password2))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateProfile_lbl_name)
                    .addComponent(CreateProfile_tfield_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateProfile_lbl_password)
                    .addComponent(CreateProfile_passwordfield_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateProfile_lbl_password2)
                    .addComponent(CreateProfile_passwordfield_password2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(CreateProfile_button_create)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //create button
    private void CreateProfile_button_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateProfile_button_createActionPerformed
       if(checker){
           JOptionPane message=new JOptionPane();
           message.showMessageDialog(null,"The Profile Created Successfully","",JOptionPane.INFORMATION_MESSAGE);
           this.dispose();
           iifa myGame=new iifa(playerName);
           myGame.setVisible(true);
           myGame.setSize(600, 500);
           myGame.getContentPane().setBackground(Color.BLACK);
           
       }
       else{
           JOptionPane message=new JOptionPane();
            message.showMessageDialog(null,"Some Required Fileds are not Filled","Sorry",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_CreateProfile_button_createActionPerformed

    //name field
    private void CreateProfile_tfield_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateProfile_tfield_nameActionPerformed
        // TODO add your handling code here:
        playerName=evt.getActionCommand();
    }//GEN-LAST:event_CreateProfile_tfield_nameActionPerformed

    private void CreateProfile_passwordfield_password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateProfile_passwordfield_password2ActionPerformed
        // TODO add your handling code here:
        if(!evt.getActionCommand().equals(password)){
            JOptionPane message=new JOptionPane();
            message.showMessageDialog(null,"The password You Entered Doesn't Match ","Sorry",JOptionPane.ERROR_MESSAGE);
        }
        else if(evt.getActionCommand().equals(password)){
            JOptionPane message=new JOptionPane();
            message.showMessageDialog(null,"Your Password Is Confirmed ","",JOptionPane.INFORMATION_MESSAGE);
            checker=true;
        }
        
    }//GEN-LAST:event_CreateProfile_passwordfield_password2ActionPerformed

    private void CreateProfile_passwordfield_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateProfile_passwordfield_passwordActionPerformed
        // TODO add your handling code here:
        password=evt.getActionCommand();
    }//GEN-LAST:event_CreateProfile_passwordfield_passwordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateProfileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateProfileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateProfileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateProfileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateProfileForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateProfile_button_create;
    private javax.swing.JLabel CreateProfile_lbl_name;
    private javax.swing.JLabel CreateProfile_lbl_password;
    private javax.swing.JLabel CreateProfile_lbl_password2;
    private javax.swing.JPasswordField CreateProfile_passwordfield_password;
    private javax.swing.JPasswordField CreateProfile_passwordfield_password2;
    private javax.swing.JTextField CreateProfile_tfield_name;
    // End of variables declaration//GEN-END:variables

   
}
