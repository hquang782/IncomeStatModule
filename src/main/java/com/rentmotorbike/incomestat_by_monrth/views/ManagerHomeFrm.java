/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.rentmotorbike.incomestat_by_monrth.views;

import com.rentmotorbike.incomestat_by_monrth.models.User;

import javax.swing.*;

/**
 *
 * @author Hạ Quang
 */
public class ManagerHomeFrm extends javax.swing.JFrame {

    private final User u;

    /**
     * Creates new form ManagerHomeFrm
     * @param user
     */
    public ManagerHomeFrm(User user) {
        super("Manager Home");
        this.u = user;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(400,170);

        initComponents();
        lblHelloUser.setText("hello "+ u.getUsername());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStat = new javax.swing.JButton();
        lblMHome = new javax.swing.JLabel();
        lblHelloUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager Home");

        btnStat.setBackground(new java.awt.Color(51, 204, 255));
        btnStat.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnStat.setText("View Statistic");
        btnStat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatActionPerformed(evt);
            }
        });

        lblMHome.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblMHome.setText("Manager Home");

        lblHelloUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblHelloUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelloUser.setText("Hello");
        lblHelloUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblHelloUser.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(lblMHome))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(btnStat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(lblHelloUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(lblMHome)
                .addGap(76, 76, 76)
                .addComponent(lblHelloUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(btnStat)
                .addGap(95, 95, 95))
        );

        lblHelloUser.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatActionPerformed
        // TODO add your handling code here:
        (new SelectStatFrm(u)).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnStatActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStat;
    private javax.swing.JLabel lblHelloUser;
    private javax.swing.JLabel lblMHome;
    // End of variables declaration//GEN-END:variables
}
