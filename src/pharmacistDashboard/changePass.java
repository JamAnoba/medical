
package pharmacistDashboard;

import config.Session;
import config.dbconfig;
import config.passHash;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import medicalapp.Loginfrm;

public class changePass extends javax.swing.JFrame {

    
    public changePass() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        crp = new javax.swing.JPasswordField();
        viewcrp = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        nwp = new javax.swing.JPasswordField();
        viewnwp = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        cfp = new javax.swing.JPasswordField();
        viewcfp = new javax.swing.JCheckBox();
        change = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Change Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 260, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("To protect the security of your account, we recommend signing out after changing your password.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 460, 20));

        back.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 50, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("To continue, please enter your current and new password.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 350, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel12.setText("Current password");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 140, 17));
        jPanel1.add(crp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 360, 30));

        viewcrp.setBackground(new java.awt.Color(204, 204, 204));
        viewcrp.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        viewcrp.setText("Show ");
        viewcrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewcrpActionPerformed(evt);
            }
        });
        jPanel1.add(viewcrp, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 50, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel9.setText("New password");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 120, 30));
        jPanel1.add(nwp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 360, 30));

        viewnwp.setBackground(new java.awt.Color(204, 204, 204));
        viewnwp.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        viewnwp.setText("Show ");
        viewnwp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewnwpActionPerformed(evt);
            }
        });
        jPanel1.add(viewnwp, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 50, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel14.setText("Confirm password");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 120, -1));
        jPanel1.add(cfp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 360, 30));

        viewcfp.setBackground(new java.awt.Color(204, 204, 204));
        viewcfp.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        viewcfp.setText("Show ");
        viewcfp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewcfpActionPerformed(evt);
            }
        });
        jPanel1.add(viewcfp, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 50, 30));

        change.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        change.setForeground(new java.awt.Color(255, 255, 255));
        change.setText("Change Password");
        change.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeMouseClicked(evt);
            }
        });
        jPanel1.add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 384, 120, 20));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/changePASS.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 890, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked

        profileDetails prd = new profileDetails();
        prd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void viewcrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewcrpActionPerformed
        if(viewcrp.isSelected()){
            crp.setEchoChar((char)0);
        }else{
            crp.setEchoChar('\u25CF');
        }
    }//GEN-LAST:event_viewcrpActionPerformed

    private void viewnwpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewnwpActionPerformed
        if(viewnwp.isSelected()){
            nwp.setEchoChar((char)0);
        }else{
            nwp.setEchoChar('\u25CF');
        }
    }//GEN-LAST:event_viewnwpActionPerformed

    private void viewcfpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewcfpActionPerformed
        if(viewcfp.isSelected()){
            cfp.setEchoChar((char)0);
        }else{
            cfp.setEchoChar('\u25CF');
        }
    }//GEN-LAST:event_viewcfpActionPerformed

    private void changeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeMouseClicked
        try {
            dbconfig db = new dbconfig();
            Session ses = Session.getInstance();

            String query = "SELECT * FROM tbl_med WHERE u_id = '"+ses.getId()+"'";
            ResultSet rs = db.getData(query);
            if(rs.next()) {
                String oldpass = rs.getString("u_pass");
                String oldhash = passHash.hashPassword(crp.getText());

                // Compare the entered old password directly with the hashed password from the database
                if(oldpass.equals(oldhash)) {
                    crp.setForeground(Color.GREEN);

                    String npass = nwp.getText();
                    String cpass = cfp.getText();
                    String hashedNPass = passHash.hashPassword(npass);
                    // Checks if the new password and confirm password match
                    if(npass.equals(cpass) && npass.length() >= 8) {
                        // Hash the new password
                        nwp.setForeground(Color.GREEN);
                        cfp.setForeground(Color.GREEN);

                        // Updates the password in the database
                        db.updateData("UPDATE tbl_med SET u_pass = '"+hashedNPass+"' WHERE u_id = '"+ses.getId()+"'");

                        JOptionPane.showMessageDialog(null, "Password Updated Successfully!");
                        Loginfrm log = new Loginfrm();
                        log.setVisible(true);
                        this.dispose();
                    } else {
                        // Displays error message if conditions are not met
                        JOptionPane.showMessageDialog(null, "New Password and Confirm Password do not match or \nPassword should have 8 characters and above!");
                        nwp.setForeground(Color.RED);
                        cfp.setForeground(Color.RED);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Old Password is incorrect!");
                    crp.setForeground(Color.RED);
                }
            }
        } catch(SQLException | NoSuchAlgorithmException ex) {
            System.out.println(""+ex);
        }
    }//GEN-LAST:event_changeMouseClicked

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
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel bg;
    private javax.swing.JPasswordField cfp;
    private javax.swing.JLabel change;
    private javax.swing.JPasswordField crp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField nwp;
    private javax.swing.JCheckBox viewcfp;
    private javax.swing.JCheckBox viewcrp;
    private javax.swing.JCheckBox viewnwp;
    // End of variables declaration//GEN-END:variables
}
