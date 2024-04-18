
package Admin;

import config.Session;
import config.dbconfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import medicalapp.Loginfrm;
import medicalapp.Welcomepage;
import net.proteanit.sql.DbUtils;


public class adminDashboard extends javax.swing.JFrame {

  
    public adminDashboard() {
        initComponents();
        displayData();
    }

    public void displayData(){
        try{
            dbconfig dbc = new dbconfig();
            ResultSet rs = dbc.getData("SELECT * FROM tbl_med");
            info_tbl.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
        
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        info_tbl = new javax.swing.JTable();
        jlbl = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        jlbl7 = new javax.swing.JLabel();
        ps = new javax.swing.JTextField();
        jlbl1 = new javax.swing.JLabel();
        cn = new javax.swing.JTextField();
        jlbl2 = new javax.swing.JLabel();
        us = new javax.swing.JTextField();
        ty = new javax.swing.JComboBox<>();
        jlbl3 = new javax.swing.JLabel();
        add1 = new javax.swing.JButton();
        up = new javax.swing.JButton();
        del1 = new javax.swing.JButton();
        ref = new javax.swing.JButton();
        logout = new javax.swing.JLabel();
        st = new javax.swing.JComboBox<>();
        jlbl4 = new javax.swing.JLabel();
        clear1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        adminbg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 20));

        info_tbl.setBackground(new java.awt.Color(204, 204, 255));
        info_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                info_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(info_tbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 630, 160));

        jlbl.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jlbl.setText("Status");
        jPanel1.add(jlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, -1, -1));

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 160, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Email:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        jPanel1.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 160, 30));

        jlbl7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbl7.setText("ID:");
        jPanel1.add(jlbl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, -1));

        ps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psActionPerformed(evt);
            }
        });
        jPanel1.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 160, 30));

        jlbl1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbl1.setText("Contact no.:");
        jPanel1.add(jlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, -1, -1));

        cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnActionPerformed(evt);
            }
        });
        jPanel1.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 160, 30));

        jlbl2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbl2.setText("Username:");
        jPanel1.add(jlbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        jPanel1.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 160, 30));

        ty.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ty.setForeground(new java.awt.Color(51, 51, 51));
        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doctor ", "Pharmacist" }));
        ty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyActionPerformed(evt);
            }
        });
        jPanel1.add(ty, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 140, 20));

        jlbl3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbl3.setText("Password:");
        jPanel1.add(jlbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        add1.setBackground(new java.awt.Color(255, 204, 153));
        add1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        add1.setText("ADD");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        jPanel1.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 80, 30));

        up.setBackground(new java.awt.Color(255, 204, 153));
        up.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        up.setText("UPDATE");
        up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });
        jPanel1.add(up, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 80, 30));

        del1.setBackground(new java.awt.Color(255, 204, 153));
        del1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        del1.setText("DELETE");
        del1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del1ActionPerformed(evt);
            }
        });
        jPanel1.add(del1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 80, 30));

        ref.setBackground(new java.awt.Color(255, 204, 153));
        ref.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ref.setText("REFRESH");
        ref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refActionPerformed(evt);
            }
        });
        jPanel1.add(ref, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 80, 30));

        logout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logout.setText("LOGOUT");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, -1));

        st.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        st.setForeground(new java.awt.Color(51, 51, 51));
        st.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Active" }));
        jPanel1.add(st, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 140, 20));

        jlbl4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jlbl4.setText("Account Type");
        jPanel1.add(jlbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        clear1.setBackground(new java.awt.Color(255, 204, 153));
        clear1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        clear1.setText("CLEAR");
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });
        jPanel1.add(clear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 80, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Name:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        nm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmActionPerformed(evt);
            }
        });
        jPanel1.add(nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 160, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/profile.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 60));

        search.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 180, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/icons8-search-25.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, -1, 30));

        adminbg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/profile (1).png"))); // NOI18N
        jPanel1.add(adminbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

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

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void psActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnActionPerformed

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed

    private void tyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tyActionPerformed

    private void refActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refActionPerformed
        // TODO add your handling code here:
        displayData();
    }//GEN-LAST:event_refActionPerformed

    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        // TODO add your handling code here:
                        
            if(nm.getText().isEmpty() || em.getText().isEmpty() || cn.getText().isEmpty() 
                || us.getText().isEmpty() || ps.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "All fields are required!"); 
            }else if(ps.getText().length() < 8){
                    JOptionPane.showMessageDialog(null, "Password should have 8 characters and above!");
                    ps.setText("");
            }else if(duplicateChecker()){
                    System.out.println("Duplicate Exist!");

            }else{
                    dbconfig dbc = new dbconfig();

                    dbc.updateData("UPDATE tbl_med SET u_name ='"+nm.getText()+"',u_username='"+us.getText()+"',u_pass='"+ps.getText()+"',"
                + "u_email='"+em.getText()+"',u_type='"+ty.getSelectedItem()+"',u_status='"+st.getSelectedItem()+"' WHERE u_id='"+id.getText()+"'");
                        nm.setText("");
                        id.setText("");
                        em.setText("");
                        us.setText("");
                        ps.setText("");    
                        cn.setText("");
                    
            }
    }//GEN-LAST:event_upActionPerformed

    private void del1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del1ActionPerformed
        // TODO add your handling code here:
         int rowsindex = info_tbl.getSelectedRow();
            if(rowsindex<0){
                JOptionPane.showMessageDialog(null,"Please Select Data");
            }else{
                TableModel model = info_tbl.getModel();
                Object value=model.getValueAt(rowsindex,0);
                String id=value.toString();
                int a=JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this ID?"+id);
                    if(a==JOptionPane.YES_OPTION){
                        dbconfig dbc = new dbconfig();
                        int ID=Integer.parseInt(id);
                        dbc.deleteData(ID,"tbl_med");
                        displayData();
                    }

            }

    }//GEN-LAST:event_del1ActionPerformed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        Welcomepage wm = new Welcomepage();
        wm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked
    
    public static String email, usname;
    public boolean duplicateChecker(){
        
        dbconfig dbc = new dbconfig();
        
        try{
            String query = "SELECT * FROM tbl_med  WHERE (u_username = '" + us.getText() + "' OR u_email = '" + em.getText() + "') AND u_id != '"+id+"'";
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
                return true;
            }else{
                return false; 
            }
        }catch (SQLException ex) {
            System.out.println(""+ex);
            return false;
            
        }

        
    }
    
    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
        if(duplicateChecker()){
                System.out.println("Duplicate Exist!");
                
        }else{
            
            dbconfig dbc = new dbconfig();

            if(dbc.insertData("INSERT INTO tbl_med (u_name, u_email, u_contact, u_username, u_pass, u_type, u_status)" 
                            +"VALUES('"+id.getText()+"', '"+em.getText()+"', '"+cn.getText()+"', '"+us.getText()+"', "
                            + "'"+ps.getText()+"', '"+ty.getSelectedItem()+"','"+st.getSelectedItem()+"')")){
                        JOptionPane.showMessageDialog(null, "Registered Successfully!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Connection Error!");
                    }
        }
    }//GEN-LAST:event_add1ActionPerformed

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
        // TODO add your handling code here:
        nm.setText("");
        id.setText("");
        em.setText("");
        us.setText("");
        ps.setText("");    
        cn.setText("");
    }//GEN-LAST:event_clear1ActionPerformed

    private void nmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nmActionPerformed

    private void info_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info_tblMouseClicked
        // TODO add your handling code here:
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
        ty.setSelectedItem(""+model.getValueAt(rowIndex,6));  //combo box//
        st.setSelectedItem(""+model.getValueAt(rowIndex,7)); //combo box//

            }
    }//GEN-LAST:event_info_tblMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session ses = Session.getInstance();
        name.setText(ses.getName());
    }//GEN-LAST:event_formWindowActivated

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new adminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add1;
    private javax.swing.JLabel adminbg;
    private javax.swing.JButton clear1;
    private javax.swing.JTextField cn;
    private javax.swing.JButton del1;
    private javax.swing.JTextField em;
    private javax.swing.JTextField id;
    private javax.swing.JTable info_tbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel logout;
    public javax.swing.JLabel name;
    private javax.swing.JTextField nm;
    private javax.swing.JTextField ps;
    private javax.swing.JButton ref;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> st;
    private javax.swing.JComboBox<String> ty;
    private javax.swing.JButton up;
    private javax.swing.JTextField us;
    // End of variables declaration//GEN-END:variables
}
