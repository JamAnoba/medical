
package Admin;

import config.dbconfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import config.passHash;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;


public class addDash extends javax.swing.JInternalFrame {

    public addDash() {
        initComponents();
        displayCustomer();
        displayStaff();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public static String path;
    dbconfig dbc = new dbconfig();
    
    public void displayCustomer(){
        try{
            dbconfig dbc = new dbconfig();
            ResultSet rs = dbc.getData("SELECT u_id, u_name, u_email, u_contact, u_username, u_pass, u_gender, u_status, u_image FROM customer");
            info_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
 
    }
     
    public void displayStaff(){
        try{
            dbconfig dbc = new dbconfig();
            ResultSet rs = dbc.getData("SELECT a_id, a_name, a_email, a_contact, a_username, a_pass, a_gender, a_status, a_image FROM admin_staff");
            ad_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
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
    
    private void setScaledImage(String imagePath) {
        try {
            if (imagePath != null && !imagePath.isEmpty()) {
                File file = new File(imagePath);
                Image img = ImageIO.read(file);

                int width = pic.getWidth();
                int height = pic.getHeight();

                Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                pic.setIcon(new ImageIcon(scaledImg));
            } else {
                pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-test-account-48.png")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gd = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        bluebg = new javax.swing.JPanel();
        ps = new javax.swing.JPasswordField();
        cn = new javax.swing.JTextField();
        nm = new javax.swing.JTextField();
        ty = new javax.swing.JComboBox<>();
        jlbl = new javax.swing.JLabel();
        jlbl1 = new javax.swing.JLabel();
        jlbl3 = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlbl4 = new javax.swing.JLabel();
        st = new javax.swing.JComboBox<>();
        male = new javax.swing.JRadioButton();
        em = new javax.swing.JTextField();
        jlbl2 = new javax.swing.JLabel();
        us = new javax.swing.JTextField();
        fem = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        up = new javax.swing.JButton();
        pic = new javax.swing.JLabel();
        customss = new javax.swing.JTabbedPane();
        stafff = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ad_tbl = new javax.swing.JTable();
        customs = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        info_tbl = new javax.swing.JTable();
        add1 = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bluebg.setBackground(new java.awt.Color(0, 51, 102));
        bluebg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bluebg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psActionPerformed(evt);
            }
        });
        bluebg.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 160, 30));

        cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnActionPerformed(evt);
            }
        });
        bluebg.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 160, 30));

        nm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmActionPerformed(evt);
            }
        });
        bluebg.add(nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 160, 30));

        ty.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        ty.setForeground(new java.awt.Color(51, 51, 51));
        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patient", "Pharmacist" }));
        ty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyActionPerformed(evt);
            }
        });
        bluebg.add(ty, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 140, 20));

        jlbl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlbl.setForeground(new java.awt.Color(255, 255, 255));
        jlbl.setText("Status");
        bluebg.add(jlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 40, 20));

        jlbl1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlbl1.setForeground(new java.awt.Color(255, 255, 255));
        jlbl1.setText("Contact no.:");
        bluebg.add(jlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 70, 10));

        jlbl3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlbl3.setForeground(new java.awt.Color(255, 255, 255));
        jlbl3.setText("Password:");
        bluebg.add(jlbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 70, 10));

        gender.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        gender.setForeground(new java.awt.Color(255, 255, 255));
        gender.setText("Gender:");
        bluebg.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 60, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name:");
        bluebg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 40, 10));

        jlbl4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlbl4.setForeground(new java.awt.Color(255, 255, 255));
        jlbl4.setText("Account Type");
        bluebg.add(jlbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 80, 20));

        st.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        st.setForeground(new java.awt.Color(51, 51, 51));
        st.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Active" }));
        bluebg.add(st, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 140, 20));

        gd.add(male);
        male.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        bluebg.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 60, 30));

        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        bluebg.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 160, 30));

        jlbl2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlbl2.setForeground(new java.awt.Color(255, 255, 255));
        jlbl2.setText("Username:");
        bluebg.add(jlbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 70, 10));

        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        bluebg.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 160, 30));

        gd.add(fem);
        fem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fem.setForeground(new java.awt.Color(255, 255, 255));
        fem.setText("Female");
        fem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femActionPerformed(evt);
            }
        });
        bluebg.add(fem, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 70, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email:");
        bluebg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 40, 10));

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
        bluebg.add(up, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 20, -1));

        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-test-account-48.png"))); // NOI18N
        bluebg.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 60, 60));

        customss.setBackground(new java.awt.Color(204, 204, 255));

        stafff.setBackground(new java.awt.Color(0, 51, 102));

        ad_tbl.setBackground(new java.awt.Color(204, 204, 255));
        ad_tbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ad_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ad_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ad_tbl);

        javax.swing.GroupLayout stafffLayout = new javax.swing.GroupLayout(stafff);
        stafff.setLayout(stafffLayout);
        stafffLayout.setHorizontalGroup(
            stafffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stafffLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );
        stafffLayout.setVerticalGroup(
            stafffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stafffLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        customss.addTab("staff", stafff);

        customs.setBackground(new java.awt.Color(0, 51, 102));

        info_tbl.setBackground(new java.awt.Color(204, 204, 255));
        info_tbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        info_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                info_tblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(info_tbl);

        javax.swing.GroupLayout customsLayout = new javax.swing.GroupLayout(customs);
        customs.setLayout(customsLayout);
        customsLayout.setHorizontalGroup(
            customsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        customsLayout.setVerticalGroup(
            customsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        customss.addTab("customer", customs);

        bluebg.add(customss, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 610, 180));

        jPanel1.add(bluebg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 610, 380));

        add1.setBackground(new java.awt.Color(153, 153, 255));
        add1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add1.setText("ADD");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        jPanel1.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 110, 40));

        clear.setBackground(new java.awt.Color(153, 153, 255));
        clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    public boolean duplicateChecker(){
        String n_contact = cn.getText();
        String n_email = em.getText();
        String n_username = us.getText();

        dbconfig dbc = new dbconfig();
        try {
            ResultSet customerResultSet = dbc.getData("SELECT * FROM customer WHERE (u_username = '" + n_username + "' OR u_email = '" + n_email + "' OR u_contact = '" + n_contact + "') ");
            if (customerResultSet.next()) {
                String email = customerResultSet.getString("u_email");
                String username = customerResultSet.getString("u_username");
                String contact = customerResultSet.getString("u_contact");

                if (email.equals(n_email)) {
                    JOptionPane.showMessageDialog(null, "Email is already used!");
                    em.setText("");
                    return true;
                }

                if (username.equals(n_username)) {
                    JOptionPane.showMessageDialog(null, "Username is already used!");
                    us.setText("");
                    return true;
                }

                if (contact.equals(n_contact)) {
                    JOptionPane.showMessageDialog(null, "Contact no. is already used!");
                    cn.setText("");
                    return true;
                }
            }

            ResultSet staffResultSet = dbc.getData("SELECT * FROM admin_staff WHERE (a_username = '" + n_username + "' OR a_email = '" + n_email + "' OR a_contact = '" + n_contact + "') ");
            if (staffResultSet.next()) {
                String email = staffResultSet.getString("a_email");
                String username = staffResultSet.getString("a_username");
                String contact = staffResultSet.getString("a_contact");

                if (email.equals(n_email)) {
                    JOptionPane.showMessageDialog(null, "Email is already used!");
                    em.setText("");
                    return true;
                }

                if (username.equals(n_username)) {
                    JOptionPane.showMessageDialog(null, "Username is already used!");
                    us.setText("");
                    return true;
                }

                if (contact.equals(n_contact)) {
                    JOptionPane.showMessageDialog(null, "Contact no. is already used!");
                    cn.setText("");
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }

        return false;
    }
    
    
    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        if(nm.getText().isEmpty() || em.getText().isEmpty() || cn.getText().isEmpty()
            || us.getText().isEmpty() || ps.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
            return;
        }

        if(duplicateChecker()) {
            System.out.println("Duplicate Exist!");
        } else {
            dbconfig dbc = new dbconfig();
            try {
                String hashedPassword = passHash.hashPassword(ps.getText());
                String sex = "";

                if (male.isSelected()) {
                    sex = "Male";
                }else if (fem.isSelected()) {
                    sex = "Female";
                }

                String selectedType = ty.getSelectedItem().toString();

                if (selectedType.equals("Patient")) {
                    if(dbc.insertData("INSERT INTO customer (u_name, u_email, u_contact, u_username, u_pass, u_gender, u_type, u_status, u_image)"
                        + " VALUES('"+nm.getText()+"', '"+em.getText()+"', '"+cn.getText()+"', '"+us.getText()+"', "
                        + "'"+hashedPassword+"', '"+sex+"', '"+selectedType+"','"+st.getSelectedItem()+"', '"+destination+"')")) {
                        JOptionPane.showMessageDialog(null, "Registered Successfully!");
                        displayCustomer();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to register!");
                    }
                } else if (selectedType.equals("Pharmacist")) {
                    if(dbc.insertData("INSERT INTO admin_staff (a_name, a_email, a_contact, a_username, a_pass, a_gender, a_type, a_status, a_image)"
                        + " VALUES('"+nm.getText()+"', '"+em.getText()+"', '"+cn.getText()+"', '"+us.getText()+"', "
                        + "'"+hashedPassword+"', '"+sex+"', '"+selectedType+"','"+st.getSelectedItem()+"', '"+destination+"')")) {
                        JOptionPane.showMessageDialog(null, "Registered Successfully!");
                        displayStaff();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to register!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid user type!");
                }

                nm.setText("");
                em.setText("");
                us.setText("");
                ps.setText("");    
                cn.setText("");
                pic.setIcon(null);
                gd.clearSelection();
            }catch(NoSuchAlgorithmException ex) {
                System.out.println(""+ex);
            }
        }
    }//GEN-LAST:event_add1ActionPerformed

        
    private void nmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nmActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void tyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tyActionPerformed

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed

    private void cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleActionPerformed

    private void femActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed

        nm.setText("");
        em.setText("");
        us.setText("");
        ps.setText("");
        cn.setText("");
        gd.clearSelection();
    }//GEN-LAST:event_clearActionPerformed

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
                    Files.copy(selectedFile.toPath(), new File(destination).toPath());
                    ImageIcon imageIcon = new ImageIcon(path);
                    Image image = imageIcon.getImage();
                    Image newImage = image.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImageIcon = new ImageIcon(newImage);
                    pic.setIcon(newImageIcon);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_upMouseClicked

    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed

    }//GEN-LAST:event_upActionPerformed

    private void psActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psActionPerformed

    private void ad_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ad_tblMouseClicked

    }//GEN-LAST:event_ad_tblMouseClicked

    private void info_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info_tblMouseClicked

    }//GEN-LAST:event_info_tblMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable ad_tbl;
    private javax.swing.JButton add1;
    private javax.swing.JPanel bluebg;
    private javax.swing.JButton clear;
    public javax.swing.JTextField cn;
    private javax.swing.JPanel customs;
    private javax.swing.JTabbedPane customss;
    public javax.swing.JTextField em;
    public javax.swing.JRadioButton fem;
    private javax.swing.ButtonGroup gd;
    private javax.swing.JLabel gender;
    public javax.swing.JTable info_tbl;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlbl;
    private javax.swing.JLabel jlbl1;
    private javax.swing.JLabel jlbl2;
    private javax.swing.JLabel jlbl3;
    private javax.swing.JLabel jlbl4;
    public javax.swing.JRadioButton male;
    public javax.swing.JTextField nm;
    public javax.swing.JLabel pic;
    public javax.swing.JPasswordField ps;
    public javax.swing.JComboBox<String> st;
    private javax.swing.JPanel stafff;
    public javax.swing.JComboBox<String> ty;
    private javax.swing.JButton up;
    public javax.swing.JTextField us;
    // End of variables declaration//GEN-END:variables
}
