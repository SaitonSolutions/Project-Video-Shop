/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DB {

    public static Connection con;

    public static Connection conect() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/video_rental"; //database name
            con = DriverManager.getConnection(url, "root", "1234"); //username + password
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DB Connection fail");
        }
        return con;
    }

    public static void close() {

        if (con.equals(null)) {
        } else {
            try {
                con.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "DB connection closing faild");
            }
        }
    }

    public static void CreateDB(String DbName) {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "1234");
            try {
                Statement st = (Statement) con.createStatement();

                st.executeUpdate("CREATE DATABASE " + DbName);
                System.out.println("1 row(s) affacted");
            } catch (SQLException s) {
                System.out.println("SQL statement is not executed!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DB Creating failed");
        }

    }
    
     public void con_close(Connection dbConn) {
        try {
            dbConn.close();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
    }

}
