
package customerDashboard;

import config.Session;
import config.dbconfig;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class personalDetails extends javax.swing.JFrame {

    
    public personalDetails() {
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
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public static String path;
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
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
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        up = new javax.swing.JButton();
        docnm = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        pem = new javax.swing.JTextField();
        pcn = new javax.swing.JTextField();
        pus = new javax.swing.JTextField();
        pps = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        changepass = new javax.swing.JLabel();
        viewpass = new javax.swing.JCheckBox();
        logout = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        gd = new javax.swing.JTextField();
        pnm = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        pic = new javax.swing.JLabel();
        profilebg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Personal Information");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(210, 30, 340, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Manage your personal information, including phone number where you can be contacted.");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(210, 60, 430, 20);

        up.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/upload.png"))); // NOI18N
        up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });
        jPanel1.add(up);
        up.setBounds(110, 150, 20, 20);

        docnm.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        docnm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(docnm);
        docnm.setBounds(40, 170, 130, 30);

        email.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(email);
        email.setBounds(30, 200, 140, 20);

        id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(id);
        id.setBounds(60, 230, 80, 20);

        pem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pemActionPerformed(evt);
            }
        });
        jPanel1.add(pem);
        pem.setBounds(330, 180, 290, 30);

        pcn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcnActionPerformed(evt);
            }
        });
        jPanel1.add(pcn);
        pcn.setBounds(330, 230, 290, 30);
        jPanel1.add(pus);
        pus.setBounds(330, 330, 290, 30);

        pps.setEditable(false);
        jPanel1.add(pps);
        pps.setBounds(330, 380, 290, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(260, 140, 60, 17);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Email:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(260, 190, 60, 17);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Contact no.:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(260, 240, 90, 17);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Username:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(260, 340, 80, 20);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Password:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(260, 390, 80, 17);

        changepass.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        changepass.setForeground(new java.awt.Color(0, 0, 102));
        changepass.setText("Change Password");
        changepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changepassMouseClicked(evt);
            }
        });
        jPanel1.add(changepass);
        changepass.setBounds(50, 440, 120, 20);

        viewpass.setBackground(new java.awt.Color(204, 204, 204));
        viewpass.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        viewpass.setText("Show Password");
        viewpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewpassActionPerformed(evt);
            }
        });
        jPanel1.add(viewpass);
        viewpass.setBounds(530, 420, 90, 20);

        logout.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Back");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel1.add(logout);
        logout.setBounds(800, 10, 60, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Gender:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(260, 290, 60, 15);

        gd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gdActionPerformed(evt);
            }
        });
        jPanel1.add(gd);
        gd.setBounds(330, 280, 290, 30);
        jPanel1.add(pnm);
        pnm.setBounds(330, 130, 290, 30);

        update.setBackground(new java.awt.Color(153, 153, 255));
        update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update);
        update.setBounds(390, 480, 120, 23);

        pic.setFont(new java.awt.Font("Tahoma", 0, 5)); // NOI18N
        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic.setText("No Image Found");
        jPanel1.add(pic);
        pic.setBounds(70, 110, 50, 50);

        profilebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/detailsBG.png"))); // NOI18N
        jPanel1.add(profilebg);
        profilebg.setBounds(-10, 0, 880, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session ses = Session.getInstance();
        dbconfig dbc = new dbconfig();
        
        id.setText(""+ses.getId());
        docnm.setText(""+ses.getName());
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
        }catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_formWindowActivated

    private void pemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pemActionPerformed

    private void pcnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcnActionPerformed

    private void viewpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewpassActionPerformed
        if(viewpass.isSelected()){
            pps.setEchoChar((char)0);
        }else{
            pps.setEchoChar('\u25CF');
        }

    }//GEN-LAST:event_viewpassActionPerformed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked

        customerdb doc = new customerdb();
        doc.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_logoutMouseClicked

    private void changepassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMouseClicked
        changePass cng = new changePass();
        cng.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_changepassMouseClicked

    private void gdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gdActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        dbconfig dbc = new dbconfig();
        if(pnm.getText().equals("") || pem.getText().equals("") || pus.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Please Fill Up the Information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if(duplicateChecker()) {
            System.out.println("Duplicate Already Exist!");
        } else if (!(pem.getText().matches("^[a-zA-Z0-9_%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
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
        uploadpp pp = new uploadpp();
        pp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_upActionPerformed

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
            java.util.logging.Logger.getLogger(personalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(personalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(personalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(personalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new personalDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel changepass;
    private javax.swing.JLabel docnm;
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
    private javax.swing.JTextField pcn;
    private javax.swing.JTextField pem;
    private javax.swing.JLabel pic;
    private javax.swing.JTextField pnm;
    private javax.swing.JPasswordField pps;
    private javax.swing.JLabel profilebg;
    private javax.swing.JTextField pus;
    private javax.swing.JButton up;
    private javax.swing.JButton update;
    private javax.swing.JCheckBox viewpass;
    // End of variables declaration//GEN-END:variables
}
