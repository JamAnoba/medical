
package pharmacistDashboard;

import config.Session;
import config.dbconfig;
import static customerDashboard.upload.getHeightFromWidth;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;


public class pickUp extends javax.swing.JInternalFrame {

    public pickUp() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        displayData();
    }

    public void displayData(){
        try {
            dbconfig dbc = new dbconfig();
            ResultSet rs = dbc.getData("SELECT prescriptions.p_id, customer.u_name, customer.u_contact, prescriptions.p_pic, prescriptions.date, prescriptions.time\n" +
            "FROM customer INNER JOIN prescriptions ON prescriptions.u_id = customer.u_id WHERE p_status = 'Ready for pick up'");
            info_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch(SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        info_tbl = new javax.swing.JTable();
        received = new javax.swing.JButton();
        u_id = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        notify = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pic = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                info_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(info_tbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 350, 267));

        received.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        received.setText("RECEIVED");
        received.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivedActionPerformed(evt);
            }
        });
        jPanel1.add(received, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 107, 32));
        jPanel1.add(u_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 57, 14));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("ID :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 26, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel1.setText("READY FOR PICKUP ORDERS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 26, 340, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("PRESCRIPTION");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 150, -1));

        notify.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        notify.setText("NOTIFY");
        notify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notifyActionPerformed(evt);
            }
        });
        jPanel1.add(notify, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 110, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("ID :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 26, -1));
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 57, 14));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic.setText("No Image Found");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void receivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivedActionPerformed
        dbconfig dbc = new dbconfig();
        Session ses = Session.getInstance();
        int pharmacistId = ses.getId();  // Assuming this gets the current logged-in pharmacist's ID

        
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dateFormat.format(now);
        String currentTime = timeFormat.format(now);

        String prescriptionId = id.getText();
        String userId = u_id.getText();

        if (prescriptionId.isEmpty() || userId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a prescription to update.");
            return;
        }

        String updateQuery = "UPDATE prescriptions SET a_id='"+ses.getId()+"', p_status = 'Received', date = '" + currentDate + "', time = '" + currentTime + "', a_id = '" + pharmacistId + "' WHERE p_id = '" + prescriptionId + "'";

        boolean updateSuccess = dbc.updateData(updateQuery);

        if (updateSuccess) {
            u_id.setText("");
            id.setText("");
            pic.setIcon(null);
            displayData();
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update prescription status.");
        }
    }//GEN-LAST:event_receivedActionPerformed

    private void info_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info_tblMouseClicked
        int rowIndex = info_tbl.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please Select an Item");
        } else {
            TableModel model = info_tbl.getModel();

            id.setText("" + model.getValueAt(rowIndex, 0));
            u_id.setText("" + model.getValueAt(rowIndex, 1));
            String imagePath = (String) model.getValueAt(rowIndex, 3); 

            if (imagePath != null && !imagePath.isEmpty()) {
                pic.setIcon(ResizeImage(imagePath, null, pic));
            } else {
                JOptionPane.showMessageDialog(null, "No Image Available for this Item");
            }
        }
    }//GEN-LAST:event_info_tblMouseClicked

    private void notifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notifyActionPerformed
        Session ses = Session.getInstance();
        dbconfig dbc = new dbconfig();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dateFormat.format(now);
        String currentTime = timeFormat.format(now);
        
        if (id.getText().isEmpty() || u_id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a data from the table.");
            return;
        }
        
        dbc.insertData("INSERT INTO notification (notif, u_id, p_id, `date`, `time`)"
                    + " VALUES('Your order is ready for pick up!', '"+u_id.getText()+"', '"+id.getText()+"' , '"+currentDate+"', '"+currentTime+"')") ;
            JOptionPane.showMessageDialog(null, "Sent Successfully!");
    }//GEN-LAST:event_notifyActionPerformed

    public ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
        ImageIcon MyImage = null;
        if (ImagePath != null) {
            MyImage = new ImageIcon(ImagePath);
        }else if (pic != null) {
            MyImage = new ImageIcon(pic);
        }else {
            return null;
        }

        int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel id;
    private javax.swing.JTable info_tbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton notify;
    private javax.swing.JLabel pic;
    private javax.swing.JButton received;
    private javax.swing.JLabel u_id;
    // End of variables declaration//GEN-END:variables
}
