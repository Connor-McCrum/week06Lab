/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author john
 */
public class DBoperations {
    
    public String getUsernames() {
        String usernames = new String();
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            
            String sql = "select * from listitems;";
            
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                usernames = usernames + rs.getString(1) + ",";
            }
            
            rs.close();
            st.close();
            
            cp.freeConnection(conn); //REMEMBER TO CLOSE THE CONNECTION/RETURN IT TO THE POOL
            
        } catch (SQLException ex) {
            Logger.getLogger(DBoperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return usernames;
    }
    
}
