import database.MySqlDatabaseService;
import database.TABLE_Test;
import org.apache.logging.log4j.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import service.FileProcessingService;
import service.FileProcessingServiceImpl;

import java.util.List;

/**
 * Primary application class for BFS Data Server
 */
public class BFSDataMain {

  private static FileProcessingService fileProcessingService;
  private static MySqlDatabaseService db;
  private static Server bfsServer;
  private static int serverPort = 7070;
  private static String webappDir = "src/main/webapp/";
  private static final Logger logger = LogManager.getLogger(BFSDataMain.class);
  private static String logTag = "BfsMain: ";

  /**
   * Primary method extended by class
   * @param args
   */
  public static void main(String[] args){
    try {
      // booting server
      logger.info(logTag+"Boot server begin");
      bootServer();
      logger.info(logTag+"Boot server end");

      // starting DB interface
      logger.info(logTag+"Boot Db Adapter begin");
      bootDbInterface();
      logger.info(logTag+"Boot Db Adapter end");
      logger.info(logTag+"connection status: " + db.isConnectionActive());

      fileProcessingService = new FileProcessingServiceImpl();
      Boolean hasData = fileProcessingService.checkDirectory();
      logger.info(logTag+"Data is available for processing: "+hasData);
    }catch (Exception ex){
      logger.error("System Exception:"+ex.getMessage());
    }
  }

  protected static boolean isServerRunning(){
    return bfsServer != null && bfsServer.isStarted();
  }

  private static void bootDbInterface(){
    db = new MySqlDatabaseService();
  }

  private static void bootServer() throws Exception {
    try{
      bfsServer = new Server(serverPort);
      WebAppContext webapp = new WebAppContext();
      webapp.setContextPath("/main");
      webapp.setDescriptor(webappDir+"/WEB-INF/web.xml");
      webapp.setResourceBase(webappDir);

      bfsServer.setHandler(webapp);
      bfsServer.start();
    }catch (InterruptedException intEx){
      logger.error("Interrupted: "+intEx.getMessage());
    }
  }

  private static void insertTestRecord(){
    TABLE_Test test = new TABLE_Test();
    test.setCol1("bleh2");
    test.setId(2);
    db.insertRecord(test);
    logger.debug("Test Record inserted: {}" + test);
  }

  private static void getTestRecords(){
    List<TABLE_Test> list = db.getTestRecords();
    logger.debug("Retrieved test records: {}" + list);
  }

}
