
package medicalapp;

import Admin.adminDashboard;
import com.formdev.flatlaf.FlatClientProperties;
import pharmacistDashboard.pharmadb;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import config.Session;
import config.dbconfig;
import config.passHash;
import customerDashboard.customerdb;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class Loginfrm extends javax.swing.JFrame {

  
    public Loginfrm() {
        initComponents();
        FlatLightLaf.setup();
        FlatIntelliJLaf.setup();
        UIManager.put( "Button.arc", 555 );
        
        us.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Username");
        ps.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Password");

        us.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);
        ps.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);

        ps.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true;"+"showCapsLock:true;");

    }
    
   
   
    public static boolean loginAcc(String user, String pass){
        dbconfig connector = new dbconfig();
        try {
            // Check in the customer table
            String queryUser = "SELECT * FROM customer WHERE u_username = '" + user + "' ";
            ResultSet rsUser = connector.getData(queryUser);

            if (rsUser.next()) {
                String hashedPass = rsUser.getString("u_pass");

                if (passHash.hashPassword(pass).equals(hashedPass)) {
                    Session ses = Session.getInstance();
                    ses.setId(rsUser.getInt("u_id"));
                    ses.setName(rsUser.getString("u_name"));
                    ses.setEmail(rsUser.getString("u_email"));
                    ses.setUsername(rsUser.getString("u_username"));
                    ses.setAcctype(rsUser.getString("u_type"));
                    ses.setSex(rsUser.getString("u_gender"));
                    ses.setStatus(rsUser.getString("u_status"));
                    ses.setContact(rsUser.getString("u_contact"));
                    ses.setPass(hashedPass);

                    return true;
                } else {
                    return false;
                }
            }

            // Check in the admin_staff table
            String queryAdmin = "SELECT * FROM admin_staff WHERE a_username = '" + user + "' ";
            ResultSet rsAdmin = connector.getData(queryAdmin);

            if (rsAdmin.next()) {
                String hashedPass = rsAdmin.getString("a_pass");

                if (passHash.hashPassword(pass).equals(hashedPass)) {
                    Session ses = Session.getInstance();
                    ses.setId(rsAdmin.getInt("a_id"));
                    ses.setName(rsAdmin.getString("a_name"));
                    ses.setEmail(rsAdmin.getString("a_email"));
                    ses.setUsername(rsAdmin.getString("a_username"));
                    ses.setAcctype(rsAdmin.getString("a_type"));
                    ses.setSex(rsAdmin.getString("a_gender"));
                    ses.setStatus(rsAdmin.getString("a_status"));
                    ses.setContact(rsAdmin.getString("a_contact"));
                    ses.setPass(hashedPass);

                    return true;
                } else {
                    return false;
                }
            }

            return false;
        } catch (SQLException | NoSuchAlgorithmException ex) {
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
        createacc = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        ps = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        signin = new javax.swing.JButton();
        loginbg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Username:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(480, 210, 80, 17);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Password:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(480, 270, 90, 17);

        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        jPanel1.add(us);
        us.setBounds(570, 190, 270, 40);

        createacc.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        createacc.setForeground(new java.awt.Color(255, 255, 255));
        createacc.setText("New? Click here to register.");
        createacc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createaccMouseClicked(evt);
            }
        });
        jPanel1.add(createacc);
        createacc.setBounds(650, 400, 140, 14);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/icons8-log-out-25.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel1.add(back);
        back.setBounds(860, 10, 25, 40);
        jPanel1.add(ps);
        ps.setBounds(570, 250, 270, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 37)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Log In");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(610, 60, 130, 45);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome Back! Please login to your account.");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(550, 110, 250, 15);

        signin.setBackground(new java.awt.Color(0, 0, 102));
        signin.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        signin.setForeground(new java.awt.Color(255, 255, 255));
        signin.setText("Log In");
        signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinActionPerformed(evt);
            }
        });
        jPanel1.add(signin);
        signin.setBounds(650, 350, 120, 40);

        loginbg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/logIN (1).png"))); // NOI18N
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

    private void signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinActionPerformed
         Session ses = Session.getInstance();

        if (us.getText().isEmpty() || ps.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (loginAcc(us.getText(), ps.getText())) {
            if (ses.getStatus().equals("Active") && ses.getAcctype().equalsIgnoreCase("Patient")) {
                JOptionPane.showMessageDialog(null, "Log In Successfully as Patient!");
                customerdb db = new customerdb();
                db.setVisible(true);
                this.dispose();
            } else if (ses.getStatus().equals("Active") && ses.getAcctype().equalsIgnoreCase("Pharmacist")) {
                JOptionPane.showMessageDialog(null, "Log In Successfully as Pharmacist!");
                pharmadb pd = new pharmadb();
                pd.setVisible(true);
                this.dispose();
            } else if (ses.getStatus().equals("Active") && ses.getAcctype().equalsIgnoreCase("Admin")) {
                JOptionPane.showMessageDialog(null, "Log In Successfully as Admin!");
                adminDashboard ad = new adminDashboard();
                ad.setVisible(true);
                this.dispose();
            } else if (ses.getStatus().equals("Pending")) {
                JOptionPane.showMessageDialog(null, "Pending Account!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account Not Found!");
            us.setText("");
            ps.setText("");
        }
    }//GEN-LAST:event_signinActionPerformed

    public static void main(String args[]) {
        FlatLightLaf.setup();
        FlatIntelliJLaf.setup();
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loginbg;
    private javax.swing.JPasswordField ps;
    private javax.swing.JButton signin;
    private javax.swing.JTextField us;
    // End of variables declaration//GEN-END:variables

    void SetVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
