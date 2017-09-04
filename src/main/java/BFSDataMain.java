import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Primary application class for BFS Data Server
 */
public class BFSDataMain {
  /**
   * Primary method extended by class
   * @param args
   */
  public static void main(String[] args){
    try {
      bootServer();
    }catch (Exception ex){
      System.out.println("System Error:"+ex.getMessage());
    }

  }

  private static void bootServer() throws Exception{
    try{
      Server bfsServer = new Server(7070);
      String webappDir = "src/main/webapp/";

      WebAppContext webapp = new WebAppContext();
      webapp.setContextPath("/");
      webapp.setDescriptor(webappDir+"/WEB-INF/web.xml");
      webapp.setResourceBase(webappDir);

      bfsServer.setHandler(webapp);
      bfsServer.start();
      bfsServer.join();
    }catch (InterruptedException intEx){
      System.out.println("Interrupted: "+intEx.getMessage());
    }
  }

}
