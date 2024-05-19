
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
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;

public class updateDash extends javax.swing.JInternalFrame {

   
    public updateDash() {
        initComponents();
        displayData();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
    
    public void displayData(){
        try{
            dbconfig dbc = new dbconfig();
            ResultSet rs = dbc.getData("SELECT * FROM tbl_users");
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
        if (!imagePath.isEmpty()) {
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

        jPanel1 = new javax.swing.JPanel();
        bluebg = new javax.swing.JPanel();
        ps = new javax.swing.JPasswordField();
        cn = new javax.swing.JTextField();
        nm = new javax.swing.JTextField();
        ty = new javax.swing.JComboBox<>();
        jlbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        info_tbl = new javax.swing.JTable();
        jlbl1 = new javax.swing.JLabel();
        jlbl3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlbl4 = new javax.swing.JLabel();
        st = new javax.swing.JComboBox<>();
        em = new javax.swing.JTextField();
        jlbl2 = new javax.swing.JLabel();
        us = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jlbl7 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pic = new javax.swing.JLabel();
        up = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bluebg.setBackground(new java.awt.Color(0, 51, 102));
        bluebg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bluebg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ps.setEditable(false);
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
        bluebg.add(nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 160, 30));

        ty.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ty.setForeground(new java.awt.Color(51, 51, 51));
        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patient", "Pharmacist" }));
        ty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyActionPerformed(evt);
            }
        });
        bluebg.add(ty, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 140, 20));

        jlbl.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jlbl.setForeground(new java.awt.Color(255, 255, 255));
        jlbl.setText("Status");
        bluebg.add(jlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, 20));

        info_tbl.setBackground(new java.awt.Color(204, 204, 255));
        info_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                info_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(info_tbl);

        bluebg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 570, 160));

        jlbl1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jlbl1.setForeground(new java.awt.Color(255, 255, 255));
        jlbl1.setText("Contact no.:");
        bluebg.add(jlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        jlbl3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jlbl3.setForeground(new java.awt.Color(255, 255, 255));
        jlbl3.setText("Password:");
        bluebg.add(jlbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name:");
        bluebg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jlbl4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jlbl4.setForeground(new java.awt.Color(255, 255, 255));
        jlbl4.setText("Account Type");
        bluebg.add(jlbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, 20));

        st.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        st.setForeground(new java.awt.Color(51, 51, 51));
        st.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Active" }));
        bluebg.add(st, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 140, 20));

        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        bluebg.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 160, 30));

        jlbl2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jlbl2.setForeground(new java.awt.Color(255, 255, 255));
        jlbl2.setText("Username:");
        bluebg.add(jlbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        bluebg.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 160, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email:");
        bluebg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

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
        bluebg.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 160, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("print");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        bluebg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-test-account-48.png"))); // NOI18N
        bluebg.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, 60));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
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

    private void info_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info_tblMouseClicked
        int rowIndex = info_tbl.getSelectedRow();
        if(rowIndex<0){
            JOptionPane.showMessageDialog(null,"Please Select an Item");
        } else {
            TableModel model = info_tbl.getModel();

            id.setText(""+model.getValueAt(rowIndex,0));
            nm.setText(""+model.getValueAt(rowIndex,1));
            em.setText(""+model.getValueAt(rowIndex,2));
            cn.setText(""+model.getValueAt(rowIndex,3));
            us.setText(""+model.getValueAt(rowIndex,4));
            ps.setText(""+model.getValueAt(rowIndex,5));
            ty.setSelectedItem(""+model.getValueAt(rowIndex,7));  //combo box
            st.setSelectedItem(""+model.getValueAt(rowIndex,8)); //combo box

            String imagePath = ""+model.getValueAt(rowIndex,9); 
            setScaledImage(imagePath); 
        }
    }//GEN-LAST:event_info_tblMouseClicked

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed
    
    public boolean duplicateChecker(){
        String n_contact = cn.getText();
        String n_email = em.getText();
        String n_username = us.getText();
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
            System.out.println(""+ex);
        }

        return false;
    }
    
    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        // TODO add your handling code here:

        if(nm.getText().isEmpty() || em.getText().isEmpty() || cn.getText().isEmpty()
            || us.getText().isEmpty() || ps.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!");
        } else if (ps.getText().length() < 8){
            JOptionPane.showMessageDialog(null, "Password should have 8 characters and above!");
            ps.setText("");
        } else if (!isValidContact(cn.getText())){
            JOptionPane.showMessageDialog(null, "Invalid contact number! \t Contact number must start with \"09\" followed by 9 digits.");
            cn.setText("");
        } else if (duplicateChecker()){
            System.out.println("Duplicate Exist!");

        }else{
            dbconfig dbc = new dbconfig();
            try {
                String hashedPassword = passHash.hashPassword(ps.getText()); // Hash the password
               
                if(dbc.updateData("UPDATE tbl_users SET u_name = '"+nm.getText()+"',u_username = '"+us.getText()+"',"
                    + "u_email = '"+em.getText()+"',u_type = '"+ty.getSelectedItem()+"',u_status = '"+st.getSelectedItem()+"' WHERE u_id = '"+id.getText()+"'")){
                nm.setText("");
                id.setText("");
                em.setText("");
                us.setText("");
                ps.setText("");
                cn.setText("");
                displayData();
            }else {
                JOptionPane.showMessageDialog(null, "Failed to update!");
            }
        }catch(NoSuchAlgorithmException ex) {
            System.out.println(""+ex);
        }
        }
    }//GEN-LAST:event_upActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        nm.setText("");
        id.setText("");
        em.setText("");
        us.setText("");
        ps.setText("");
        cn.setText("");
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-test-account-48.png"))); 
    }//GEN-LAST:event_clearActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try{
           info_tbl.print();
        }catch(Exception ex){
           System.out.println(""+ex);
        }
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bluebg;
    private javax.swing.JButton clear;
    private javax.swing.JTextField cn;
    private javax.swing.JTextField em;
    private javax.swing.JTextField id;
    private javax.swing.JTable info_tbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbl;
    private javax.swing.JLabel jlbl1;
    private javax.swing.JLabel jlbl2;
    private javax.swing.JLabel jlbl3;
    private javax.swing.JLabel jlbl4;
    private javax.swing.JLabel jlbl7;
    private javax.swing.JTextField nm;
    private javax.swing.JLabel pic;
    private javax.swing.JPasswordField ps;
    private javax.swing.JComboBox<String> st;
    private javax.swing.JComboBox<String> ty;
    private javax.swing.JButton up;
    private javax.swing.JTextField us;
    // End of variables declaration//GEN-END:variables
}
