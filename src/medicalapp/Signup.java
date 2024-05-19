
package medicalapp;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import config.dbconfig;
import config.passHash;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class Signup extends javax.swing.JFrame {

    public Signup() {
        initComponents();
        FlatLightLaf.setup();
        FlatIntelliJLaf.setup();
        UIManager.put( "Button.arc", 555 );
    }

    public String destination = "";
    File selectedFile;
    public String oldpath;
    public static String path;
    dbconfig dbc = new dbconfig();
    public static String email, usname, contact;
    
    public boolean duplicateChecker(){
        dbconfig dbc = new dbconfig();
        
        try{
            String query = "SELECT * FROM tbl_users  WHERE u_username = '" + us.getText() + "' OR u_email = '" + em.getText() + "'";
            ResultSet resultSet = dbc.getData(query);
           
            if(resultSet.next()){ 
                email = resultSet.getString("u_email");
                    if(email.equals(em.getText())){
                        JOptionPane.showMessageDialog(null, "Email is already used!");
                        em.setText("");
                    }
                usname = resultSet.getString("u_username");
                    if(usname.equals(us.getText())){
                        JOptionPane.showMessageDialog(null, "Username is already used!");
                        us.setText("");
                    }
                contact = resultSet.getString("u_contact");
                    if(contact.equals(cn.getText())){
                        JOptionPane.showMessageDialog(null, "Contact no. is already used!");
                        cn.setText("");
                    }
                return true;
            }else{
                return false; 
            }
        }catch (SQLException ex) {
            System.out.println(""+ex);
            return false;
            
        }

        
    }
    
    private boolean isValidContact(String contact){
        return contact.matches("09\\d{9}"); 
    }
    
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        gd = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        nm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        us = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ty = new javax.swing.JComboBox<>();
        gender = new javax.swing.JLabel();
        cn = new javax.swing.JTextField();
        ps = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        viewpass = new javax.swing.JCheckBox();
        at = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        fem = new javax.swing.JRadioButton();
        register = new javax.swing.JButton();
        up = new javax.swing.JButton();
        pic = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 506));
        setMinimumSize(new java.awt.Dimension(900, 520));
        setPreferredSize(new java.awt.Dimension(900, 540));

        jPanel1.setLayout(null);
        jPanel1.add(nm);
        nm.setBounds(130, 160, 290, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 170, 60, 15);
        jPanel1.add(us);
        us.setBounds(130, 280, 290, 30);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Username:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(40, 290, 80, 15);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(40, 210, 60, 15);
        jPanel1.add(em);
        em.setBounds(130, 200, 290, 30);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Contact no.:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(40, 250, 90, 15);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Password:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(40, 330, 80, 15);

        ty.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ty.setForeground(new java.awt.Color(51, 51, 51));
        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patient", "Pharmacist" }));
        ty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyActionPerformed(evt);
            }
        });
        jPanel1.add(ty);
        ty.setBounds(140, 390, 130, 20);

        gender.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        gender.setForeground(new java.awt.Color(255, 255, 255));
        gender.setText("Gender:");
        jPanel1.add(gender);
        gender.setBounds(40, 360, 70, 20);
        jPanel1.add(cn);
        cn.setBounds(130, 240, 290, 30);
        jPanel1.add(ps);
        ps.setBounds(130, 320, 290, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create an Account");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 30, 340, 30);

        login.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login.setText("Log in");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        jPanel1.add(login);
        login.setBounds(270, 470, 40, 14);

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Already signed up?");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(180, 470, 120, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Please provide the following information to create your account.");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(80, 60, 320, 20);

        viewpass.setBackground(new java.awt.Color(0, 51, 102));
        viewpass.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        viewpass.setForeground(new java.awt.Color(255, 255, 255));
        viewpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewpassActionPerformed(evt);
            }
        });
        jPanel1.add(viewpass);
        viewpass.setBounds(420, 320, 20, 30);

        at.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        at.setForeground(new java.awt.Color(255, 255, 255));
        at.setText("Account Type:");
        jPanel1.add(at);
        at.setBounds(40, 390, 100, 20);

        gd.add(male);
        male.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        jPanel1.add(male);
        male.setBounds(130, 360, 60, 20);

        gd.add(fem);
        fem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fem.setForeground(new java.awt.Color(255, 255, 255));
        fem.setText("Female");
        jPanel1.add(fem);
        fem.setBounds(200, 360, 70, 20);

        register.setBackground(new java.awt.Color(0, 51, 153));
        register.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("REGISTER");
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
        });
        jPanel1.add(register);
        register.setBounds(190, 440, 110, 30);

        up.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/upload.png"))); // NOI18N
        up.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                upMouseClicked(evt);
            }
        });
        up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });
        jPanel1.add(up);
        up.setBounds(240, 130, 20, 20);

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-test-account-64.png"))); // NOI18N
        jPanel1.add(pic);
        pic.setBounds(200, 90, 60, 60);

        bg.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/logOUT (1).png"))); // NOI18N
        jPanel1.add(bg);
        bg.setBounds(0, 0, 900, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tyActionPerformed

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        Loginfrm log = new Loginfrm();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginMouseClicked

    private void viewpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewpassActionPerformed
        if(viewpass.isSelected()){
            ps.setEchoChar((char)0);
        }else{
            ps.setEchoChar('\u25CF');
        }

    }//GEN-LAST:event_viewpassActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleActionPerformed

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
        if(nm.getText().isEmpty() || em.getText().isEmpty() || cn.getText().isEmpty() 
            || us.getText().isEmpty() || ps.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!"); 
        } else if (ps.getText().length() < 8){
            JOptionPane.showMessageDialog(null, "Password should have 8 characters and above!");
            ps.setText("");
        } else if (!isValidContact(cn.getText())){
            JOptionPane.showMessageDialog(null, "Invalid contact number! \t Contact number must start with \"09\" followed by 9 digits.");
            cn.setText("");
        } else if (!(em.getText().matches("^[a-zA-Z0-9_%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
            em.setText("");
        } else if (duplicateChecker()){
            System.out.println("Duplicate Exist!");   
        } else {
            dbconfig dbc = new dbconfig();

            try{
                String pass = passHash.hashPassword(ps.getText());
                String sex = "";

                if (male.isSelected()) {
                    sex = "Male";
                }else if (fem.isSelected()) {
                    sex = "Female";
                }

                String destination = "";
                if (selectedFile != null) {
                    destination = "src/userimages/" + selectedFile.getName();
                    try {
                        Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        System.out.println("Copy Image Error: " + ex);
                        JOptionPane.showMessageDialog(null, "Failed to copy image!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                if(dbc.insertData("INSERT INTO tbl_users (u_name, u_email, u_contact, u_username, u_pass, u_gender, u_type, u_status, u_image)"
                    + " VALUES('"+nm.getText()+"', '"+em.getText()+"', '"+cn.getText()+"', '"+us.getText()+"', "
                    + "'"+pass+"', '"+sex+"', '"+ty.getSelectedItem()+"','Pending', '"+destination+"')")) {
                    JOptionPane.showMessageDialog(null, "Registered Successfully!");
                    Loginfrm log = new Loginfrm();
                    log.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Connection Error!");
                }
            } catch(NoSuchAlgorithmException ex){
                System.out.println(""+ex);
            }

        }
    }//GEN-LAST:event_registerMouseClicked

    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        
    }//GEN-LAST:event_upActionPerformed

    private void upMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upMouseClicked
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
                }else{
                    pic.setIcon(ResizeImage(path, null, pic));
                    ImageIcon imageIcon = new ImageIcon(path);
                    Image image = imageIcon.getImage();
                    Image newImage = image.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImageIcon = new ImageIcon(newImage);
                    pic.setIcon(newImageIcon);
                }
            }catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_upMouseClicked

  
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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel at;
    private javax.swing.JLabel bg;
    private javax.swing.JTextField cn;
    private javax.swing.JTextField em;
    private javax.swing.JRadioButton fem;
    private javax.swing.ButtonGroup gd;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel login;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField nm;
    private javax.swing.JLabel pic;
    private javax.swing.JPasswordField ps;
    private javax.swing.JButton register;
    private javax.swing.JComboBox<String> ty;
    private javax.swing.JButton up;
    private javax.swing.JTextField us;
    private javax.swing.JCheckBox viewpass;
    // End of variables declaration//GEN-END:variables

    void SetVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
