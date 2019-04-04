
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

 
public class DatabaseConnect {
 
        
        Connection conn1 = null;
        Statement st = null;
        
        public Connection connectDB() {
        try {
            
            String url1 = "jdbc:mysql://localhost:3307/contact?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "root";
 
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database");
                
            }
            
        } catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null, "Error in connectivity");
             }
		return conn1;
       
        }
        
    }
