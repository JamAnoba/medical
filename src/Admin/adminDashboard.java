
package Admin;

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
import medicalapp.Loginfrm;

public class adminDashboard extends javax.swing.JFrame {
  
    public adminDashboard() {
        initComponents();
        updateTimeAndDate();
        updateTotalNumber(); 
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
    
    private void updateTotalNumber() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medico","root","");
            String query = "SELECT COUNT(*) FROM tbl_users";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                int totalUsers = rs.getInt(1);
                users.setText(Integer.toString(totalUsers));
            }
            
            query = "SELECT COUNT(*) FROM tbl_users WHERE u_status = 'Pending'";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            if(rs.next()) {
                int pendingUsers = rs.getInt(1);
                pending.setText(Integer.toString(pendingUsers));
            }
            
            query = "SELECT COUNT(*) FROM tbl_users WHERE u_status = 'Active'";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            if(rs.next()) {
                int activeUsers = rs.getInt(1);
                active.setText(Integer.toString(activeUsers));
            }
            
            rs.close();
            pst.close();
            conn.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gd = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        navbar = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        pic = new javax.swing.JLabel();
        dash = new javax.swing.JButton();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        archive = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        reports = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        navbar1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        mainbg = new javax.swing.JDesktopPane();
        titlebg = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        active = new javax.swing.JLabel();
        pending = new javax.swing.JLabel();
        users = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navbar.setBackground(new java.awt.Color(0, 51, 102));
        navbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navbar.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 100, 20));

        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-test-account-48.png"))); // NOI18N
        navbar.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 80, 40));

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

        add.setBackground(new java.awt.Color(0, 51, 102));
        add.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        add.setText("ADD ACCOUNT");
        add.setBorder(null);
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        navbar.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 160, 40));

        update.setBackground(new java.awt.Color(0, 51, 102));
        update.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        update.setText("UPDATE");
        update.setBorder(null);
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });
        navbar.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 160, 40));

        archive.setBackground(new java.awt.Color(0, 51, 102));
        archive.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        archive.setForeground(new java.awt.Color(255, 255, 255));
        archive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/archive.png"))); // NOI18N
        archive.setText("DELETE");
        archive.setBorder(null);
        archive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                archiveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                archiveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                archiveMouseExited(evt);
            }
        });
        navbar.add(archive, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 160, 40));

        logout.setBackground(new java.awt.Color(0, 51, 102));
        logout.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.PNG"))); // NOI18N
        logout.setText("LOGOUT");
        logout.setBorder(null);
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        navbar.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 160, 40));

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
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });
        navbar.add(settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 160, 40));

        reports.setBackground(new java.awt.Color(0, 51, 102));
        reports.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        reports.setForeground(new java.awt.Color(255, 255, 255));
        reports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/REPORTS.png"))); // NOI18N
        reports.setText("REPORT");
        reports.setBorder(null);
        reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportsMouseExited(evt);
            }
        });
        navbar.add(reports, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 160, 40));

        jPanel1.add(navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 160, 480));

        header.setBackground(new java.awt.Color(0, 51, 102));
        header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        time.setForeground(new java.awt.Color(255, 255, 255));

        date.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADMINISTRATOR");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 460, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 740, 70));

        navbar1.setBackground(new java.awt.Color(0, 51, 102));
        navbar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/LoGo (1)_1.png"))); // NOI18N

        javax.swing.GroupLayout navbar1Layout = new javax.swing.GroupLayout(navbar1);
        navbar1.setLayout(navbar1Layout);
        navbar1Layout.setHorizontalGroup(
            navbar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbar1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        navbar1Layout.setVerticalGroup(
            navbar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbar1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(navbar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 70));

        mainbg.setBackground(new java.awt.Color(240, 240, 240));

        titlebg.setBackground(new java.awt.Color(0, 0, 51));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 50)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MEDICO");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Prescription Order Tracker App");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo (1).png"))); // NOI18N
        jLabel9.setText("LOGO");

        javax.swing.GroupLayout titlebgLayout = new javax.swing.GroupLayout(titlebg);
        titlebg.setLayout(titlebgLayout);
        titlebgLayout.setHorizontalGroup(
            titlebgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlebgLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(titlebgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        titlebgLayout.setVerticalGroup(
            titlebgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlebgLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlebgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        mainbg.add(titlebg);
        titlebg.setBounds(0, 0, 840, 240);

        active.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        active.setForeground(new java.awt.Color(255, 255, 255));
        active.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        active.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activeMouseClicked(evt);
            }
        });
        mainbg.add(active);
        active.setBounds(590, 350, 60, 60);

        pending.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        pending.setForeground(new java.awt.Color(255, 255, 255));
        pending.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pending.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pendingMouseClicked(evt);
            }
        });
        mainbg.add(pending);
        pending.setBounds(390, 350, 60, 60);

        users.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        users.setForeground(new java.awt.Color(255, 255, 255));
        users.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersMouseClicked(evt);
            }
        });
        mainbg.add(users);
        users.setBounds(190, 350, 60, 60);

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("PENDING USERS");
        mainbg.add(jLabel12);
        jLabel12.setBounds(300, 310, 160, 30);

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("USERS");
        mainbg.add(jLabel11);
        jLabel11.setBounds(110, 310, 140, 30);

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ACTIVE USERS");
        mainbg.add(jLabel10);
        jLabel10.setBounds(490, 310, 180, 30);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/admingradient.png"))); // NOI18N
        mainbg.add(jLabel13);
        jLabel13.setBounds(0, 230, 740, 240);

        jPanel1.add(mainbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 740, 470));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 539));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session ses = Session.getInstance();
        name.setText(ses.getName());
        dbconfig dbc = new dbconfig();
        try {
            String sql = "SELECT u_image FROM tbl_users WHERE u_id = " + ses.getId();

            ResultSet rs = dbc.getImagePath(sql);

            if (rs.next()) {
                String imagePath = rs.getString("u_image");
                if (imagePath != null && !imagePath.isEmpty()) {
                    pic.setIcon(ResizeImage(imagePath, null, pic));
                } else {
                    pic.setText("");
                }
            }
        }catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_formWindowActivated

    private void usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseClicked
        
    }//GEN-LAST:event_usersMouseClicked

    private void pendingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingMouseClicked
        
    }//GEN-LAST:event_pendingMouseClicked

    private void activeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activeMouseClicked
        
    }//GEN-LAST:event_activeMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutActionPerformed

    private void dashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseClicked
        adminDashboard ad = new adminDashboard();
        ad.setVisible(true);
    }//GEN-LAST:event_dashMouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        addDash add = new addDash();
        mainbg.add(add); 
        add.setVisible(true);
        add.setForeground(new Color(0,51,102));
        try {
            add.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            System.out.println("Exception: " + e.getMessage());
        } 

    }//GEN-LAST:event_addMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        updateDash up = new updateDash();
        mainbg.add(up).setVisible(true);

    }//GEN-LAST:event_updateMouseClicked

    private void archiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archiveMouseClicked
        delDash del = new delDash();
        mainbg.add(del).setVisible(true);

    }//GEN-LAST:event_archiveMouseClicked

    private void settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseClicked
        infoDetails inf = new infoDetails();
        inf.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_settingsMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            Loginfrm log = new Loginfrm();
            log.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_logoutMouseClicked

    private void dashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseEntered
        dash.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_dashMouseEntered

    private void dashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseExited
        dash.setForeground(Color.white); 
    }//GEN-LAST:event_dashMouseExited

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        logout.setForeground(Color.red);
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        logout.setForeground(Color.white);
    }//GEN-LAST:event_logoutMouseExited

    private void reportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseClicked
        generateReports rpt = new generateReports();
        mainbg.add(rpt).setVisible(true);
        
    }//GEN-LAST:event_reportsMouseClicked

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_settingsActionPerformed

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        add.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        add.setForeground(Color.white);
    }//GEN-LAST:event_addMouseExited

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        update.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        update.setForeground(Color.white);
    }//GEN-LAST:event_updateMouseExited

    private void archiveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archiveMouseEntered
        archive.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_archiveMouseEntered

    private void archiveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archiveMouseExited
        archive.setForeground(Color.white);
    }//GEN-LAST:event_archiveMouseExited

    private void reportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseEntered
        reports.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_reportsMouseEntered

    private void reportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseExited
        reports.setForeground(Color.white);
    }//GEN-LAST:event_reportsMouseExited

    private void settingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseEntered
        settings.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_settingsMouseEntered

    private void settingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseExited
       settings.setForeground(Color.white);
    }//GEN-LAST:event_settingsMouseExited

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new adminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel active;
    private javax.swing.JButton add;
    private javax.swing.JButton archive;
    private javax.swing.JButton dash;
    public javax.swing.JLabel date;
    private javax.swing.ButtonGroup gd;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logout;
    private javax.swing.JDesktopPane mainbg;
    public javax.swing.JLabel name;
    private javax.swing.JPanel navbar;
    private javax.swing.JPanel navbar1;
    private javax.swing.JLabel pending;
    private javax.swing.JLabel pic;
    private javax.swing.JButton reports;
    private javax.swing.JButton settings;
    public javax.swing.JLabel time;
    private javax.swing.JPanel titlebg;
    private javax.swing.JButton update;
    private javax.swing.JLabel users;
    // End of variables declaration//GEN-END:variables
}
