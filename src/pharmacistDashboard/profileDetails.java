
package pharmacistDashboard;

import config.Session;
import config.dbconfig;
import static customerDashboard.personalDetails.getHeightFromWidth;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class profileDetails extends javax.swing.JFrame {

   
    public profileDetails() {
        initComponents();
    }

    public boolean duplicateChecker(){
        String n_contact = pcn.getText();
        String n_email = pem.getText();
        String n_username = pus.getText();
        String userId = id.getText();

        dbconfig dbc = new dbconfig();
        try {
            ResultSet resultSet = dbc.getData("SELECT * FROM tbl_users WHERE (u_username = '" + n_username + "' OR u_email = '" + n_email + "' OR u_contact = '" + n_contact + "') AND u_id != '"+userId+"' ");
            if(resultSet.next()) {
                String email = resultSet.getString("u_email");
                String username = resultSet.getString("u_username");
                String contact = resultSet.getString("u_contact");

                if (email.equals(n_email)) {
                    JOptionPane.showMessageDialog(null, "Email is already used!");
                    pem.setText("");
                    return true;
                }

                if (username.equals(n_username)) {
                    JOptionPane.showMessageDialog(null, "Username is already used!");
                    pus.setText("");
                    return true;
                }
                
                if (contact.equals(n_contact)) {
                    JOptionPane.showMessageDialog(null, "Contact no. is already used!");
                    pcn.setText("");
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(""+ex);
        }

        return false;
    }
    
    private boolean isValidContact(String contact){
        return contact.matches("09\\d{9}"); 
    }
    
    public ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
        ImageIcon MyImage = null;
        if (ImagePath != null) {
            MyImage = new ImageIcon(ImagePath);
        } else {
            MyImage = new ImageIcon(pic);
        }
        
        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();
        int originalWidth = MyImage.getIconWidth();
        int originalHeight = MyImage.getIconHeight();
        int newWidth = labelWidth;
        int newHeight = (originalHeight * labelWidth) / originalWidth;

        if (newHeight > labelHeight) {
            newHeight = labelHeight;
            newWidth = (originalWidth * labelHeight) / originalHeight;
        }
        Image img = MyImage.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img);
        return image;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        changepass = new javax.swing.JLabel();
        pic = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        nursenm = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnm = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pem = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        pcn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        gd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pus = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        pps = new javax.swing.JPasswordField();
        viewpass = new javax.swing.JCheckBox();
        update = new javax.swing.JButton();
        up = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Personal Information");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 340, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Manage your personal information, including phone number where you can be contacted.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 430, 20));

        logout.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        logout.setText("Back");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(814, 0, 50, 40));

        changepass.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        changepass.setForeground(new java.awt.Color(0, 0, 102));
        changepass.setText("Change Password");
        changepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changepassMouseClicked(evt);
            }
        });
        jPanel1.add(changepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 110, 20));

        pic.setFont(new java.awt.Font("Tahoma", 0, 5)); // NOI18N
        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic.setText("No Image Found");
        jPanel1.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 60, 50));

        email.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 140, 20));

        id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 80, 20));

        nursenm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nursenm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(nursenm, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 100, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 60, 17));
        jPanel1.add(pnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 290, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Email:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 60, 17));

        pem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pemActionPerformed(evt);
            }
        });
        jPanel1.add(pem, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 290, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Contact no.:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 90, 17));

        pcn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcnActionPerformed(evt);
            }
        });
        jPanel1.add(pcn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 290, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Gender:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 60, -1));

        gd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gdActionPerformed(evt);
            }
        });
        jPanel1.add(gd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 290, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Username:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 80, 20));
        jPanel1.add(pus, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 290, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Password:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 80, 17));

        pps.setEditable(false);
        jPanel1.add(pps, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 290, 30));

        viewpass.setBackground(new java.awt.Color(204, 204, 204));
        viewpass.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        viewpass.setText("Show Password");
        viewpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewpassActionPerformed(evt);
            }
        });
        jPanel1.add(viewpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 90, 20));

        update.setBackground(new java.awt.Color(153, 153, 255));
        update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 483, 100, 20));

        up.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/upload.png"))); // NOI18N
        up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });
        jPanel1.add(up, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 20, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/detailsBG.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 880, 520));

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

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked

        pharmadb phar = new pharmadb();
        phar.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_logoutMouseClicked

    private void changepassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMouseClicked
        changePass cp = new changePass();
        cp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_changepassMouseClicked

    private void pemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pemActionPerformed

    private void pcnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcnActionPerformed

    private void gdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gdActionPerformed

    private void viewpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewpassActionPerformed
        if(viewpass.isSelected()){
            pps.setEchoChar((char)0);
        }else{
            pps.setEchoChar('\u25CF');
        }
    }//GEN-LAST:event_viewpassActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session ses = Session.getInstance();
        dbconfig dbc = new dbconfig();
        
        id.setText(""+ses.getId());
        nursenm.setText(""+ses.getName());
        pnm.setText(""+ses.getName());
        pem.setText(""+ses.getEmail());
        email.setText(""+ses.getEmail());
        pcn.setText(""+ses.getContact()); 
        pus.setText(""+ses.getUsername()); 
        pps.setText(""+ses.getPass()); 
        
        String gender = ses.getSex();
            if (gender != null) {
                gd.setText(gender);
            } else {
                gd.setText("");
            }
        try {
            String sql = "SELECT u_image FROM tbl_users WHERE u_id = " + ses.getId();

            ResultSet rs = dbc.getImagePath(sql);

            if (rs.next()) {
                String imagePath = rs.getString("u_image");
                if (imagePath != null && !imagePath.isEmpty()) {
                    pic.setIcon(ResizeImage(imagePath, null, pic));
                } else {
                    pic.setText("No Image Found");
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_formWindowActivated

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        dbconfig dbc = new dbconfig();
        if(pnm.getText().equals("") || pem.getText().equals("") || pus.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Please Fill Up the Information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if(duplicateChecker()) {
            System.out.println("Duplicate Already Existed");
        } else if (!(pem.getText().matches("^[a-zA-Z0-9_%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);  
            pem.setText("");
        } else {
            if (dbc.updateData("UPDATE tbl_users SET u_name ='"+pnm.getText()+"',u_username ='"+pus.getText()+"',"
                + "u_email='"+pem.getText()+"' WHERE u_id ='"+id.getText()+"'")) {

                Session ses = Session.getInstance();
                ses.setName(pnm.getText());
                ses.setEmail(pem.getText());
                ses.setUsername(pus.getText());

                pnm.setText(ses.getName());
                pem.setText(ses.getEmail());
                pus.setText(ses.getUsername());
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update data!");
            }
        }               
    }//GEN-LAST:event_updateActionPerformed

    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        uploadProfile up = new uploadProfile();
        up.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_upActionPerformed

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
            java.util.logging.Logger.getLogger(profileDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profileDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profileDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profileDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profileDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel changepass;
    private javax.swing.JLabel email;
    private javax.swing.JTextField gd;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel nursenm;
    private javax.swing.JTextField pcn;
    private javax.swing.JTextField pem;
    private javax.swing.JLabel pic;
    private javax.swing.JTextField pnm;
    private javax.swing.JPasswordField pps;
    private javax.swing.JTextField pus;
    private javax.swing.JButton up;
    private javax.swing.JButton update;
    private javax.swing.JCheckBox viewpass;
    // End of variables declaration//GEN-END:variables
}
