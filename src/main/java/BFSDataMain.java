import database.DbInit;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class BFSDataMain {

  private static DbInit db;

  public static void main(String[] args){
    try{
      initServer();
//      db = new DbInit();
//      boolean isConnected = db.checkConnection();
//      System.out.println(isConnected);
    }catch (Exception ex){
      System.out.println("System Error: "+ex.getMessage());
    }
  }

  private static void initServer(){
    try{
      Server bfsServer = new Server(7070);

      ClassLoader cl = BFSDataMain.class.getClassLoader();

      URL url = cl.getResource("index.html");
      if(url == null){
        throw new RuntimeException("Unable to find resources.");
      }

      URI webRootUri = url.toURI().resolve("./").normalize();
      System.out.println("WebRoot is "+webRootUri);

      ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
      handler.setContextPath("/main");
      handler.setBaseResource(Resource.newResource(webRootUri));
//      handler.setResourceBase();
      bfsServer.setHandler(handler);

      ServletHolder holderPwd = new ServletHolder("default", DefaultServlet.class);
      holderPwd.setInitParameter("dirAllowed","true");
      handler.addServlet(holderPwd,"/");

      bfsServer.start();
    }catch(URISyntaxException syntaxException){
      System.out.println("URI Error: "+syntaxException.getMessage());
    }catch(MalformedURLException urlException){
      System.out.println("URL Error: "+urlException.getMessage());
    }catch(Exception ex){
      System.out.println("Error: "+ex.getMessage());
    }

  }
}
