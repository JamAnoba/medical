
package Admin;

import config.dbconfig;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class completedOrders extends javax.swing.JInternalFrame {
    private Connection connect;
   
    public completedOrders() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        pres_tbl.setRowHeight(25);
        pres_tbl.setShowGrid(true);
        pres_tbl.setGridColor(Color.blue);
        pres_tbl.setSelectionBackground(Color.black);
        displayData();
        showData("", "");
  
    }
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medico", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    public void displayData(){
        Connection con = getConnection();
        if (con == null) {
            JOptionPane.showMessageDialog(this, "Database connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String query = "SELECT prescriptions.p_id, customer.u_name, customer.u_contact, prescriptions.p_pic, prescriptions.date, prescriptions.time, admin_staff.a_name " +
                           "FROM customer " +
                           "INNER JOIN prescriptions ON prescriptions.u_id = customer.u_id " +
                           "INNER JOIN admin_staff ON prescriptions.a_id = admin_staff.a_id " +
                           "WHERE p_status = 'Received'";
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            pres_tbl.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Errors on closing: " + ex.getMessage());
            }
        }
    }
    
    public void showData(String d1, String d2){
        Connection con = getConnection();
        if (con == null) {
            JOptionPane.showMessageDialog(this, "Database connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String query = "SELECT prescriptions.p_id, customer.u_name, customer.u_contact, prescriptions.p_pic, prescriptions.date, prescriptions.time, admin_staff.a_name " +
                           "FROM customer " +
                           "INNER JOIN prescriptions ON prescriptions.u_id = customer.u_id " +
                           "INNER JOIN admin_staff ON prescriptions.a_id = admin_staff.a_id " +
                           "WHERE p_status = 'Received' AND prescriptions.date BETWEEN ? AND ?";
            st = con.prepareStatement(query);
            st.setString(1, d1);
            st.setString(2, d2);

            rs = st.executeQuery();
            DefaultTableModel model = (DefaultTableModel) pres_tbl.getModel();
            model.setRowCount(0); 

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("p_id"),
                    rs.getString("u_name"),
                    rs.getString("u_contact"),
                    rs.getString("p_pic"),
                    rs.getString("date"),
                    timeFormat.format(rs.getTime("time")), 
                    rs.getString("a_name")
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Errors on closing: " + ex.getMessage());
            }
        }
    }

        
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pres_tbl = new javax.swing.JTable();
        d1 = new com.toedter.calendar.JDateChooser();
        d2 = new com.toedter.calendar.JDateChooser();
        search = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        printt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jScrollPane1.setViewportView(pres_tbl);

        search.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        search.setText("SEARCH");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("SELECT DATE");

        printt.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        printt.setForeground(new java.awt.Color(0, 51, 102));
        printt.setText("Print Details");
        printt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printtMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        jLabel4.setText("from:");

        jLabel5.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        jLabel5.setText("to:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(printt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(26, 26, 26)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(search)
                                    .addGap(43, 43, 43))))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(search)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = df.format(d1.getDate());
            String date2 = df.format(d2.getDate());

            showData(date1, date2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select valid dates.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void printtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printtMouseClicked
        try {
            String fromDate = d1.getDate() != null ? new SimpleDateFormat("yyyy-MM-dd").format(d1.getDate()) : "";
            String toDate = d2.getDate() != null ? new SimpleDateFormat("yyyy-MM-dd").format(d2.getDate()) : "";

            DefaultTableModel model = (DefaultTableModel) pres_tbl.getModel();

            reports reportsFrame = new reports(fromDate, toDate, model);
            reportsFrame.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_printtMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser d1;
    private com.toedter.calendar.JDateChooser d2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pres_tbl;
    private javax.swing.JLabel printt;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
