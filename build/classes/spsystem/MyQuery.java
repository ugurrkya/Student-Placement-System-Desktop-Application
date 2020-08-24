package spsystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Uğur
 */
public class MyQuery {
    
   public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/placement?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
            
        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public ArrayList<City> getData(String Name){

   ArrayList<City> list = new ArrayList<>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   
   try {
   st = con.createStatement();
   rs = st.executeQuery("SELECT  `city_ID`, `city_name` FROM `city` WHERE `city_name` = "+ Name);
   
   City p;
   while(rs.next()){
   p = new City(
   rs.getInt("city_ID"),
   rs.getString("city_name")
   );
   list.add(p);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return list;
   } }