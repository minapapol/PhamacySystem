/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Napapol
 */
public class DatabaseTester {
    
    private static Connection conn = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       try
       {

           String url = "jdbc:mysql://localhost:3306/phamacy";
           Class.forName ("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection (url,"root","root");
           System.out.println ("Database connection established");
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
       if (conn != null)
       {
           try{
                statement = conn.createStatement();
                
                preparedStatement = conn.prepareStatement("insert into phamacy.history "
                        + "values (?,?,?,?,?)"); 
                
                preparedStatement.setInt(1,2);
                preparedStatement.setString(2,"xxxxx");
                preparedStatement.setDate(3, new java.sql.Date(2009, 12, 11));
                preparedStatement.setInt(4,5);
                preparedStatement.setFloat(5,5.5f);
                
                preparedStatement.executeUpdate();
                
                preparedStatement = conn.prepareStatement("SELECT * from history");
                resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                        int no = resultSet.getInt("การขายที่");
                        String barcode = resultSet.getString("บาร์โค๊ด");
                        Date date = resultSet.getDate("วันเวลาที่ขาย");
                        int amount = resultSet.getInt("จำนวน");
                        float total = resultSet.getFloat("รวม");
                        System.out.println("No: " + no);
                        System.out.println("บาร์โค๊ด: " + barcode);
                        System.out.println("วันที่ขาย: " + date);
                        System.out.println("จำนวน: " + amount);
                        System.out.println("เป็นเงิน: " + total);
                }
                
           } catch (Exception e){
                e.printStackTrace();               
           }
           
           
              
        try
        {
            conn.close ();
            System.out.println ("Database connection terminated");
        }
        catch (Exception e) { /* ignore close errors */ }
        }
    }
    
    
    
}
