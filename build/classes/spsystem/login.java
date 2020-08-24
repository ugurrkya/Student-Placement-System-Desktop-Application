package spsystem;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Uğur
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminbutton = new javax.swing.JButton();
        studentbutton = new javax.swing.JButton();
        studentid = new javax.swing.JTextField();
        studentpass = new javax.swing.JPasswordField();
        adminid = new javax.swing.JTextField();
        adminpass = new javax.swing.JPasswordField();
        studentwarning = new javax.swing.JLabel();
        adminwarning = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Placement System");
        setMinimumSize(new java.awt.Dimension(1366, 768));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(null);

        adminbutton.setBackground(new java.awt.Color(255, 51, 51));
        adminbutton.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        adminbutton.setForeground(new java.awt.Color(255, 255, 255));
        adminbutton.setText("Login as Admin");
        adminbutton.setMaximumSize(new java.awt.Dimension(133, 25));
        adminbutton.setMinimumSize(new java.awt.Dimension(133, 25));
        adminbutton.setPreferredSize(new java.awt.Dimension(133, 25));
        adminbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(adminbutton);
        adminbutton.setBounds(1180, 80, 140, 25);

        studentbutton.setBackground(new java.awt.Color(255, 51, 51));
        studentbutton.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        studentbutton.setForeground(new java.awt.Color(255, 255, 255));
        studentbutton.setText("Login as Student");
        studentbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        studentbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(studentbutton);
        studentbutton.setBounds(50, 80, 140, 25);

        studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentidActionPerformed(evt);
            }
        });
        getContentPane().add(studentid);
        studentid.setBounds(90, 15, 100, 25);
        studentid.getAccessibleContext().setAccessibleName("jTextField1");

        studentpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentpassActionPerformed(evt);
            }
        });
        getContentPane().add(studentpass);
        studentpass.setBounds(90, 45, 100, 25);

        adminid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminidActionPerformed(evt);
            }
        });
        getContentPane().add(adminid);
        adminid.setBounds(1200, 15, 100, 25);
        adminid.getAccessibleContext().setAccessibleName("");

        adminpass.setToolTipText("");
        getContentPane().add(adminpass);
        adminpass.setBounds(1200, 45, 100, 25);

        studentwarning.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        studentwarning.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(studentwarning);
        studentwarning.setBounds(20, 130, 330, 30);

        adminwarning.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        adminwarning.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(adminwarning);
        adminwarning.setBounds(1020, 130, 330, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setText("Password:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1130, 50, 59, 17);

        jLabel2.setBackground(new java.awt.Color(102, 102, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setText("ID:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 20, 20, 17);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setText("ID:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1170, 20, 20, 17);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 50, 59, 17);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spsystem/school.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 700, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        background.setSize(this.getSize());
    }//GEN-LAST:event_formComponentResized
 
    private void studentbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentbuttonActionPerformed
        
            
          

String studentno = studentid.getText();
String studentpassword = studentpass.getText();

 Connection conn;
        PreparedStatement ps;

try
                        {
                            
                           
                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/placement?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
                            
                            
                            ps = conn.prepareStatement("SELECT `ID`, `password` FROM  `student_info` WHERE `ID` = ? AND `password` = ?");
                            ps.setString(1, studentno);
            ps.setString(2, String.valueOf(studentpassword));
            ResultSet result = ps.executeQuery();
                           
                       if(result.next()){
                         
                                   
                            
 
            JOptionPane.showMessageDialog(null, "You are redirected to student page, please wait...");
            
         studentwarning.setVisible(false);
         adminwarning.setVisible(false);
         new student (this).setVisible(false);
         new student(studentno).setVisible(true);
         
         dispose();
         
         
         
      }else {
         JOptionPane.showMessageDialog(null, "Something is wrong.");
         studentwarning.setText("Password or ID is wrong, please try again.");
         studentwarning.setVisible(true);
         adminwarning.setVisible(false);
                                    
 
if ("".equals(studentpassword) && "".equals(studentno)) {
studentwarning.setText("Please, enter the ID and the password!");
studentid.requestFocusInWindow();



} else if ("".equals(studentno)) {
studentwarning.setText("Please, enter the ID!");
studentid.requestFocusInWindow();



} else if ("".equals(studentpassword)) {
studentwarning.setText("Please, enter the password!");
studentpass.requestFocusInWindow();

} }
                         } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
                        

    }//GEN-LAST:event_studentbuttonActionPerformed

    private void studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentidActionPerformed

    private void adminbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminbuttonActionPerformed
        String adminno = adminid.getText();
String adminpassword = adminpass.getText();
    if (adminno.equalsIgnoreCase("ugur") && adminpassword.equalsIgnoreCase("1905")) {
         JOptionPane.showMessageDialog(null, "You are redirected to admin page, please wait...");
         adminwarning.setVisible(false);
         studentwarning.setVisible(false);
          
          new admin (this).setVisible(true);
            dispose();
      } else {
         JOptionPane.showMessageDialog(null, "Something is wrong.");
         adminwarning.setText("Password or ID is wrong, please try again.");
         adminwarning.setVisible(true);
          studentwarning.setVisible(false);

if ("".equals(adminpassword) && "".equals(adminno)) {
adminwarning.setText("Please, enter the ID and the password!");
adminid.requestFocusInWindow();



} else if ("".equals(adminno)) {
adminwarning.setText("Please, enter the ID!");
adminid.requestFocusInWindow();



} else if ("".equals(adminpassword)) {
adminwarning.setText("Please, enter the password!");
adminpass.requestFocusInWindow();

} 
    }//GEN-LAST:event_adminbuttonActionPerformed
    }
    private void adminidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminidActionPerformed

    private void studentpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentpassActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminbutton;
    private javax.swing.JTextField adminid;
    private javax.swing.JPasswordField adminpass;
    private javax.swing.JLabel adminwarning;
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton studentbutton;
    private javax.swing.JTextField studentid;
    private javax.swing.JPasswordField studentpass;
    private javax.swing.JLabel studentwarning;
    // End of variables declaration//GEN-END:variables
}
