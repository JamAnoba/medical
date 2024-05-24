
package Admin;

import config.dbconfig;
import config.passHash;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.NoSuchAlgorithmException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class updateDash extends javax.swing.JInternalFrame {
    
    
    public updateDash() {
        initComponents();
        displayStaff();
        displayCustomer();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
    }

    public void displayStaff(){
        try{
            dbconfig dbc = new dbconfig();
            ResultSet rs = dbc.getData("SELECT * FROM admin_staff");
            ad_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
 
    }
    
    public void displayCustomer(){
        try{
            dbconfig dbc = new dbconfig();
            ResultSet rs = dbc.getData("SELECT * FROM customer");
            info_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
 
    }
     
    

    private boolean isValidContact(String contact){
        return contact.matches("09\\d{9}"); 
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
        bluebg = new javax.swing.JPanel();
        ps = new javax.swing.JPasswordField();
        cn = new javax.swing.JTextField();
        nm = new javax.swing.JTextField();
        ty = new javax.swing.JComboBox<>();
        jlbl1 = new javax.swing.JLabel();
        jlbl3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlbl4 = new javax.swing.JLabel();
        st = new javax.swing.JComboBox<>();
        gd = new javax.swing.JTextField();
        jlbl2 = new javax.swing.JLabel();
        us = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jlbl7 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        pic = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        staffs = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ad_tbl = new javax.swing.JTable();
        custom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        info_tbl = new javax.swing.JTable();
        printt = new javax.swing.JLabel();
        jlbl5 = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        gender1 = new javax.swing.JLabel();
        up = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bluebg.setBackground(new java.awt.Color(0, 51, 102));
        bluebg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bluebg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ps.setEditable(false);
        bluebg.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 150, 30));

        cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnActionPerformed(evt);
            }
        });
        bluebg.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 150, 30));

        nm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmActionPerformed(evt);
            }
        });
        bluebg.add(nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 150, 30));

        ty.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        ty.setForeground(new java.awt.Color(51, 51, 51));
        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patient", "Pharmacist" }));
        ty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyActionPerformed(evt);
            }
        });
        bluebg.add(ty, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 150, 20));

        jlbl1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jlbl1.setForeground(new java.awt.Color(255, 255, 255));
        jlbl1.setText("Contact no.:");
        bluebg.add(jlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, 40));

        jlbl3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jlbl3.setForeground(new java.awt.Color(255, 255, 255));
        jlbl3.setText("Password:");
        bluebg.add(jlbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 80, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name:");
        bluebg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, 20));

        jlbl4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlbl4.setForeground(new java.awt.Color(255, 255, 255));
        jlbl4.setText("Account Type");
        bluebg.add(jlbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 80, 20));

        st.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        st.setForeground(new java.awt.Color(51, 51, 51));
        st.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Active", "Archive" }));
        bluebg.add(st, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 150, 20));

        gd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gdActionPerformed(evt);
            }
        });
        bluebg.add(gd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 150, 30));

        jlbl2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jlbl2.setForeground(new java.awt.Color(255, 255, 255));
        jlbl2.setText("Username:");
        bluebg.add(jlbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, 40));

        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        bluebg.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 150, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email:");
        bluebg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, 40));

        jlbl7.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jlbl7.setForeground(new java.awt.Color(255, 255, 255));
        jlbl7.setText("ID:");
        bluebg.add(jlbl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        id.setEditable(false);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        bluebg.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 150, 30));

        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-test-account-48.png"))); // NOI18N
        bluebg.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, 60));

        staffs.setBackground(new java.awt.Color(0, 51, 102));

        ad_tbl.setBackground(new java.awt.Color(204, 204, 255));
        ad_tbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ad_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ad_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ad_tbl);

        javax.swing.GroupLayout staffsLayout = new javax.swing.GroupLayout(staffs);
        staffs.setLayout(staffsLayout);
        staffsLayout.setHorizontalGroup(
            staffsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );
        staffsLayout.setVerticalGroup(
            staffsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("staff", staffs);

        custom.setBackground(new java.awt.Color(0, 51, 102));

        info_tbl.setBackground(new java.awt.Color(204, 204, 255));
        info_tbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        info_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                info_tblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(info_tbl);

        javax.swing.GroupLayout customLayout = new javax.swing.GroupLayout(custom);
        custom.setLayout(customLayout);
        customLayout.setHorizontalGroup(
            customLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        customLayout.setVerticalGroup(
            customLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("customer", custom);

        bluebg.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 610, 160));

        printt.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        printt.setForeground(new java.awt.Color(255, 102, 102));
        printt.setText("Print Details");
        printt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printtMouseClicked(evt);
            }
        });
        bluebg.add(printt, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 70, 20));

        jlbl5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jlbl5.setForeground(new java.awt.Color(255, 255, 255));
        jlbl5.setText("Status");
        bluebg.add(jlbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, 20));

        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        bluebg.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 150, 30));

        gender1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        gender1.setForeground(new java.awt.Color(255, 255, 255));
        gender1.setText("Gender:");
        bluebg.add(gender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 60, 20));

        jPanel1.add(bluebg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 610, 380));

        up.setBackground(new java.awt.Color(153, 153, 255));
        up.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        up.setText("UPDATE");
        up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });
        jPanel1.add(up, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 120, 40));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnActionPerformed

    private void nmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nmActionPerformed

    private void tyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tyActionPerformed

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed
    
    public boolean duplicateChecker(int currentUserId, String userType) {
    String n_contact = cn.getText();
    String n_email = gd.getText();
    String n_username = us.getText();

    dbconfig dbc = new dbconfig();
    try {
        String query;
        if (userType.equals("Patient")) {
            query = "SELECT * FROM customer WHERE (u_username = '" + n_username + "' OR u_email = '" + n_email + "' OR u_contact = '" + n_contact + "') AND u_id != " + currentUserId;
        } else {
            query = "SELECT * FROM admin_staff WHERE (a_username = '" + n_username + "' OR a_email = '" + n_email + "' OR a_contact = '" + n_contact + "') AND a_id != " + currentUserId;
        }

        ResultSet resultSet = dbc.getData(query);
        if (resultSet.next()) {
            if (userType.equals("Patient")) {
                String email = resultSet.getString("u_email");
                String username = resultSet.getString("u_username");
                String contact = resultSet.getString("u_contact");

                if (email.equals(n_email)) {
                    JOptionPane.showMessageDialog(null, "Email is already used!");
                    gd.setText("");
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
            } else {
                String email = resultSet.getString("a_email");
                String username = resultSet.getString("a_username");
                String contact = resultSet.getString("a_contact");

                if (email.equals(n_email)) {
                    JOptionPane.showMessageDialog(null, "Email is already used!");
                    gd.setText("");
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
        }
    } catch (SQLException ex) {
        System.out.println("" + ex);
    }

    return false;
}

    
    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        int currentUserId = Integer.parseInt(id.getText());
        String userType = ty.getSelectedItem().toString();

        if (nm.getText().isEmpty() || gd.getText().isEmpty() || cn.getText().isEmpty()
                || us.getText().isEmpty() || ps.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
        } else if (ps.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "Password should have 8 characters and above!");
            ps.setText("");
        } else if (!isValidContact(cn.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid contact number! \t Contact number must start with \"09\" followed by 9 digits.");
            cn.setText("");
        } else if (!(em.getText().matches("^[a-zA-Z0-9_%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
            em.setText("");
        } else if (duplicateChecker(currentUserId, userType)) {
            System.out.println("Duplicate Exists!");
        } else {
            dbconfig dbc = new dbconfig();
            try {
                String hashedPassword = passHash.hashPassword(ps.getText()); // Hash the password

                if (userType.equals("Pharmacist")) {
                    // Update admin_staff table
                    String updateQuery = "UPDATE admin_staff SET a_name = '" + nm.getText() + "', a_username = '" + us.getText() + "',"
                            + "a_email = '" + em.getText() + "', a_contact = '" + cn.getText() + "', a_pass = '" + hashedPassword + "', a_gender = '"+ gd.getText()+"', a_type = '" + ty.getSelectedItem() + "'"
                            + ", a_status = '" + st.getSelectedItem() + "' WHERE a_id = '" + currentUserId + "'";

                    if (dbc.updateData(updateQuery)) {
                        nm.setText("");
                        em.setText("");
                        id.setText("");
                        gd.setText("");
                        us.setText("");
                        ps.setText("");
                        cn.setText("");
                        displayStaff();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update!");
                    }
                } else if (userType.equals("Patient")) {
                    // Update customer table
                    String updateQuery = "UPDATE customer SET u_name = '" + nm.getText() + "', u_username = '" + us.getText() + "',"
                            + "u_email = '" + em.getText() + "', u_contact = '" + cn.getText() + "', u_pass = '" + hashedPassword + "', "
                            + "u_gender = '"+ gd.getText()+"', u_type = '" + ty.getSelectedItem() + "', u_status = '" + st.getSelectedItem() + "' WHERE u_id = '" + currentUserId + "'";

                    if (dbc.updateData(updateQuery)) {
                        nm.setText("");
                        em.setText("");
                        id.setText("");
                        gd.setText("");
                        us.setText("");
                        ps.setText("");
                        cn.setText("");
                        displayCustomer();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid account type!");
                }
            } catch (NoSuchAlgorithmException ex) {
                System.out.println("" + ex);
            }
        }
    }//GEN-LAST:event_upActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void gdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gdActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        nm.setText("");
        em.setText("");
        id.setText("");
        gd.setText("");
        us.setText("");
        ps.setText("");
        cn.setText("");
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-test-account-48.png"))); 
    }//GEN-LAST:event_clearActionPerformed

    private void ad_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ad_tblMouseClicked
        int rowIndex = ad_tbl.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please Select an Item");
        } else {
            TableModel model = ad_tbl.getModel();
            int columnCount = model.getColumnCount();
            System.out.println("ad_tbl columns: " + columnCount);  
            if (columnCount >= 9) { 
                id.setText("" + model.getValueAt(rowIndex, 0));
                nm.setText("" + model.getValueAt(rowIndex, 1));
                em.setText("" + model.getValueAt(rowIndex, 2));
                cn.setText("" + model.getValueAt(rowIndex, 3));
                us.setText("" + model.getValueAt(rowIndex, 4));
                ps.setText("" + model.getValueAt(rowIndex, 5));
                gd.setText("" + model.getValueAt(rowIndex, 6));
                ty.setSelectedItem("" + model.getValueAt(rowIndex, 7));  
                st.setSelectedItem("" + model.getValueAt(rowIndex, 8)); 

                String imagePath = "" + model.getValueAt(rowIndex, 9); 
                setScaledImage(imagePath);
            } else {
                JOptionPane.showMessageDialog(null, "Table columns are not as expected.");
            }
        }
    }//GEN-LAST:event_ad_tblMouseClicked

    private void info_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info_tblMouseClicked
        int rowIndex = info_tbl.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please Select an Item");
        } else {
            TableModel model = info_tbl.getModel();
            int columnCount = model.getColumnCount();
            System.out.println("info_tbl columns: " + columnCount);  
            if (columnCount >= 9) { 
                id.setText("" + model.getValueAt(rowIndex, 0));
                nm.setText("" + model.getValueAt(rowIndex, 1));
                em.setText("" + model.getValueAt(rowIndex, 2));
                cn.setText("" + model.getValueAt(rowIndex, 3));
                us.setText("" + model.getValueAt(rowIndex, 4));
                ps.setText("" + model.getValueAt(rowIndex, 5));
                gd.setText("" + model.getValueAt(rowIndex, 6));
                ty.setSelectedItem("" + model.getValueAt(rowIndex, 7)); 
                st.setSelectedItem("" + model.getValueAt(rowIndex, 8));

                String imagePath = "" + model.getValueAt(rowIndex, 9); 
                setScaledImage(imagePath);
            } else {
                JOptionPane.showMessageDialog(null, "Table columns are not as expected.");
            }
        }
    
    }//GEN-LAST:event_info_tblMouseClicked

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void printtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printtMouseClicked
        int rowIndex = ad_tbl.getSelectedRow();    

        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please select specific item", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                dbconfig dbc = new dbconfig();
                TableModel tbl = ad_tbl.getModel();
                int selectedId = (int) tbl.getValueAt(rowIndex, 0);
                ResultSet rs = dbc.getData("SELECT * FROM admin_staff WHERE a_id = " + selectedId);

                if (rs.next()) {
                    individualPrint ip = new individualPrint();
                    ip.setVisible(true);
                    ip.idd.setText("" + rs.getInt("a_id"));
                    ip.nmm.setText("" + rs.getString("a_name"));
                    ip.cnn.setText("" + rs.getString("a_contact"));
                    ip.gdd.setText("" + rs.getString("a_gender"));
                    ip.tyy.setText("" + rs.getString("a_type")); 
                    ip.picc.setIcon(ResizeImage(rs.getString("a_image"),null,pic));   
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_printtMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable ad_tbl;
    private javax.swing.JPanel bluebg;
    private javax.swing.JButton clear;
    public javax.swing.JTextField cn;
    private javax.swing.JPanel custom;
    public javax.swing.JTextField em;
    public javax.swing.JTextField gd;
    private javax.swing.JLabel gender1;
    public javax.swing.JTextField id;
    public javax.swing.JTable info_tbl;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlbl1;
    private javax.swing.JLabel jlbl2;
    private javax.swing.JLabel jlbl3;
    private javax.swing.JLabel jlbl4;
    private javax.swing.JLabel jlbl5;
    private javax.swing.JLabel jlbl7;
    public javax.swing.JTextField nm;
    public javax.swing.JLabel pic;
    private javax.swing.JLabel printt;
    public javax.swing.JPasswordField ps;
    public javax.swing.JComboBox<String> st;
    private javax.swing.JPanel staffs;
    public javax.swing.JComboBox<String> ty;
    private javax.swing.JButton up;
    public javax.swing.JTextField us;
    // End of variables declaration//GEN-END:variables
}
