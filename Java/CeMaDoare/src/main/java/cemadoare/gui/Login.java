/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cemadoare.gui;

import cemadoare.service.LoginResponsible;
import cemadoare.service.impl.LoginResponsibleImpl;
import cemadoare.util.Constants;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 *
 * @author Filip
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    public Login() {
        initComponents();
        resizeIcons();
    }

    private void resizeIcons() {
        Image doctorLogo = Toolkit.getDefaultToolkit().getImage(getClass().getResource(Constants.PATHS.DOCTOR_LOGO.getPath()));
        ImageIcon icon = new ImageIcon(doctorLogo.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
        logo.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rightPanel = new javax.swing.JPanel();
        userPassword = new javax.swing.JPasswordField();
        userName = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        login = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        goToGitHub = new javax.swing.JLabel();
        gitHubLogo = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CeMaDoare");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rightPanel.setBackground(new java.awt.Color(32, 33, 35));

        userPassword.setBackground(new java.awt.Color(32, 33, 35));
        userPassword.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        userPassword.setForeground(new java.awt.Color(255, 255, 255));
        userPassword.setText("jPasswordField1");
        userPassword.setBorder(null);
        userPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userPasswordFocusGained(evt);
            }
        });

        userName.setBackground(new java.awt.Color(32, 33, 35));
        userName.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setBorder(null);
        userName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userNameFocusGained(evt);
            }
        });
        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(187, 22, 237));
        name.setText("Name");

        password.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        password.setForeground(new java.awt.Color(51, 51, 51));
        password.setText("Password");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        login.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBox.foreground"));
        login.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        login.setForeground(new java.awt.Color(187, 22, 237));
        login.setText("Login");
        login.setBorder(null);
        login.setFocusPainted(false);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userPassword)
                    .addComponent(jSeparator1)
                    .addComponent(password)
                    .addComponent(name)
                    .addComponent(userName)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        getContentPane().add(rightPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 240, 450));

        footer.setBackground(new java.awt.Color(51, 51, 51));

        goToGitHub.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        goToGitHub.setForeground(new java.awt.Color(187, 22, 237));
        goToGitHub.setText("Search me on GitHub");

        gitHubLogo.setBackground(new java.awt.Color(0, 0, 0));
        gitHubLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/GitHub-Mark-32px.png"))); // NOI18N

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(goToGitHub)
                .addGap(18, 18, 18)
                .addComponent(gitHubLogo)
                .addContainerGap(403, Short.MAX_VALUE))
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(goToGitHub)
                    .addComponent(gitHubLogo))
                .addContainerGap())
        );

        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 600, 50));

        leftPanel.setBackground(new java.awt.Color(153, 255, 153));

        logo.setBackground(new java.awt.Color(102, 102, 102));
        logo.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        getContentPane().add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void userNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFocusGained
        name.setForeground(Constants.COLORS.FOCUSED.getColor());
        password.setForeground(Constants.COLORS.UNFOCUSED.getColor());
        System.out.println("Something happend in userNameFocusGained");
    }//GEN-LAST:event_userNameFocusGained

    private void userPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userPasswordFocusGained
        password.setForeground(Constants.COLORS.FOCUSED.getColor());
        name.setForeground(Constants.COLORS.UNFOCUSED.getColor());
        System.out.println("Something happend in userPasswordFocusGained");
    }//GEN-LAST:event_userPasswordFocusGained

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        String usr = userName.getText();
        String pswd = userPassword.getText();

        if (isEmpty(usr) && isEmpty(pswd)) {
            JOptionPane.showMessageDialog(this, "Username and Password are empty");
        } else if (isEmpty(usr)) {
            JOptionPane.showMessageDialog(this, "Username is empty");
        } else if (isEmpty(pswd)) {
            JOptionPane.showMessageDialog(this, "Password is empty");
        } else if (loginResponsible.tryLoginAdmin(usr, pswd)) {
            LOGGER.info("Admin has been successfully logged");
            Admin admin = new Admin();
            setVisible(false);
            admin.setVisible(true);
        } else if (loginResponsible.tryLoginUser(usr, pswd)) {
            LOGGER.info("User has been successfully logged");
            User user = new User();
            setVisible(false);
            user.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "This username does not exist in system/Wrong username password combination");
        }

    }//GEN-LAST:event_loginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    private LoginResponsible loginResponsible = new LoginResponsibleImpl();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel footer;
    private javax.swing.JLabel gitHubLogo;
    private javax.swing.JLabel goToGitHub;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton login;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel name;
    private javax.swing.JLabel password;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JTextField userName;
    private javax.swing.JPasswordField userPassword;
    // End of variables declaration//GEN-END:variables

    private final static Logger LOGGER = Logger.getLogger(Login.class);
}
