
package customerDashboard;

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

        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        change = new javax.swing.JLabel();
        cfp = new javax.swing.JPasswordField();
        crp = new javax.swing.JPasswordField();
        nwp = new javax.swing.JPasswordField();
        viewcfp = new javax.swing.JCheckBox();
        viewcrp = new javax.swing.JCheckBox();
        viewnwp = new javax.swing.JCheckBox();
        back = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel12.setText("Current password");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(230, 160, 140, 17);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel9.setText("New password");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(230, 220, 120, 30);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel14.setText("Confirm password");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(230, 300, 120, 15);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Change Password");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(230, 40, 260, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("To continue, please enter your current and new password.");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(230, 120, 350, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("To protect the security of your account, we recommend signing out after changing your password.");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(230, 70, 460, 20);

        change.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        change.setForeground(new java.awt.Color(255, 255, 255));
        change.setText("Change Password");
        change.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeMouseClicked(evt);
            }
        });
        jPanel2.add(change);
        change.setBounds(360, 384, 120, 20);
        jPanel2.add(cfp);
        cfp.setBounds(230, 320, 360, 30);
        jPanel2.add(crp);
        crp.setBounds(230, 180, 360, 30);
        jPanel2.add(nwp);
        nwp.setBounds(230, 250, 360, 30);

        viewcfp.setBackground(new java.awt.Color(204, 204, 204));
        viewcfp.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        viewcfp.setText("Show ");
        viewcfp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewcfpActionPerformed(evt);
            }
        });
        jPanel2.add(viewcfp);
        viewcfp.setBounds(590, 320, 50, 30);

        viewcrp.setBackground(new java.awt.Color(204, 204, 204));
        viewcrp.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        viewcrp.setText("Show ");
        viewcrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewcrpActionPerformed(evt);
            }
        });
        jPanel2.add(viewcrp);
        viewcrp.setBounds(590, 180, 50, 30);

        viewnwp.setBackground(new java.awt.Color(204, 204, 204));
        viewnwp.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        viewnwp.setText("Show ");
        viewnwp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewnwpActionPerformed(evt);
            }
        });
        jPanel2.add(viewnwp);
        viewnwp.setBounds(590, 250, 50, 30);

        back.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel2.add(back);
        back.setBounds(800, 0, 50, 50);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/changePASS.png"))); // NOI18N
        jPanel2.add(bg);
        bg.setBounds(-40, 0, 900, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void viewcfpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewcfpActionPerformed
        if(viewcfp.isSelected()){
            cfp.setEchoChar((char)0);
        }else{
            cfp.setEchoChar('\u25CF');
        }
    }//GEN-LAST:event_viewcfpActionPerformed

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

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked

        personalDetails prd = new personalDetails();
        prd.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_backMouseClicked

   
    public static void main(String args[]) {
        
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField nwp;
    private javax.swing.JCheckBox viewcfp;
    private javax.swing.JCheckBox viewcrp;
    private javax.swing.JCheckBox viewnwp;
    // End of variables declaration//GEN-END:variables
}
