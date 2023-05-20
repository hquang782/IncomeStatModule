/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.rentmotorbike.incomestat_by_monrth.views;
import com.rentmotorbike.incomestat_by_monrth.models.User;
import javax.swing.*;

import com.rentmotorbike.incomestat_by_monrth.dao.UserDAO;
/**
 *
 * @author Hạ Quang
 */
public class LoginFrm extends JFrame {

    /**
     * Creates new form LoginFrm
     */
    public LoginFrm() {
        super("Login");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(400, 170);
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

        Lglbl = new javax.swing.JLabel();
        lblUN = new javax.swing.JLabel();
        lblPW = new javax.swing.JLabel();
        txtUN = new javax.swing.JTextField();
        txtPW = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        Lglbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Lglbl.setText("Login");

        lblUN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUN.setText("Username");

        lblPW.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPW.setText("Password");

        txtUN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUNActionPerformed(evt);
            }
        });

        txtPW.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnLogin.setBackground(new java.awt.Color(0, 204, 255));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPW, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUN, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPW, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUN, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(Lglbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(Lglbl)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUN))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPW))
                .addGap(66, 66, 66)
                .addComponent(btnLogin)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUNActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        User user = new User();
        user.setUsername(txtUN.getText());
        user.setPassword(txtPW.getText());

        UserDAO userdao= new UserDAO();
        if(userdao.checkLogin(user)){
            switch (user.getRole()) {
                case "manager":
                    (new ManagerHomeFrm(user)).setVisible(true);
                    this.dispose();
                    break;
                case "admin":
                    (new ManagerHomeFrm(user)).setVisible(true);
                    this.dispose();
                    break;
                case "staff":
                    (new ManagerHomeFrm(user)).setVisible(true);
                    this.dispose();
                    break;
                default:
                    break;
            }

        }else {
            JOptionPane.showMessageDialog(this, "Incorrect username and/or password!");
        }
        
        
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       LoginFrm myFrame = new LoginFrm();
       myFrame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lglbl;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblPW;
    private javax.swing.JLabel lblUN;
    private javax.swing.JPasswordField txtPW;
    private javax.swing.JTextField txtUN;
    // End of variables declaration//GEN-END:variables
}