
package pharmacistDashboard;

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

public class pharmadb extends javax.swing.JFrame {

    
    public pharmadb() {
        initComponents();
        updateTimeAndDate();
        updateTotal();
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
    
    private void updateTotal() {
         try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medico", "root", "");

            String queryPending = "SELECT COUNT(*) FROM prescriptions WHERE p_status = 'Pending'";
            PreparedStatement pstPending = conn.prepareStatement(queryPending);
            ResultSet rsPending = pstPending.executeQuery();
            if (rsPending.next()) {
                int pendingOrders = rsPending.getInt(1);
                pen.setText(Integer.toString(pendingOrders));
            }

            String queryProcess = "SELECT COUNT(*) FROM prescriptions WHERE p_status = 'In Process'";
            PreparedStatement pstProcess = conn.prepareStatement(queryProcess);
            ResultSet rsProcess = pstProcess.executeQuery();
            if (rsProcess.next()) {
                int processOrders = rsProcess.getInt(1);
                process.setText(Integer.toString(processOrders));
            }

            String queryForPickup = "SELECT COUNT(*) FROM prescriptions WHERE p_status = 'Ready for pick up'";
            PreparedStatement pstForPickup = conn.prepareStatement(queryForPickup);
            ResultSet rsForPickup = pstForPickup.executeQuery();
            if (rsForPickup.next()) {
                int forPickupOrders = rsForPickup.getInt(1);
                forpickup.setText(Integer.toString(forPickupOrders));
            }

            String queryReceived = "SELECT COUNT(*) FROM prescriptions WHERE p_status = 'Received'";
            PreparedStatement pstReceived = conn.prepareStatement(queryReceived);
            ResultSet rsReceived = pstReceived.executeQuery();
            if (rsReceived.next()) {
                int receivedOrders = rsReceived.getInt(1);
                completed.setText(Integer.toString(receivedOrders));
            }
            rsPending.close();
            rsProcess.close();
            rsForPickup.close();
            rsReceived.close();
            pstPending.close();
            pstProcess.close();
            pstForPickup.close();
            pstReceived.close();
            conn.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pharmadb = new javax.swing.JPanel();
        pic = new javax.swing.JLabel();
        nursenm = new javax.swing.JLabel();
        navbar = new javax.swing.JPanel();
        dash = new javax.swing.JButton();
        pending = new javax.swing.JButton();
        ready = new javax.swing.JButton();
        inprocess = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        received = new javax.swing.JButton();
        navbar1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        mainbg = new javax.swing.JDesktopPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        process = new javax.swing.JLabel();
        completed = new javax.swing.JLabel();
        pen = new javax.swing.JLabel();
        forpickup = new javax.swing.JLabel();
        gradient = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        pharmadb.setLayout(null);

        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-test-account-48.png"))); // NOI18N
        pharmadb.add(pic);
        pic.setBounds(50, 90, 50, 48);

        nursenm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nursenm.setForeground(new java.awt.Color(255, 255, 255));
        pharmadb.add(nursenm);
        nursenm.setBounds(30, 140, 90, 20);

        navbar.setBackground(new java.awt.Color(0, 51, 102));
        navbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        dash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashActionPerformed(evt);
            }
        });
        navbar.add(dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 150, 40));

        pending.setBackground(new java.awt.Color(0, 51, 102));
        pending.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pending.setForeground(new java.awt.Color(255, 255, 255));
        pending.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new.png"))); // NOI18N
        pending.setText("NEW ORDERS");
        pending.setBorder(null);
        pending.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pendingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pendingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pendingMouseExited(evt);
            }
        });
        pending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingActionPerformed(evt);
            }
        });
        navbar.add(pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 150, 40));

        ready.setBackground(new java.awt.Color(0, 51, 102));
        ready.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ready.setForeground(new java.awt.Color(255, 255, 255));
        ready.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ready.png"))); // NOI18N
        ready.setText("READY FOR PICK UP");
        ready.setBorder(null);
        ready.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                readyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                readyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                readyMouseExited(evt);
            }
        });
        ready.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readyActionPerformed(evt);
            }
        });
        navbar.add(ready, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 150, 40));

        inprocess.setBackground(new java.awt.Color(0, 51, 102));
        inprocess.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        inprocess.setForeground(new java.awt.Color(255, 255, 255));
        inprocess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/process.png"))); // NOI18N
        inprocess.setText("IN PROCESS");
        inprocess.setBorder(null);
        inprocess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inprocessMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inprocessMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inprocessMouseExited(evt);
            }
        });
        inprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inprocessActionPerformed(evt);
            }
        });
        navbar.add(inprocess, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 150, 40));

        settings.setBackground(new java.awt.Color(0, 51, 102));
        settings.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        settings.setForeground(new java.awt.Color(255, 255, 255));
        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/SETTINGS.png"))); // NOI18N
        settings.setText("  SETTINGS");
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
        navbar.add(settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 150, 40));

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
        navbar.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 150, 40));

        received.setBackground(new java.awt.Color(0, 51, 102));
        received.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        received.setForeground(new java.awt.Color(255, 255, 255));
        received.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check.png"))); // NOI18N
        received.setText("  RECEIVED");
        received.setBorder(null);
        received.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receivedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                receivedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                receivedMouseExited(evt);
            }
        });
        received.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivedActionPerformed(evt);
            }
        });
        navbar.add(received, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 150, 40));

        pharmadb.add(navbar);
        navbar.setBounds(0, 80, 150, 470);

        navbar1.setBackground(new java.awt.Color(0, 51, 102));
        navbar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        navbar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/LoGo (1)_1.png"))); // NOI18N
        navbar1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 500));

        pharmadb.add(navbar1);
        navbar1.setBounds(0, 0, 150, 80);

        header.setBackground(new java.awt.Color(0, 51, 102));
        header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        time.setForeground(new java.awt.Color(255, 255, 255));

        date.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(633, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pharmadb.add(header);
        header.setBounds(150, 0, 750, 80);

        mainbg.setBackground(new java.awt.Color(204, 204, 255));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        jLabel7.setText("Welcome Back!");
        mainbg.add(jLabel7);
        jLabel7.setBounds(70, 60, 320, 58);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("New orders are coming!");
        mainbg.add(jLabel8);
        jLabel8.setBounds(70, 110, 368, 20);

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("NEW ORDERS");
        mainbg.add(jLabel12);
        jLabel12.setBounds(230, 200, 120, 15);

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("IN PROCESS");
        mainbg.add(jLabel13);
        jLabel13.setBounds(420, 200, 125, 15);

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PICKUP");
        mainbg.add(jLabel14);
        jLabel14.setBounds(260, 330, 90, 15);

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("RECEIVED");
        mainbg.add(jLabel15);
        jLabel15.setBounds(420, 320, 125, 15);

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("READY FOR ");
        mainbg.add(jLabel16);
        jLabel16.setBounds(260, 310, 90, 20);

        process.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        process.setForeground(new java.awt.Color(255, 255, 255));
        process.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainbg.add(process);
        process.setBounds(430, 220, 70, 50);

        completed.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        completed.setForeground(new java.awt.Color(255, 255, 255));
        completed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainbg.add(completed);
        completed.setBounds(430, 340, 70, 50);

        pen.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        pen.setForeground(new java.awt.Color(255, 255, 255));
        pen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainbg.add(pen);
        pen.setBounds(250, 220, 70, 50);

        forpickup.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        forpickup.setForeground(new java.awt.Color(255, 255, 255));
        forpickup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainbg.add(forpickup);
        forpickup.setBounds(250, 340, 70, 50);

        gradient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pharmagradient.png"))); // NOI18N
        mainbg.add(gradient);
        gradient.setBounds(0, 111, 750, 310);

        pharmadb.add(mainbg);
        mainbg.setBounds(150, 80, 750, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pharmadb, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pharmadb, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(915, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session ses = Session.getInstance();
        nursenm.setText(ses.getName());
        
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
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_formWindowActivated

    private void dashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashActionPerformed

    private void pendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pendingActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_settingsActionPerformed

    private void readyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_readyActionPerformed

    private void inprocessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inprocessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inprocessActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutActionPerformed

    private void dashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseClicked
        pharmadb db = new pharmadb();
        db.setVisible(true);
    }//GEN-LAST:event_dashMouseClicked

    private void pendingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingMouseClicked
        newOrders nw = new newOrders();
        mainbg.add(nw).setVisible(true);

    }//GEN-LAST:event_pendingMouseClicked

    private void readyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readyMouseClicked
        pickUp pk = new pickUp();
        mainbg.add(pk).setVisible(true);

    }//GEN-LAST:event_readyMouseClicked

    private void inprocessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inprocessMouseClicked
        inProcess pro = new inProcess();
        mainbg.add(pro).setVisible(true);

    }//GEN-LAST:event_inprocessMouseClicked

    private void settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseClicked
        profileDetails prd = new profileDetails();
        prd.setVisible(true);
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

    private void receivedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receivedMouseClicked
        receivedOrders rc = new receivedOrders();
        mainbg.add(rc).setVisible(true);

    }//GEN-LAST:event_receivedMouseClicked

    private void receivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receivedActionPerformed

    private void dashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseEntered
        dash.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_dashMouseEntered

    private void dashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseExited
        dash.setForeground(Color.white);
    }//GEN-LAST:event_dashMouseExited

    private void pendingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingMouseEntered
        pending.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_pendingMouseEntered

    private void pendingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingMouseExited
        pending.setForeground(Color.white);
    }//GEN-LAST:event_pendingMouseExited

    private void inprocessMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inprocessMouseEntered
        inprocess.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_inprocessMouseEntered

    private void inprocessMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inprocessMouseExited
        inprocess.setForeground(Color.white);
    }//GEN-LAST:event_inprocessMouseExited

    private void readyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readyMouseEntered
        ready.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_readyMouseEntered

    private void readyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readyMouseExited
        ready.setForeground(Color.white);
    }//GEN-LAST:event_readyMouseExited

    private void receivedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receivedMouseEntered
        received.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_receivedMouseEntered

    private void receivedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receivedMouseExited
        received.setForeground(Color.white);
    }//GEN-LAST:event_receivedMouseExited

    private void settingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseEntered
        settings.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_settingsMouseEntered

    private void settingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseExited
        settings.setForeground(Color.white);
    }//GEN-LAST:event_settingsMouseExited

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        logout.setForeground(Color.red);
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        logout.setForeground(Color.white);
    }//GEN-LAST:event_logoutMouseExited

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new pharmadb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel completed;
    private javax.swing.JButton dash;
    public javax.swing.JLabel date;
    private javax.swing.JLabel forpickup;
    private javax.swing.JLabel gradient;
    private javax.swing.JPanel header;
    private javax.swing.JButton inprocess;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logout;
    private javax.swing.JDesktopPane mainbg;
    private javax.swing.JPanel navbar;
    private javax.swing.JPanel navbar1;
    private javax.swing.JLabel nursenm;
    private javax.swing.JLabel pen;
    private javax.swing.JButton pending;
    private javax.swing.JPanel pharmadb;
    private javax.swing.JLabel pic;
    private javax.swing.JLabel process;
    private javax.swing.JButton ready;
    private javax.swing.JButton received;
    private javax.swing.JButton settings;
    public javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
