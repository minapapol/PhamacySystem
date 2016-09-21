/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Napapol
 */
public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;
  
  public void readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/phamacy?"
              + "user=root&password=root");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
          .executeQuery("select * from phamacy.sell_histories");
      writeResultSet(resultSet);

      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("insert into phamacy.sell_histories (detail_id, selling_time, amount, total) values (?, ? , ?, ?)");
      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
      // Parameters start with 1
      preparedStatement.setInt(1, 1);
      preparedStatement.setDate(2, new java.sql.Date(2009, 12, 11));
      preparedStatement.setInt(3, 1);
      preparedStatement.setInt(4, 1);
      preparedStatement.executeUpdate();

      preparedStatement = connect
          .prepareStatement("SELECT * from phamacy.sell_histories");
      resultSet = preparedStatement.executeQuery();
      writeResultSet(resultSet);

      // Remove again the insert comment
      preparedStatement = connect
        .prepareStatement("delete from phamacy.sell_histories where selling_time= ? ; ");
      preparedStatement.setDate(1, new java.sql.Date(2009, 12, 11));
      preparedStatement.executeUpdate();
      
      resultSet = statement
          .executeQuery("select * from phamacy.sell_histories");
      writeMetaData(resultSet);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      int detail_id = resultSet.getInt("detail_id");
      Date date = resultSet.getDate("selling_time");
      int amount = resultSet.getInt("amount");
      int total = resultSet.getInt("total");
      System.out.println("Detail_id: " + detail_id);
      System.out.println("Selling_Date: " + date);
      System.out.println("Amout: " + amount);
      System.out.println("Total: " + total);
    }
  }

  public void insert_medicines(String barcode, String name){
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/phamacy?"
              + "user=root&password=root");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("insert into phamacy.medicines "
                  + "(barcode, medicine_name) "
                  + "values "
                  + "(?, ? )");
      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
      // Parameters start with 1
      preparedStatement.setString(1, barcode);
      preparedStatement.setString(2, name);
      preparedStatement.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }
  public ArrayList<String[]> list_medicines(){ 
    ArrayList<String[]> medicines = new ArrayList<String[]>();
    try {
        Class.forName("com.mysql.jdbc.Driver");
          // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

          // Statements allow to issue SQL queries to the database
          statement = connect.createStatement();
        resultSet = statement
           .executeQuery("select * from phamacy.medicines");
        System.out.println("|   Medicines");
        System.out.println("|   No.---Barcode---Medicines name");
        int i = 1;
        while (resultSet.next()) {
            String[] temp = new String[2];
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String barcode = resultSet.getString("barcode");
            String name = resultSet.getString("medicine_name");
            System.out.print("|   " + i);
            temp[0] = barcode;
            System.out.print("---" + temp[0]);
            temp[1] = name;
            System.out.println("---" + temp[1]);
            
            medicines.add(temp);
            i++;
        }
          
    } catch (Exception e){
        e.printStackTrace();
    } finally {
      close();
    }

    return medicines;
  }
  public void delete_medicines(String barcode){
    try {
        Class.forName("com.mysql.jdbc.Driver");
          // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        
        // Remove again the insert comment
        preparedStatement = connect
          .prepareStatement("delete from phamacy.medicines where barcode = ? ; ");
        preparedStatement.setString(1, barcode);
        preparedStatement.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        close();
    }
  }
  
  public void insert_medicine_details(String barcode, String medicine_code, String company_name, String lot_no, 
          int back_stock, float buying_price, float selling_price, int amount, String unit,
          java.sql.Date buying_date, java.sql.Date initailize_date, java.sql.Date expired_date){
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/phamacy?"
              + "user=root&password=root");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("insert into phamacy.medicine_details "
                  + "(barcode, medicine_code, company_name, lot_no, back_stock, front_stock, buying_date, buying_price, selling_price, amount, unit, initailize_date, expired_date) "
                  + "values "
                  + "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
      // Parameters start with 1
      preparedStatement.setString(1, barcode);
      preparedStatement.setString(2, medicine_code);
      preparedStatement.setString(3, company_name);
      preparedStatement.setString(4, lot_no);
      preparedStatement.setInt(5, back_stock);
      preparedStatement.setInt(6, 0);
      preparedStatement.setDate(7, buying_date);
      preparedStatement.setFloat(8, buying_price);
      preparedStatement.setFloat(9, selling_price);
      preparedStatement.setInt(10, amount);
      preparedStatement.setString(11, unit);
      preparedStatement.setDate(12, initailize_date);
      preparedStatement.setDate(13, expired_date);
      preparedStatement.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }
  
  public ArrayList<String[]> list_medicine_details(){
    ArrayList<String[]> medicine_details = new ArrayList<String[]>();
    try {
        Class.forName("com.mysql.jdbc.Driver");
          // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

          // Statements allow to issue SQL queries to the database
          statement = connect.createStatement();
        resultSet = statement
           .executeQuery("select * from phamacy.medicines");
        System.out.println("|   Medicines Details");
        System.out.println("|   No.---barcode---medicine_code---company_name---lot_no---back_stock---front_stock---buying_date---buying_price---selling_price---amount---unit---initialize_date---expired_date");
        int i = 1;
        while (resultSet.next()) {
            String[] temp = new String[14];
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int id = resultSet.getInt("id");
            String barcode = resultSet.getString("barcode");
            String medicine_code = resultSet.getString("medicine_code");
            String company_name = resultSet.getString("company_name");
            String lot_no = resultSet.getString("lot_no");
            int back_stock = resultSet.getInt("back_stock");
            int front_stock = resultSet.getInt("front_stock");
            Date buying_date = resultSet.getDate("buying_date");
            float buying_price = resultSet.getFloat("buying_price");
            float selling_price = resultSet.getFloat("selling_price");
            int amount = resultSet.getInt("amount");
            String unit = resultSet.getString("unit");
            Date initialize_date = resultSet.getDate("initialize_date");
            Date expired_date = resultSet.getDate("expired_date");
            temp[0] = id+"";
            System.out.print("|   " + temp[0]);
            temp[1] = barcode;
            System.out.println("---" + temp[1]);
            temp[2] = medicine_code;
            System.out.print("---" + temp[2]);
            temp[3] = company_name;
            System.out.println("---" + temp[3]);
            temp[4] = lot_no;
            System.out.print("---" + temp[4]);
            temp[5] = back_stock+"";
            System.out.println("---" + temp[5]);
            temp[6] = front_stock+"";
            System.out.print("---" + temp[6]);
            temp[7] = buying_date+"";
            System.out.println("---" + temp[7]);
            temp[8] = buying_price+"";
            System.out.print("---" + temp[8]);
            temp[9] = selling_price+"";
            System.out.println("---" + temp[9]);
            temp[10] = amount+"";
            System.out.print("---" + temp[10]);
            temp[11] = unit;
            System.out.println("---" + temp[11]);
            temp[12] = initialize_date+"";
            System.out.println("---" + temp[12]);
            temp[13] = expired_date+"";
            System.out.println("---" + temp[13]);
   
            medicine_details.add(temp);
            i++;
        }
          
    } catch (Exception e){
        e.printStackTrace();
    } finally {
      close();
    }

    return medicine_details;
  }
  
  public void delete_medicine_details(int id){
    try {
        Class.forName("com.mysql.jdbc.Driver");
          // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        
        // Remove again the insert comment
        preparedStatement = connect
          .prepareStatement("delete from phamacy.medicine_details where id = ? ; ");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        close();
    }
  }
  
  public void insert_sell_histories(int detail_id, java.sql.Date selling_date, int amount, float total){
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/phamacy?"
              + "user=root&password=root");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("insert into phamacy.sell_histories "
                  + "(detail_id, selling_date, amount, total) "
                  + "values "
                  + "( ?, ?, ?, ? )");
      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
      // Parameters start with 1
      preparedStatement.setInt(1, detail_id);
      preparedStatement.setDate(2, selling_date);
      preparedStatement.setInt(3, amount);
      preparedStatement.setFloat(4, total);
      preparedStatement.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }
  public ArrayList<String[]> list_sell_histories(){ 
    ArrayList<String[]> histories = new ArrayList<String[]>();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        resultSet = statement
           .executeQuery("select * from phamacy.sell_histories");
        System.out.println("|   Buying Histories");
        System.out.println("|   No.---detail_id---selling_date---amount---total");
        int i = 1;
        while (resultSet.next()) {
            String[] temp = new String[5];
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int id = resultSet.getInt("id");
            int detail_id = resultSet.getInt("detail_id");
            Date buying_date = resultSet.getDate("selling_date");
            int amount= resultSet.getInt("amount");
            float total = resultSet.getFloat("total");
                
            temp[0] = id + "";
            System.out.print("---" + temp[0]);
            temp[1] = detail_id + "";
            System.out.println("---" + temp[1]);
            temp[2] = buying_date + "";
            System.out.print("---" + temp[0]);
            temp[3] = amount + "" ;
            System.out.println("---" + temp[1]);
            temp[4] = total + "";
            System.out.print("---" + temp[0]);

            histories.add(temp);
            i++;
        }

    } catch (Exception e){
        e.printStackTrace();
    } finally {
        close();
    }
      
    return histories;
    
  }
  
  public void delete_sell_histories(int id){
     try {
        Class.forName("com.mysql.jdbc.Driver");
          // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        
        // Remove again the insert comment
        preparedStatement = connect
          .prepareStatement("delete from phamacy.sell_histories where id = ? ; ");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        close();
    }
  }
  
  public void insert_buy_histories(int detail_id, java.sql.Date buying_date, int amount, float total){
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/phamacy?"
              + "user=root&password=root");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("insert into phamacy.sell_histories "
                  + "(detail_id, selling_date, amount, total) "
                  + "values "
                  + "( ?, ?, ?, ? )");
      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
      // Parameters start with 1
      preparedStatement.setInt(1, detail_id);
      preparedStatement.setDate(2, buying_date);
      preparedStatement.setInt(3, amount);
      preparedStatement.setFloat(4, total);
      preparedStatement.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }
  
  public ArrayList<String[]> list_buy_histories(){
    ArrayList<String[]> histories = new ArrayList<String[]>();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        resultSet = statement
           .executeQuery("select * from phamacy.buy_histories");
        System.out.println("|   Buying Histories");
        System.out.println("|   No.---detail_id---buying_date---amount---total");
        int i = 1;
        while (resultSet.next()) {
            String[] temp = new String[5];
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int id = resultSet.getInt("id");
            int detail_id = resultSet.getInt("detail_id");
            Date buying_date = resultSet.getDate("buying_date");
            int amount= resultSet.getInt("amount");
            float total = resultSet.getFloat("total");
                
            temp[0] = id + "";
            System.out.print("---" + temp[0]);
            temp[1] = detail_id + "";
            System.out.println("---" + temp[1]);
            temp[2] = buying_date + "";
            System.out.print("---" + temp[0]);
            temp[3] = amount + "" ;
            System.out.println("---" + temp[1]);
            temp[4] = total + "";
            System.out.print("---" + temp[0]);

            histories.add(temp);
            i++;
        }

    } catch (Exception e){
        e.printStackTrace();
    } finally {
        close();
    }
      
    return histories;
  }
  
  public void delete_buy_histories(int id){
     try {
        Class.forName("com.mysql.jdbc.Driver");
          // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        
        // Remove again the insert comment
        preparedStatement = connect
          .prepareStatement("delete from phamacy.buy_histories where id = ? ; ");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        close();
    }
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }
} 