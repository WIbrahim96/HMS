
package hotel.managment.system;

import java.sql.*;

public class Conn 
{
    Connection c;
    Statement s;
    
    public Connection getConnection() {
        return c;
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        return c.prepareStatement(query);
    }
    
    Conn() 
    {
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","MrFantasy", "HJSN18090830");
        s = c.createStatement();
        
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
