package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.util.List;

public class MySqlDatabaseService {

  private static SessionFactory factory;
  private static Session session;
  private Connection dbConnection;
  private String dbUn = "BFSData";
  private String dbUrl = "BFSData@127.0.0.1:3306";
//  private String dbUrl = "jdbc:mysql://127.0.0.1:3306/?user=BFSData";
  private String dbPw = "bfsdata";

  public MySqlDatabaseService(){
    try {
      if(factory == null || session == null){
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
      }
    }catch (Exception ex){
      ex.printStackTrace();
    }
  }

  public void setupSchema(){}

  public boolean isConnectionActive(){
    return session.isConnected();
  }

  public void purgeDb(){}

  public void insertRecord(TABLE_Test record){
    session.merge(record);
  }

  public List<TABLE_Test> getTestRecords(){
    return session.createNamedQuery("getRecords",TABLE_Test.class).list();
  }

  public boolean checkNewRawData(){
    return false;
  }

}
