package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import com.mysql.jdbc.Driver;

public class DbInit {

  private Connection dbConnection;
  private String dbUn = "BFSData";
  private String dbUrl = "BFSData@127.0.0.1:3306";
//  private String dbUrl = "jdbc:mysql://127.0.0.1:3306/?user=BFSData";
  private String dbPw = "bfsdata";

  public DbInit(){
    try{
      dbConnection = DriverManager.getConnection("",dbUn,dbPw);
      Class.forName("com.mysql.jdbc.Driver");

    }catch (SQLException sqlEx){
      System.out.println("SQL Exception: "+sqlEx.getMessage());
    }
    catch(ClassNotFoundException classEx){
      System.out.println("Class not found exception: "+classEx.getLocalizedMessage());
    }
  }

  public void setupSchema(){}

  public boolean checkConnection(){
    return false;
  }

  public void purgeDb(){}

  public void insertRecord(){}

  public boolean checkNewRawData(){
    return false;
  }

}
