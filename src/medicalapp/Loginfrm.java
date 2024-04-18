
package medicalapp;


import Admin.adminDashboard;
import PharmaDashboard.pharmadb;
import config.Session;
import config.dbconfig;
import docdashboard.docdb;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Loginfrm extends javax.swing.JFrame {

  
    public Loginfrm() {
        initComponents();
    }
    
   
   
   public static boolean loginAcc(String user, String pass){
    dbconfig connector = new dbconfig();
    try{
        String query = "SELECT * FROM tbl_med WHERE u_username = '" + user + "' AND u_pass = '" + pass + "' ";
        ResultSet rs = connector.getData(query);
        
        if(rs.next()){
           Session ses =  Session.getInstance();
                    ses.setId(rs.getInt("u_id"));
                    ses.setName(rs.getString("u_name"));
                    ses.setEmail(rs.getString("u_email"));
                    ses.setUsername(rs.getString("u_username"));
                    ses.setAcctype(rs.getString("u_type"));
                    ses.setStatus(rs.getString("u_status"));
           return true;
        }else{
            return false;
        }
    }catch (SQLException ex) {
        return false; 
    }
  }


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        us = new javax.swing.JTextField();
        loginbutton = new javax.swing.JLabel();
        createacc = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        ps = new javax.swing.JPasswordField();
        loginbg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Username:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(460, 210, 80, 17);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Password:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(460, 270, 100, 17);

        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        jPanel1.add(us);
        us.setBounds(550, 190, 270, 40);

        loginbutton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        loginbutton.setText("                     Log In");
        loginbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginbuttonMouseClicked(evt);
            }
        });
        jPanel1.add(loginbutton);
        loginbutton.setBounds(550, 340, 230, 22);

        createacc.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        createacc.setForeground(new java.awt.Color(0, 0, 153));
        createacc.setText("New? Click here to register.");
        createacc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createaccMouseClicked(evt);
            }
        });
        jPanel1.add(createacc);
        createacc.setBounds(620, 390, 170, 14);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/icons8-log-out-25.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel1.add(back);
        back.setBounds(860, 10, 25, 40);
        jPanel1.add(ps);
        ps.setBounds(550, 250, 270, 40);

        loginbg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/log in.png"))); // NOI18N
        jPanel1.add(loginbg);
        loginbg.setBounds(0, 0, 900, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbuttonMouseClicked
        
        Session ses = Session.getInstance();
        
        if(loginAcc(us.getText(), ps.getText())){
            if(ses.getStatus().equals("Active") && ses.getAcctype().equals("Doctor")){
                    JOptionPane.showMessageDialog(null, "Log In Successfully!");    
                    docdb db = new docdb();
                    db.setVisible(true);
                    this.dispose();   
                }else if(ses.getStatus().equals("Active") && ses.getAcctype().equals("Pharmacist")){
                    JOptionPane.showMessageDialog(null, "Log In Successfully!"); 
                    pharmadb pd = new pharmadb();
                    pd.setVisible(true);
                    this.dispose();  
                }else if (ses.getStatus().equals("Active") && ses.getAcctype().equals("Admin")){
                    JOptionPane.showMessageDialog(null, "Log In Successfully!"); 
                    adminDashboard ad = new adminDashboard();
                    ad.setVisible(true);
                    this.dispose();
   
                }else if(us.getText().isEmpty() || ps.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "All fields are required!"); 
                }else if(ses.getStatus().equals("Pending")){
                    JOptionPane.showMessageDialog(null, "Pending Account!");
                }
        }else{
            JOptionPane.showMessageDialog(null, "Account Not Found!");
            us.setText("");
            ps.setText("");
        }
    }//GEN-LAST:event_loginbuttonMouseClicked

    private void createaccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createaccMouseClicked
        Signup sgn = new Signup();
        sgn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createaccMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        Welcomepage wm = new Welcomepage();
        wm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed

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
            java.util.logging.Logger.getLogger(Loginfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loginfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loginfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loginfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loginfrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel createacc;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loginbg;
    private javax.swing.JLabel loginbutton;
    private javax.swing.JPasswordField ps;
    private javax.swing.JTextField us;
    // End of variables declaration//GEN-END:variables

    void SetVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
