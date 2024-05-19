
package Admin;

import config.dbconfig;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;


public class delDash extends javax.swing.JInternalFrame {

  
    public delDash() {
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
    
    private void deleteImage(String imagePath) {
        if (!imagePath.isEmpty()) {
            File file = new File(imagePath);
            if (file.exists()) {
                boolean deleted = file.delete();
                if (!deleted) {
                    System.out.println("Failed to delete the image file: " + imagePath);
                }
            }
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
        pic = new javax.swing.JLabel();
        del1 = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bluebg.setBackground(new java.awt.Color(0, 51, 102));
        bluebg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bluebg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ps.setEditable(false);
        bluebg.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 160, 30));

        cn.setEditable(false);
        cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnActionPerformed(evt);
            }
        });
        bluebg.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 160, 30));

        nm.setEditable(false);
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

        em.setEditable(false);
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

        us.setEditable(false);
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

        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-test-account-48.png"))); // NOI18N
        bluebg.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, 60));

        jPanel1.add(bluebg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 610, 380));

        del1.setBackground(new java.awt.Color(153, 153, 255));
        del1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        del1.setText("DELETE");
        del1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del1ActionPerformed(evt);
            }
        });
        jPanel1.add(del1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 120, 40));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
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
        }else{
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

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void del1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del1ActionPerformed
        dbconfig dbc = new dbconfig();
        int rowsindex = info_tbl.getSelectedRow();
        if(rowsindex < 0){
            JOptionPane.showMessageDialog(null,"Please Select Data");
        }else {
            TableModel model = info_tbl.getModel();
            Object value = model.getValueAt(rowsindex,0);
            String id = value.toString();
            int a = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this ID? "+id);
            if(a == JOptionPane.YES_OPTION){
                int ID = Integer.parseInt(id);

                String imagePath = ""+model.getValueAt(rowsindex,9);
                deleteImage(imagePath);

                dbc.deleteData(ID,"tbl_users");
                displayData();
            }
        }
    }//GEN-LAST:event_del1ActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed

        nm.setText("");
        id.setText("");
        em.setText("");
        us.setText("");
        ps.setText("");
        cn.setText("");
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-test-account-48.png"))); 
    }//GEN-LAST:event_clearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bluebg;
    private javax.swing.JButton clear;
    private javax.swing.JTextField cn;
    private javax.swing.JButton del1;
    private javax.swing.JTextField em;
    private javax.swing.JTextField id;
    private javax.swing.JTable info_tbl;
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
    private javax.swing.JTextField us;
    // End of variables declaration//GEN-END:variables
}
