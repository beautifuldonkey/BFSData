import database.DbInit;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Primary application class for BFS Data Server
 */
public class BFSDataMain {

  private static DbInit db;
  private static Server bfsServer;
  private static int serverPort = 7070;
  private static String webappDir = "src/main/webapp/";

  /**
   * Primary method extended by class
   * @param args
   */
  public static void main(String[] args){
    try {
      // booting server
      bootServer();
      System.out.println("Server Started!");

      // starting DB interface
      bootDbInterface();
      System.out.println("DB Interface is set up!");
      System.out.println("connection status: " + db.isConnectionActive());

      // validating DB connection
      db.getTestRecords();
      System.out.println("Retrieved test records:");
    }catch (Exception ex){
      System.out.println("System Exception:"+ex.getMessage());
    }
  }

  protected static boolean isServerRunning(){
    return bfsServer != null && bfsServer.isStarted();
  }

  private static void bootDbInterface(){
    db = new DbInit();
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
      System.out.println("Interrupted: "+intEx.getMessage());
    }
  }

}
