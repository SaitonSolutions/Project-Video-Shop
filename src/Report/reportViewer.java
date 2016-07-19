/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import DB.DB;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.view.*;

/**
 *
 * @author Gomez
 */
public class reportViewer extends JFrame {

    private DB star;//db connection

    public reportViewer(String fileName) {
        this(fileName, null);
        star = new DB();
    }

    public reportViewer(String fileName, HashMap parameter) {

        super("View Report");
        Connection dbConn = star.conect();

        try {
            if (dbConn == null) {
                JOptionPane.showMessageDialog(null, "Databse connection failiure. \n Please contact the administrator.");

            } else {
                JasperPrint print = JasperFillManager.fillReport(fileName, parameter, dbConn);
                JRViewer viewer = new JRViewer(print);
                Container c = getContentPane();
                c.add(viewer);
            }
        } catch (JRException jr) {
            jr.printStackTrace();
            JOptionPane.showMessageDialog(null, "RpGenerator EX :" + jr);
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "RpGenerator EX :" + e1);
        }
        setBounds(80, 30, 1200, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
