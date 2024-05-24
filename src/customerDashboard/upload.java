
package customerDashboard;

import config.Session;
import config.dbconfig;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class upload extends javax.swing.JInternalFrame {


    public upload() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
   
    }

    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public static String path;
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
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
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        picon1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        browse = new javax.swing.JPanel();
        upload = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        remove = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        picon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/uploadBG (3).png"))); // NOI18N
        jPanel1.add(picon1);
        picon1.setBounds(130, 150, 200, 480);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Browse Now");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(170, 270, 110, 30);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel1.setText("Upload Prescription");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 50, 230, 40);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Please upload image of valid prescription from your doctor.");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 100, 350, 15);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("NOTE : Always upload a clear version of your Prescription. ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 350, 350, 20);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText(" Make sure it has your doctor’s signature and/or stamp.");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 370, 330, 30);

        browse.setBackground(new java.awt.Color(204, 204, 255));
        browse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout browseLayout = new javax.swing.GroupLayout(browse);
        browse.setLayout(browseLayout);
        browseLayout.setHorizontalGroup(
            browseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        browseLayout.setVerticalGroup(
            browseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jPanel1.add(browse);
        browse.setBounds(130, 150, 190, 170);

        upload.setBackground(new java.awt.Color(102, 102, 255));
        upload.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        upload.setText("UPLOAD");
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });
        jPanel1.add(upload);
        upload.setBounds(460, 410, 100, 30);

        jPanel2.setLayout(null);
        jPanel2.add(image);
        image.setBounds(10, 10, 270, 340);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(420, 40, 290, 360);

        remove.setBackground(new java.awt.Color(102, 102, 255));
        remove.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        remove.setText("REMOVE");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove);
        remove.setBounds(580, 410, 100, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseMouseClicked
         JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
        try {
            selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath(); 
            destination = "src/userimages/" + selectedFile.getName();

            if (FileExistenceChecker(path) == 1) {
                JOptionPane.showMessageDialog(null, "File Already Exists. Please choose another file.");
                destination = "";
                path = "";
            } else {
                image.setIcon(ResizeImage(path, null, image));
                remove.setEnabled(true);
            }
        } catch (Exception ex) {
            System.out.println("File Error: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_browseMouseClicked

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
        Session ses = Session.getInstance();
        dbconfig dbc = new dbconfig();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        String currentDate = dateFormat.format(new java.util.Date());
        String currentTime = timeFormat.format(new java.util.Date());

        if (selectedFile == null) {
            JOptionPane.showMessageDialog(null, "No image selected!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!destination.isEmpty()) {
            if (dbc.insertData("INSERT INTO prescriptions (u_id, p_pic, p_status, date, time) VALUES ('" + ses.getId() + "', '" + destination + "', 'Pending', '" + currentDate + "', '" + currentTime + "')")) {
                try {
                    JOptionPane.showMessageDialog(null, "Prescription Uploaded Successfully!");
                    Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    image.setIcon(null);
                } catch (IOException ex) {
                    System.out.println("Insert Image Error: " + ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Connection Error!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No image selected!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_uploadActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        browse.setEnabled(true);
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_removeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel browse;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel picon1;
    public javax.swing.JButton remove;
    public javax.swing.JButton upload;
    // End of variables declaration//GEN-END:variables

}
