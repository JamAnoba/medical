
package medicalapp;

import config.dbconfig;
import docdashboard.docdb;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Signup extends javax.swing.JFrame {

    public Signup() {
        initComponents();
    }

   
    public static String email, usname;
    public boolean duplicateChecker(){
        
        dbconfig dbc = new dbconfig();
        
        try{
            String query = "SELECT * FROM tbl_med  WHERE u_username = '" + us.getText() + "' OR u_email = '" + em.getText() + "'";
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        nm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        us = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        signupbutton = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ty = new javax.swing.JComboBox<>();
        at = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        cn = new javax.swing.JTextField();
        ps = new javax.swing.JPasswordField();
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
        nm.setBounds(440, 120, 370, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Name:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(340, 130, 60, 17);
        jPanel1.add(us);
        us.setBounds(440, 240, 370, 30);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Username:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(340, 250, 80, 17);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Email:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(340, 170, 60, 17);
        jPanel1.add(em);
        em.setBounds(440, 160, 370, 30);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Contact no.:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(340, 210, 90, 17);

        signupbutton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        signupbutton.setText("                     Sign Up");
        signupbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupbuttonMouseClicked(evt);
            }
        });
        jPanel1.add(signupbutton);
        signupbutton.setBounds(440, 460, 230, 22);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Password:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(340, 290, 100, 17);

        ty.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ty.setForeground(new java.awt.Color(51, 51, 51));
        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doctor ", "Pharmacist" }));
        ty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyActionPerformed(evt);
            }
        });
        jPanel1.add(ty);
        ty.setBounds(440, 340, 310, 30);

        at.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        at.setText("Account Type");
        jPanel1.add(at);
        at.setBounds(440, 380, 100, 17);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/icons8-log-out-25.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel1.add(back);
        back.setBounds(840, 10, 25, 40);
        jPanel1.add(cn);
        cn.setBounds(440, 200, 370, 30);
        jPanel1.add(ps);
        ps.setBounds(440, 280, 370, 30);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/2.PNG"))); // NOI18N
        jPanel1.add(bg);
        bg.setBounds(0, 0, 900, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
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

    private void signupbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupbuttonMouseClicked
 
        
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
       
                if(dbc.insertData("INSERT INTO tbl_med (u_name, u_email, u_contact, u_username, u_pass, u_type, u_status)" 
                        +"VALUES('"+nm.getText()+"', '"+em.getText()+"', '"+cn.getText()+"', '"+us.getText()+"', "
                        + "'"+ps.getText()+"', '"+ty.getSelectedItem()+"', 'Pending')")){
                    JOptionPane.showMessageDialog(null, "Account Created Successfully!");
                    Loginfrm lg = new Loginfrm();
                    lg.setVisible(true);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Connection Error!");
                }
        }
          
        
    }//GEN-LAST:event_signupbuttonMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        Welcomepage wm = new Welcomepage();
        wm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

  
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
    private javax.swing.JLabel back;
    private javax.swing.JLabel bg;
    private javax.swing.JTextField cn;
    private javax.swing.JTextField em;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nm;
    private javax.swing.JPasswordField ps;
    private javax.swing.JLabel signupbutton;
    private javax.swing.JComboBox<String> ty;
    private javax.swing.JTextField us;
    // End of variables declaration//GEN-END:variables

    void SetVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
