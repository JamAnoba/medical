
package pharmacistDashboard;

import config.Session;
import config.dbconfig;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class uploadProfile extends javax.swing.JFrame {

    public uploadProfile() {
        initComponents();
    }

    public String destination = "";
    File selectedFile;
    public String oldpath;
    public static String path;
    dbconfig dbc = new dbconfig();
    
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
    
    private void displayUploadedPicture() {
        Session ses = Session.getInstance();
        
        try{
            String sql = "SELECT u_image FROM tbl_users WHERE u_id = " + ses.getId();
            
            ResultSet rs = dbc.getData(sql);
            
            if(rs.next()) {
                String imagePath = rs.getString("u_image");
                if(imagePath != null && !imagePath.isEmpty()) {
                    pic.setIcon(ResizeImage(imagePath, null, pic));
                }else {
                    pic.setText("No Image Found");
                }
            }
        }catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        pic = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        browse = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Upload Profile Picture");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 370, -1));

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-24.png"))); // NOI18N
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 30, 30));

        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic.setText("No Image Found");
        jPanel1.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 170, 150));

        logout.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Back");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 60, 30));

        remove.setBackground(new java.awt.Color(0, 51, 153));
        remove.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 110, 40));

        save.setBackground(new java.awt.Color(0, 51, 153));
        save.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Save");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 110, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setText("Upload your photo here.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        browse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        browse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-upload-94.png"))); // NOI18N
        browse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseMouseClicked(evt);
            }
        });
        jPanel1.add(browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 110, 120));

        name.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("NAME");
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 170, 20));

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 430, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        Session ses = Session.getInstance();
        dbconfig dbc = new dbconfig();

        String sql = "SELECT u_image FROM tbl_users WHERE u_id = " + ses.getId();

        try {
            ResultSet rs = dbc.getData(sql);
            if (rs.next()) {
                String imagePath = rs.getString("u_image");
                File file = new File(imagePath);
                if (file.exists()) {
                    if (file.delete()) {
                        System.out.println("File deleted successfully");
                        pic.setIcon(null);
                    } else {
                        System.out.println("Failed to delete the file");
                    }
                } else {
                    System.out.println("File not found");
                }

                String updateSql = "UPDATE tbl_users SET u_image = '' WHERE u_id = " + ses.getId();
                if (dbc.updateData(updateSql)) {
                    JOptionPane.showMessageDialog(null, "Photo deleted successfully!");
                    displayUploadedPicture();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete photo from database!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No photo found for the current user!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked

        profileDetails pfd = new profileDetails();
        pfd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        save.setEnabled(true);
        pic.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_removeActionPerformed

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        Session ses = Session.getInstance();
        dbconfig dbc = new dbconfig();

        if (selectedFile != null) {
            try {
                destination = "src/userimages/" + selectedFile.getName();
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch (IOException ex) {
                System.out.println("Copy Image Error: " + ex);
                JOptionPane.showMessageDialog(null, "Failed to copy image!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }else {
            JOptionPane.showMessageDialog(null, "No image selected!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (dbc.insertData("UPDATE tbl_users SET u_image = '" + destination + "' WHERE u_id = '" + ses.getId() + "'")) {
            JOptionPane.showMessageDialog(null, "Photo uploaded successfully!");
        }else {
            JOptionPane.showMessageDialog(null, "Failed to upload photo!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveMouseClicked

    private void browseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/userimages/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();

                if(FileExistenceChecker(path) == 1){
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path = "";
                    remove.setEnabled(false);
                }else{
                    pic.setIcon(ResizeImage(path, null, pic));
                    remove.setEnabled(true);
                }
            }catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_browseMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session ses = Session.getInstance();
        name.setText(ses.getName());

        try{
            String sql = "SELECT u_image FROM tbl_users WHERE u_id = " + ses.getId();

            ResultSet rs = dbc.getData(sql);

            if(rs.next()) {
                String imagePath = rs.getString("u_image");
                if(imagePath != null && !imagePath.isEmpty()) {
                    pic.setIcon(ResizeImage(imagePath, null, pic));
                }else {
                    pic.setText("No Image Found");
                }
            }
        }catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(uploadProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uploadProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uploadProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uploadProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uploadProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel browse;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel name;
    private javax.swing.JLabel pic;
    public javax.swing.JButton remove;
    public javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
