
package pharmacistDashboard;

import config.dbconfig;
import static customerDashboard.personalDetails.getHeightFromWidth;
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


public class inProcess extends javax.swing.JInternalFrame {

    public inProcess() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        displayData();
    }
    
    public void displayData(){
        try{
            dbconfig dbc = new dbconfig();
            ResultSet rs = dbc.getData("SELECT prescriptions.p_id, tbl_users.u_name, tbl_users.u_contact, prescriptions.p_pic, prescriptions.date, prescriptions.time\n" +
            "FROM tbl_users INNER JOIN prescriptions ON prescriptions.u_id = tbl_users.u_id WHERE p_status = 'In Process'");
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        info_tbl = new javax.swing.JTable();
        pickup = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pic = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel1.setText("IN PROCESS ORDERS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(43, 26, 270, 40);

        info_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                info_tblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                info_tblMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(info_tbl);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(43, 109, 330, 260);

        pickup.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pickup.setText("READY FOR PICK  UP");
        pickup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickupActionPerformed(evt);
            }
        });
        jPanel1.add(pickup);
        pickup.setBounds(130, 390, 160, 30);
        jPanel1.add(id);
        id.setBounds(70, 80, 66, 12);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("ID :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(46, 80, 30, 14);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("PRESCRIPTION");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(420, 60, 150, 14);

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

        jPanel1.add(jPanel2);
        jPanel2.setBounds(420, 90, 280, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void info_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info_tblMouseClicked
        int rowIndex = info_tbl.getSelectedRow();
    
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please Select an Item");
        } else {
            TableModel model = info_tbl.getModel();

            id.setText("" + model.getValueAt(rowIndex,0));
            String imagePath = (String) model.getValueAt(rowIndex, 3); 

            if (imagePath != null && !imagePath.isEmpty()) {
                pic.setIcon(ResizeImage(imagePath, null, pic));
            } else {
                JOptionPane.showMessageDialog(null, "No Image Available for this Item");
            }
        }
    }//GEN-LAST:event_info_tblMouseClicked

    private void pickupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickupActionPerformed
        if (id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a prescription to update.");
            return;
        }
        
        dbconfig dbc = new dbconfig();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dateFormat.format(now);
        String currentTime = timeFormat.format(now);

        dbc.updateData("UPDATE prescriptions SET p_status = 'Ready for pick up', `date` = '"+currentDate+"', `time` = '"+currentTime+"' WHERE p_id = '"+id.getText()+"' ");

        id.setText("");
        pic.setIcon(null);
        displayData();
    }//GEN-LAST:event_pickupActionPerformed

    private void info_tblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info_tblMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_info_tblMouseEntered
    
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pic;
    private javax.swing.JButton pickup;
    // End of variables declaration//GEN-END:variables
}
