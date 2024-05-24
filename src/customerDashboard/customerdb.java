
package customerDashboard;


import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import config.Session;
import config.dbconfig;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import medicalapp.Loginfrm;


public class customerdb extends javax.swing.JFrame {

  
    public customerdb() {
        initComponents();
        updateTimeAndDate();
        updateCounts();
        
        FlatLightLaf.setup();
        FlatIntelliJLaf.setup();
        UIManager.put( "Button.arc", 555 );
    }

    private void updateTimeAndDate() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter times = DateTimeFormatter.ofPattern("hh : mm a");
                LocalDateTime now = LocalDateTime.now();
                time.setText(times.format(now));
                
                DateTimeFormatter dates = DateTimeFormatter.ofPattern("MM-dd-yyy");
                date.setText(dates.format(now));
            }
        });
        timer.start();
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
    
    private void updateCounts() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medico", "root", "");
            Session ses = Session.getInstance();
            int userId = ses.getId(); 

            String notifQuery = "SELECT COUNT(notif) FROM notification WHERE u_id = ?";
            PreparedStatement notifPst = conn.prepareStatement(notifQuery);
            notifPst.setInt(1, userId); 
            ResultSet notifRs = notifPst.executeQuery();
            if (notifRs.next()) {
                int totalNotif = notifRs.getInt(1);
                notif.setText(Integer.toString(totalNotif));
            }

            String picQuery = "SELECT COUNT(p_pic) FROM prescriptions WHERE u_id = ?";
            PreparedStatement picPst = conn.prepareStatement(picQuery);
            picPst.setInt(1, userId);
            ResultSet picRs = picPst.executeQuery();
            if (picRs.next()) {
                int totalPres = picRs.getInt(1);
                pres.setText(Integer.toString(totalPres));
            }

            notifRs.close();
            notifPst.close();
            picRs.close();
            picPst.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        navbar = new javax.swing.JPanel();
        pic = new javax.swing.JLabel();
        docnm = new javax.swing.JLabel();
        dash = new javax.swing.JButton();
        upload = new javax.swing.JButton();
        notification = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        signout = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        navbar1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        mainbg = new javax.swing.JDesktopPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        notif = new javax.swing.JLabel();
        pres = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navbar.setBackground(new java.awt.Color(0, 51, 102));
        navbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-test-account-48.png"))); // NOI18N
        navbar.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        docnm.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        docnm.setForeground(new java.awt.Color(255, 255, 255));
        docnm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        docnm.setText("NAME");
        navbar.add(docnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 70, 20));

        dash.setBackground(new java.awt.Color(0, 51, 102));
        dash.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        dash.setForeground(new java.awt.Color(255, 255, 255));
        dash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashb.png"))); // NOI18N
        dash.setText("DASHBOARD");
        dash.setBorder(null);
        dash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashMouseExited(evt);
            }
        });
        navbar.add(dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        upload.setBackground(new java.awt.Color(0, 51, 102));
        upload.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        upload.setForeground(new java.awt.Color(255, 255, 255));
        upload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/upload_2.png"))); // NOI18N
        upload.setText("UPLOAD");
        upload.setBorder(null);
        upload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                uploadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                uploadMouseExited(evt);
            }
        });
        navbar.add(upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 160, 40));

        notification.setBackground(new java.awt.Color(0, 51, 102));
        notification.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        notification.setForeground(new java.awt.Color(255, 255, 255));
        notification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/NOTIF.png"))); // NOI18N
        notification.setText("NOTIFICATION");
        notification.setBorder(null);
        notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                notificationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                notificationMouseExited(evt);
            }
        });
        notification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationActionPerformed(evt);
            }
        });
        navbar.add(notification, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 160, 40));

        settings.setBackground(new java.awt.Color(0, 51, 102));
        settings.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        settings.setForeground(new java.awt.Color(255, 255, 255));
        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/SETTINGS.png"))); // NOI18N
        settings.setText("SETTINGS");
        settings.setBorder(null);
        settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsMouseExited(evt);
            }
        });
        navbar.add(settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 160, 40));

        signout.setBackground(new java.awt.Color(0, 51, 102));
        signout.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        signout.setForeground(new java.awt.Color(255, 255, 255));
        signout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.PNG"))); // NOI18N
        signout.setText("LOGOUT");
        signout.setBorder(null);
        signout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signoutMouseExited(evt);
            }
        });
        navbar.add(signout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 160, 40));

        main.add(navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 480));

        header.setBackground(new java.awt.Color(0, 51, 102));
        header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        date.setForeground(new java.awt.Color(255, 255, 255));

        time.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(615, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        main.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 80));

        navbar1.setBackground(new java.awt.Color(0, 51, 102));
        navbar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        navbar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/LoGo (1)_1.png"))); // NOI18N
        navbar1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, -1));

        main.add(navbar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        mainbg.setBackground(new java.awt.Color(240, 240, 240));

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("PRESCRIPTIONS");

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("NOTIFICATION");

        notif.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        notif.setForeground(new java.awt.Color(255, 255, 255));

        pres.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        pres.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("What do you want to do today?");

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 40)); // NOI18N
        jLabel5.setText("Welcome Back!");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/patientGradient (1).png"))); // NOI18N

        mainbg.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainbg.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainbg.setLayer(notif, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainbg.setLayer(pres, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainbg.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainbg.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainbg.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainbgLayout = new javax.swing.GroupLayout(mainbg);
        mainbg.setLayout(mainbgLayout);
        mainbgLayout.setHorizontalGroup(
            mainbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainbgLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(mainbgLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(notif, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170)
                .addComponent(pres, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(mainbgLayout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(mainbgLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(mainbgLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainbgLayout.setVerticalGroup(
            mainbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainbgLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(mainbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainbgLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(notif, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainbgLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(pres, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainbgLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainbgLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        main.add(mainbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 740, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session ses = Session.getInstance();
        docnm.setText(ses.getName());
        dbconfig dbc = new dbconfig();
        try {
            String sql = "SELECT u_image FROM customer WHERE u_id = " + ses.getId();

            ResultSet rs = dbc.getImagePath(sql);

            if (rs.next()) {
                String imagePath = rs.getString("u_image");
                if (imagePath != null && !imagePath.isEmpty()) {
                    pic.setIcon(ResizeImage(imagePath, null, pic));
                } else {
                    pic.setText("");
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_formWindowActivated

    private void notificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notificationActionPerformed

    private void signoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutMouseClicked
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            Loginfrm log = new Loginfrm();
            log.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_signoutMouseClicked

    private void settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseClicked
        personalDetails prd = new personalDetails();
        prd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_settingsMouseClicked

    private void notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationMouseClicked
        notif nf = new notif();
        mainbg.add(nf).setVisible(true);

    }//GEN-LAST:event_notificationMouseClicked

    private void uploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadMouseClicked
        upload up = new upload();
        mainbg.add(up);
        up.setVisible(true);
        up.browse.setEnabled(true);
        up.remove.setEnabled(false);

    }//GEN-LAST:event_uploadMouseClicked

    private void dashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseClicked
        customerdb db = new customerdb();
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashMouseClicked

    private void dashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseEntered
        dash.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_dashMouseEntered

    private void dashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseExited
        dash.setForeground(Color.white);
    }//GEN-LAST:event_dashMouseExited

    private void uploadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadMouseEntered
        upload.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_uploadMouseEntered

    private void uploadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadMouseExited
        upload.setForeground(Color.white);
    }//GEN-LAST:event_uploadMouseExited

    private void notificationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationMouseEntered
        notification.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_notificationMouseEntered

    private void notificationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationMouseExited
        notification.setForeground(Color.white);
    }//GEN-LAST:event_notificationMouseExited

    private void settingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseEntered
        settings.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_settingsMouseEntered

    private void settingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseExited
        settings.setForeground(Color.white);
    }//GEN-LAST:event_settingsMouseExited

    private void signoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutMouseEntered
        signout.setForeground(Color.red);
    }//GEN-LAST:event_signoutMouseEntered

    private void signoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutMouseExited
        signout.setForeground(Color.white);
    }//GEN-LAST:event_signoutMouseExited

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customerdb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dash;
    public javax.swing.JLabel date;
    private javax.swing.JLabel docnm;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel main;
    private javax.swing.JDesktopPane mainbg;
    private javax.swing.JPanel navbar;
    private javax.swing.JPanel navbar1;
    private javax.swing.JLabel notif;
    private javax.swing.JButton notification;
    private javax.swing.JLabel pic;
    private javax.swing.JLabel pres;
    private javax.swing.JButton settings;
    private javax.swing.JButton signout;
    public javax.swing.JLabel time;
    private javax.swing.JButton upload;
    // End of variables declaration//GEN-END:variables


}
