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

  public void insert_medicines(Medicine m){
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
                  + "(barcode, medicine_name, medicine_code, size, price, stock_type, medicine_type) "
                  + "values "
                  + "(?, ?, ?, ?, ?, ?, ? )");
      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
      // Parameters start with 1
      preparedStatement.setString(1, m.getBarcode());
      preparedStatement.setString(2, m.getName());
      preparedStatement.setString(3, m.getCode());
      preparedStatement.setString(4, m.getSize());
      preparedStatement.setFloat(5, m.getPrice());
      preparedStatement.setInt(6, m.getStockType());
      preparedStatement.setInt(7, m.getMedicineType());
      preparedStatement.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }
  
  public void update_medicine(String barcode, Medicine m){
      try {
        Class.forName("com.mysql.jdbc.Driver");
          // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

        // Update
        preparedStatement = connect
          .prepareStatement("update phamacy.medicines set "
                  + "barcode = ?, "
                  + "medicine_name = ?, "
                  + "medicine_code = ?, "
                  + "medicine_type = ?, "
                  + "size = ?, "
                  + "price = ?, "
                  + "stock_type = ? "
                  + "where barcode = ? ; ");

        preparedStatement.setString(1, m.getBarcode());
        preparedStatement.setString(2, m.getName());
        preparedStatement.setString(3, m.getCode());
        preparedStatement.setInt(4, m.getMedicineType());
        preparedStatement.setString(5, m.getSize());
        preparedStatement.setFloat(6, m.getPrice());
        preparedStatement.setInt(7, m.getStockType());
        preparedStatement.setString(8, barcode);
        preparedStatement.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        close();
    }
  }
  
  public ArrayList<String[]> list_medicines(){
    ArrayList<String[]> medicines = new ArrayList<>();
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
            String[] temp = new String[7];
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String barcode = resultSet.getString("barcode");
            String name = resultSet.getString("medicine_name");
            String code = resultSet.getString("medicine_code");
            String size = resultSet.getString("size");
            float price = resultSet.getFloat("price");
            int medicine_type = resultSet.getInt("medicine_type");
            int stock_type = resultSet.getInt("stock_type");
            System.out.print("|   " + i);
            temp[0] = barcode;
            System.out.print("---" + temp[0]);
            temp[1] = name;
            System.out.println("---" + temp[1]);
            temp[2] = code + "";
            System.out.println("---" + temp[2]);
            temp[3] = size + "";
            System.out.println("---" + temp[3]);
            temp[4] = price + "";
            System.out.println("---" + temp[4]);
            switch (stock_type) {
                case 0:
                    temp[5] = "ข้างบน";
                    break;
                case 1:
                    temp[5] = "ข้างล่าง";
                    break;
            }
            System.out.println("---" + temp[5]);
            
            switch (medicine_type) {
                case 0:
                    temp[6] = "ยาอันตราย";
                    break;
                case 1:
                    temp[6] = "ยาควบคุมพิเศษ";
                    break;
                case 2:
                    temp[6] = "ยาทั่วไป";
                    break;
                case 3:
                    temp[6] = "อื่นๆ";
                    break;
            }
            System.out.println("---" + temp[6]);

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
        
        
        // Delete other medicine details taht relate
        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();

        // Remove again the insert comment
        preparedStatement = connect
          .prepareStatement("delete from phamacy.medicine_details where barcode = ? ; ");
        preparedStatement.setString(1, barcode);
        preparedStatement.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        close();
    }
  }
  
  public String get_medicine_name(String barcode){
    String medicine_name = "none";
    try {
        Class.forName("com.mysql.jdbc.Driver");
          // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();

        resultSet = statement
           .executeQuery("select * from phamacy.medicines where barcode = '" + barcode + "'");

        while (resultSet.next()) {
            medicine_name = resultSet.getString("medicine_name");
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        close();
    }

    return medicine_name;
  }

  public void insert_medicine_details(String barcode, String medicine_code, String company_name, String lot_no,
          int medicine_type, int back_stock, float buying_price, float selling_price, int amount, String unit,
          java.sql.Date buying_date, java.sql.Date initialize_date, java.sql.Date expired_date,
          String size, int stock_type, int pack_amount, float pack_price){

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
                  + "(barcode, medicine_code, company_name, medicine_type, lot_no, back_stock, front_stock, buying_date, buying_price, selling_price, amount, unit, initialize_date, expired_date, size, stock_type, pack_amount, pack_price) "
                  + "values "
                  + "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
      // Parameters start with 1
      preparedStatement.setString(1, barcode);
      preparedStatement.setString(2, medicine_code);
      preparedStatement.setString(3, company_name);
      preparedStatement.setInt(4, medicine_type);
      preparedStatement.setString(5, lot_no);
      preparedStatement.setInt(6, back_stock);
      preparedStatement.setInt(7, 0);
      preparedStatement.setDate(8, buying_date);
      preparedStatement.setFloat(9, buying_price);
      preparedStatement.setFloat(10, selling_price);
      preparedStatement.setInt(11, amount);
      preparedStatement.setString(12, unit);
      preparedStatement.setDate(13, initialize_date);
      preparedStatement.setDate(14, expired_date);
      preparedStatement.setString(15, size);
      preparedStatement.setInt(16, stock_type);
      preparedStatement.setInt(17, pack_amount);
      preparedStatement.setFloat(18, pack_price);
      preparedStatement.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

  }
  
  public String[] list_lot(String barcode_){
        String lot_string = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/phamacy?"
                            + "user=root&password=root");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            resultSet = statement
               .executeQuery("select * from phamacy.medicine_details where barcode = '" + barcode_ + "' AND amount > 0 ORDER BY expired_date");
            System.out.println("|   Medicine Details");
            while (resultSet.next()) {
                lot_string += resultSet.getString("lot_no")+",";
                System.out.print(lot_string);
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close();
        }
      
      return lot_string.split(",");
  }
  
    public String[] list_lot_report(String barcode_){
        String lot_string = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/phamacy?"
                            + "user=root&password=root");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            resultSet = statement
               .executeQuery("select * from phamacy.medicine_details where barcode = '" + barcode_ + "' ORDER BY expired_date");
            System.out.println("|   Medicine Details");
            while (resultSet.next()) {
                lot_string += resultSet.getString("lot_no")+",";
                System.out.print(lot_string);
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close();
        }
      
      return lot_string.split(",");
  }

  public ArrayList<String[]> list_medicine_details(String barcode_, String lot_no_, String sort){
    ArrayList<String[]> medicine_details = new ArrayList<String[]>();
    try {
        Class.forName("com.mysql.jdbc.Driver");
          // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

          // Statements allow to issue SQL queries to the database
          statement = connect.createStatement();
        if(barcode_.length() > 0){
            if (lot_no_.length() > 0) {
                resultSet = statement
                   .executeQuery("select * from phamacy.medicine_details where barcode LIKE '%" + barcode_ + "%' AND lot_no = " + lot_no_);
            } else {
                resultSet = statement
                   .executeQuery("select * from phamacy.medicine_details where barcode LIKE '%" + barcode_ + "%'");
            }
        } else {
            switch (sort) {
                case "exp_date":
                    resultSet = statement
                            .executeQuery("select * from phamacy.medicine_details ORDER BY expired_date");
                    break;
                case "stock":
                    resultSet = statement
                            .executeQuery("select * from phamacy.medicine_details ORDER BY amount");
                    break;
                default:
                    resultSet = statement
                            .executeQuery("select * from phamacy.medicine_details");
                    break;
            }
        }
        System.out.println("|   Medicines Details");
        System.out.println("|   No.---barcode---medicine_code---company_name---lot_no---back_stock---front_stock---buying_date---buying_price---selling_price---amount---unit---initialize_date---expired_date---size---type");
        int i = 1;
        while (resultSet.next()) {
            String[] temp = new String[19];
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int id = resultSet.getInt("id");
            String barcode = resultSet.getString("barcode");
            String medicine_code = resultSet.getString("medicine_code");
            String company_name = resultSet.getString("company_name");
            String lot_no = resultSet.getString("lot_no");
            String size = resultSet.getString("size");
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
            System.out.print("---" + temp[1]);
            temp[2] = medicine_code;
            System.out.print("---" + temp[2]);
            temp[3] = company_name;
            System.out.print("---" + temp[3]);
            temp[4] = lot_no;
            System.out.print("---" + temp[4]);
            temp[5] = back_stock+"";
            System.out.print("---" + temp[5]);
            temp[6] = front_stock+"";
            System.out.print("---" + temp[6]);
            temp[7] = buying_date+"";
            System.out.print("---" + temp[7]);
            temp[8] = buying_price+"";
            System.out.print("---" + temp[8]);
            temp[9] = selling_price+"";
            System.out.print("---" + temp[9]);
            temp[10] = amount+"";
            System.out.print("---" + temp[10]);
            temp[11] = unit;
            System.out.print("---" + temp[11]);
            temp[12] = initialize_date+"";
            System.out.print("---" + temp[12]);
            temp[13] = expired_date+"";
            System.out.print("---" + temp[13]);
            temp[14] = size;
            System.out.print("---" + temp[14]);
            switch(resultSet.getInt("medicine_type")){
                case 0:
                    temp[15] = "ยาอันตราย";
                    break;
                case 1:
                    temp[15] = "ยาควบคุมพิเศษ";
                    break;
                case 2:
                    temp[15] = "ยาทั่วไป";
                    break;
                case 3:
                    temp[15] = "อื่นๆ";
                    break;
            }
            System.out.println("---" + temp[15]);
            
            switch(resultSet.getInt("stock_type")){
                case 0:
                    temp[16] = "ข้างบน";
                    break;
                case 1:
                    temp[16] = "ข้างล่าง";
                    break;
            }
            System.out.println("---" + temp[16]);
            
            temp[17] = resultSet.getInt("pack_amount") + "";
            temp[18] = resultSet.getFloat("pack_price") + "";
            

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

  public MedicineDetail get_medicine_detail(int id){
      MedicineDetail md = null;
      try {
        Class.forName("com.mysql.jdbc.Driver");
          // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        resultSet = statement
            .executeQuery("select * from phamacy.medicine_details where id = '" + id + "'");

        while (resultSet.next()) {
            String barcode = resultSet.getString("barcode");
            String medicine_code = resultSet.getString("medicine_code");
            String company_name = resultSet.getString("company_name");
            String lot_no = resultSet.getString("lot_no");
            String size = resultSet.getString("size");
            int back_stock = resultSet.getInt("back_stock");
            int front_stock = resultSet.getInt("front_stock");
            Date buying_date = resultSet.getDate("buying_date");
            float buying_price = resultSet.getFloat("buying_price");
            float selling_price = resultSet.getFloat("selling_price");
            int amount = resultSet.getInt("amount");
            String unit = resultSet.getString("unit");
            Date initialize_date = resultSet.getDate("initialize_date");
            Date expired_date = resultSet.getDate("expired_date");
            int pack_amount = resultSet.getInt("pack_amount");
            float pack_price = resultSet.getFloat("pack_price");
            String type = "";
            switch(resultSet.getInt("medicine_type")){
                case 0:
                    type = "ยาอันตราย";
                    break;
                case 1:
                    type = "ยาควบคุมพิเศษ";
                    break;
                case 2:
                    type = "ยาทั่วไป";
                    break;
                case 3:
                    type = "อื่นๆ";
                    break;
            }
            
            md = new MedicineDetail(id, back_stock, front_stock, amount,
                    buying_price, selling_price,
                    type, barcode, medicine_code, company_name, 
                    lot_no, size, unit, 
                    buying_date, initialize_date, expired_date,
                    pack_amount, pack_price);
            
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        close();
    }
      
    return md;
  }
  
    public MedicineDetail get_medicine_detail(String barcode, String lot){
      MedicineDetail md = null;
      try {
        Class.forName("com.mysql.jdbc.Driver");
          // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        resultSet = statement
            .executeQuery("select * from phamacy.medicine_details where barcode = '" + barcode + "' AND lot_no = '" + lot + "'");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String medicine_code = resultSet.getString("medicine_code");
            String company_name = resultSet.getString("company_name");
            String size = resultSet.getString("size");
            int back_stock = resultSet.getInt("back_stock");
            int front_stock = resultSet.getInt("front_stock");
            Date buying_date = resultSet.getDate("buying_date");
            float buying_price = resultSet.getFloat("buying_price");
            float selling_price = resultSet.getFloat("selling_price");
            int amount = resultSet.getInt("amount");
            String unit = resultSet.getString("unit");
            Date initialize_date = resultSet.getDate("initialize_date");
            Date expired_date = resultSet.getDate("expired_date");
            int pack_amount = resultSet.getInt("pack_amount");
            float pack_price = resultSet.getFloat("pack_price");
            String type = "";
            switch(resultSet.getInt("medicine_type")){
                case 0:
                    type = "ยาอันตราย";
                    break;
                case 1:
                    type = "ยาควบคุมพิเศษ";
                    break;
                case 2:
                    type = "ยาทั่วไป";
                    break;
                case 3:
                    type = "อื่นๆ";
                    break;
            }
            
            md = new MedicineDetail(id, back_stock, front_stock, amount,
                    buying_price, selling_price,
                    type, barcode, medicine_code, company_name, 
                    lot, size, unit, 
                    buying_date, initialize_date, expired_date,
                    pack_amount, pack_price);
            
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        close();
    }
      
    return md;
  }
  
  public void sell_medicine(int id, int front_stock_remaining, int amount_remaining) {
      try {
            Class.forName("com.mysql.jdbc.Driver");
              // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/phamacy?"
                            + "user=root&password=root");

            // Update
            preparedStatement = connect
              .prepareStatement("update phamacy.medicine_details set "
                        + "front_stock = ?, "
                        + "amount = ? "
                        + "where id = ? ; ");

            preparedStatement.setInt(1, front_stock_remaining);
            preparedStatement.setInt(2, amount_remaining);
            preparedStatement.setInt(3, id);
            
            preparedStatement.executeUpdate();
            
            System.out.println(id + ": F: " + front_stock_remaining + " All: " + amount_remaining);
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          close();
      }
  }
  
  public void update_medicine_details(int id, String barcode, String medicine_code, String company_name, String lot_no,
          int medicine_type, int back_stock, float buying_price, float selling_price, int amount, String unit,
          java.sql.Date buying_date, java.sql.Date initialize_date, java.sql.Date expired_date,
          String size, int stock_type, int pack_amount, float pack_price) {
      
        try {
            Class.forName("com.mysql.jdbc.Driver");
              // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/phamacy?"
                            + "user=root&password=root");

            // Update
            preparedStatement = connect
              .prepareStatement("update phamacy.medicine_details set "
                        + "barcode = ?, "
                        + "medicine_code = ?, "
                        + "company_name = ?, "
                        + "medicine_type = ?, "
                        + "lot_no = ?, "
                        + "buying_date = ?, "
                        + "buying_price = ?, "
                        + "selling_price = ?, "
                        + "unit = ?, "
                        + "initialize_date = ?, "
                        + "expired_date = ?, "
                        + "size = ?, "
                        + "stock_type = ?, "
                        + "pack_amount = ?, "
                        + "pack_price = ? "
                        + "where id = ? ; ");

            preparedStatement.setString(1, barcode);
            preparedStatement.setString(2, medicine_code);
            preparedStatement.setString(3, company_name);
            preparedStatement.setInt(4, medicine_type);
            preparedStatement.setString(5, lot_no);
            preparedStatement.setDate(6, buying_date);
            preparedStatement.setFloat(7, buying_price);
            preparedStatement.setFloat(8, selling_price);
            preparedStatement.setString(9, unit);
            preparedStatement.setDate(10, initialize_date);
            preparedStatement.setDate(11, expired_date);
            preparedStatement.setString(12, size);
            preparedStatement.setInt(13, stock_type);
            preparedStatement.setInt(14, pack_amount);
            preparedStatement.setFloat(15, pack_price);
            preparedStatement.setInt(16, id);
            preparedStatement.executeUpdate();

      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          close();
      }
        
  }
  
  public void update_stock(int id, int new_front_stock, int new_back_stock){
      try {
            Class.forName("com.mysql.jdbc.Driver");
              // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/phamacy?"
                            + "user=root&password=root");

            // Update
            preparedStatement = connect
              .prepareStatement("update phamacy.medicine_details set "
                        + "front_stock = ?, "
                        + "back_stock = ? "
                        + "where id = ? ; ");

            preparedStatement.setInt(1, new_front_stock);
            preparedStatement.setInt(2, new_back_stock);
            preparedStatement.setInt(3, id);
            
            preparedStatement.executeUpdate();
            
            System.out.println(id + ": F: " + new_front_stock + " B: " + new_back_stock);

      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          close();
      }
      
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

  public void insert_sell_histories(String barcode, String lot, java.sql.Date selling_date, int amount, float total, String discount){
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
                  + "(barcode, lot_no, selling_date, amount, total, discount) "
                  + "values "
                  + "( ?, ?, ?, ?, ?, ? )");
      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
      // Parameters start with 1
      preparedStatement.setString(1, barcode);
      preparedStatement.setString(2, lot);
      preparedStatement.setDate(3, selling_date);
      preparedStatement.setInt(4, amount);
      preparedStatement.setFloat(5, total);
      preparedStatement.setString(6, discount);
      preparedStatement.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  public ArrayList<String[]> list_sell_histories(java.sql.Date selectedDate){
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
           .executeQuery("select * from phamacy.sell_histories WHERE selling_date = '" + selectedDate + "' ORDER BY id ASC");
        System.out.println("|   Buying Histories");
        System.out.println("|   No.---barcode---lot_no---selling_date---amount---total");

        while (resultSet.next()) {
            String[] temp = new String[7];
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int id = resultSet.getInt("id");
            String barcode = resultSet.getString("barcode");
            String lot_no = resultSet.getString("lot_no");
            Date selling_date = resultSet.getDate("selling_date");
            int amount= resultSet.getInt("amount");
            float total = resultSet.getFloat("total");
            String discount = resultSet.getString("discount");

            temp[0] = id + "";
            System.out.print("---" + temp[0]);
            temp[1] = barcode;
            System.out.println("---" + temp[1]);
            temp[2] = lot_no;
            System.out.println("---" + temp[2]);
            temp[3] = selling_date + "";
            System.out.print("---" + temp[3]);
            temp[4] = amount + "" ;
            System.out.println("---" + temp[4]);
            temp[5] = total + "";
            System.out.print("---" + temp[5]);
            temp[6] = discount + "";
            System.out.print("---" + temp[6]);

            histories.add(temp);

        }

    } catch (Exception e){
        e.printStackTrace();
    } finally {
        close();
    }

    return histories;

  }
  
  public ArrayList<String[]> list_sell_histories_per_item(String barcode_, String lot_no_){
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
           .executeQuery("select * from phamacy.sell_histories where barcode = " + barcode_ +  " AND lot_no = " + lot_no_ + " ORDER BY id ASC");
        System.out.println("|   Selling Histories");
        System.out.println("|   No.---barcode---lot_no---selling_date---amount---total");
        while (resultSet.next()) {
            String[] temp = new String[7];
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int id = resultSet.getInt("id");
            String barcode = resultSet.getString("barcode");
            String lot_no = resultSet.getString("lot_no");
            Date selling_date = resultSet.getDate("selling_date");
            int amount= resultSet.getInt("amount");
            float total = resultSet.getFloat("total");
            String discount = resultSet.getString("discount");

            temp[0] = id + "";
            System.out.print("---" + temp[0]);
            temp[1] = barcode;
            System.out.println("---" + temp[1]);
            temp[2] = lot_no;
            System.out.println("---" + temp[2]);
            temp[3] = selling_date + "";
            System.out.print("---" + temp[3]);
            temp[4] = amount + "" ;
            System.out.println("---" + temp[4]);
            temp[5] = total + "";
            System.out.print("---" + temp[5]);
            temp[6] = discount + "";
            System.out.print("---" + temp[6]);

            histories.add(temp);

        }

    } catch (Exception e){
        e.printStackTrace();
    } finally {
        close();
    }

    return histories;

  }

  public ArrayList<String[]> list_sell_type10_histories(java.sql.Date selectedDate){
    ArrayList<String[]> histories = new ArrayList<String[]>();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        ResultSet resultSet2 = statement
           .executeQuery("select * from phamacy.sell_histories WHERE selling_date = '" + selectedDate + "' ORDER BY id ASC");
        System.out.println("|   Selling Histories");
        System.out.println("|   No.---barcode---lot_no---selling_date---amount---total");
        
        while (resultSet2.next()) {
            String[] temp = new String[7];
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int id = resultSet2.getInt("id");
            String barcode = resultSet2.getString("barcode");
            String lot_no = resultSet2.getString("lot_no");
            Date selling_date = resultSet2.getDate("selling_date");
            int amount= resultSet2.getInt("amount");
            float total = resultSet2.getFloat("total");
            String discount = resultSet2.getString("discount");
            
            MedicineDetail md = get_medicine_detail(barcode, lot_no);
            
            if(!md.getType().equals("อื่นๆ")) {
                temp[0] = id + "";
                System.out.print("---" + temp[0]);
                temp[1] = barcode;
                System.out.println("---" + temp[1]);
                temp[2] = lot_no;
                System.out.println("---" + temp[2]);
                temp[3] = selling_date + "";
                System.out.print("---" + temp[3]);
                temp[4] = amount + "" ;
                System.out.println("---" + temp[4]);
                temp[5] = total + "";
                System.out.print("---" + temp[5]);
                temp[6] = discount + "";
                System.out.print("---" + temp[6]);

                histories.add(temp);
            }

        }

    } catch (Exception e){
        e.printStackTrace();
    } finally {
        close();
    }

    return histories;

  }
  
    public ArrayList<String[]> list_sell_type7_histories(java.sql.Date selectedDate){
    ArrayList<String[]> histories = new ArrayList<String[]>();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/phamacy?"
                        + "user=root&password=root");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        ResultSet resultSet2 = statement
           .executeQuery("select * from phamacy.sell_histories WHERE selling_date = '" + selectedDate + "' ORDER BY id ASC");
        System.out.println("|   Selling Histories");
        System.out.println("|   No.---barcode---lot_no---selling_date---amount---total");
        
        while (resultSet2.next()) {
            String[] temp = new String[7];
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int id = resultSet2.getInt("id");
            String barcode = resultSet2.getString("barcode");
            String lot_no = resultSet2.getString("lot_no");
            Date selling_date = resultSet2.getDate("selling_date");
            int amount= resultSet2.getInt("amount");
            float total = resultSet2.getFloat("total");
            String discount = resultSet2.getString("discount");
            
            MedicineDetail md = get_medicine_detail(barcode, lot_no);
            
            System.out.println (md.getType());
            
            if(md.getType().equals("ยาอันตราย") || md.getType().equals("ยาควบคุมพิเศษ")) {
                temp[0] = id + "";
                System.out.print("---" + temp[0]);
                temp[1] = barcode;
                System.out.println("---" + temp[1]);
                temp[2] = lot_no;
                System.out.println("---" + temp[2]);
                temp[3] = selling_date + "";
                System.out.print("---" + temp[3]);
                temp[4] = amount + "" ;
                System.out.println("---" + temp[4]);
                temp[5] = total + "";
                System.out.print("---" + temp[5]);
                temp[6] = discount + "";
                System.out.print("---" + temp[6]);

                histories.add(temp);
            }

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

  public void insert_buy_histories(String barcode, String lot, java.sql.Date buying_date, int amount, float total){
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
          .prepareStatement("insert into phamacy.buy_histories "
                  + "(barcode, lot_no, buying_date, amount, total) "
                  + "values "
                  + "( ?, ?, ?, ?, ? )");
      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
      // Parameters start with 1
      preparedStatement.setString(1, barcode);
      preparedStatement.setString(2, lot);
      preparedStatement.setDate(3, buying_date);
      preparedStatement.setInt(4, amount);
      preparedStatement.setFloat(5, total);
      preparedStatement.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  public ArrayList<String[]> list_buy_histories(java.sql.Date selectedDate){
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
           .executeQuery("select * from phamacy.buy_histories WHERE buying_date = '" + selectedDate + "' ORDER BY id ASC");
        System.out.println("|   Buying Histories");
        System.out.println("|   No.---detail_id---buying_date---amount---total");
        int i = 1;
        while (resultSet.next()) {
            String[] temp = new String[6];
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int id = resultSet.getInt("id");
            String barcode = resultSet.getString("barcode");
            String lot_no = resultSet.getString("lot_no");
            Date buying_date = resultSet.getDate("buying_date");
            int amount= resultSet.getInt("amount");
            float total = resultSet.getFloat("total");

            temp[0] = id + "";
            System.out.print("---" + temp[0]);
            temp[1] = barcode;
            System.out.print("---" + temp[1]);
            temp[2] = lot_no;
            System.out.print("---" + temp[2]);
            temp[3] = buying_date + "";
            System.out.print("---" + temp[3]);
            temp[4] = amount + "" ;
            System.out.print("---" + temp[4]);
            temp[5] = total + "";
            System.out.println("---" + temp[5]);

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