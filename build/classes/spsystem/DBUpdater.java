/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spsystem;

/**
 *
 * @author Uğur
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class DBUpdater {
   
   
    //RETRIEVE DATA
    public DefaultTableModel getData() {
        //ADD COLUMNS TO TABLE MODEL
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("ID");
        dm.addColumn("Full Name");
        dm.addColumn("Age");
        dm.addColumn("Chosen City");
        dm.addColumn("Chosen County");
        dm.addColumn("Chosen School");
        dm.addColumn("Confirm");
        
        //SQL STATEMENT
        
        String cs="Pending Approval";
        String sql = "SELECT * FROM sending_report WHERE confirm='" + cs + "'";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/placement?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
            //PREPARED STMT
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            //LOOP THRU GETTING ALL VALUES
             
            while (rs.next()) {
                //GET VALUES
                String id = rs.getString(1);
                String fullname = rs.getString(2);
                String aged = rs.getString(3);
                String cityname = rs.getString(4);
                String countyname = rs.getString(5);
                String schoolname = rs.getString(6);
                String confirmst = rs.getString(7);
              
                
               
                dm.addRow(new String[]{id, fullname, aged, cityname, countyname, schoolname, confirmst});
                
              
              
            } 
            
             int i=dm.getRowCount();
            if (i<1)
               {
                   JOptionPane.showMessageDialog(null, "THERE IS NO NEW REPORT WHICH IS CONFIRM ON, TRY AGAIN LATER.");
               }else
               {
                   JOptionPane.showMessageDialog(null, "There are some records.");
               }
            return dm;
            
         
            
        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return null;
        
    }
    //UPDATE DATA
    public Boolean update(String id, String csituation) {
        //SQL STMT
        csituation="Approved";
        String sql = "UPDATE sending_report SET Confirm='" + csituation + "' WHERE ID='" + id + "'";
        try {
            //GET COONECTION
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/placement?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
            //STATEMENT
            Statement s = con.prepareStatement(sql);
            //EXECUTE
            s.execute(sql);
            return true;
        } catch (SQLException ex) {
           Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //DELETE DATA
    public Boolean delete(String id)
    {
        //SQL STMT
        String sql="DELETE FROM sending_report WHERE ID ='"+id+"'";
        
        
        try
        {
            //GET COONECTION
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/placement?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
            
            //STATEMENT
            Statement s=con.prepareStatement(sql);
            
            //EXECUTE
            s.execute(sql);
            
            return true;
            
        }catch(SQLException ex)
        {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
    
}
