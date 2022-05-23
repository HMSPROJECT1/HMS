
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aymen
 */
public class Connector {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ConnectDb();
    }

    /**
     *
     * @return
     */
    public static Connection ConnectDb() {
        Connection connection = null;
        String url = "jdbc:sqlserver://DESKTOP-TQN91H6\\SQLEXPRESS;DatabaseName=HMS;integratedSecurity=true;encrypt=false";
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return connection;
    }
    
}
