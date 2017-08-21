import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import java.net.URI;
import java.net.URL;

public class BFSDataMain {
    public static void main(String[] args){
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
            bfsServer.setHandler(handler);

            ServletHolder holderPwd = new ServletHolder("default", DefaultServlet.class);
            holderPwd.setInitParameter("dirAllowed","true");
            handler.addServlet(holderPwd,"/");

            bfsServer.start();
        }catch (Exception ex){
            System.out.println("Server Error: "+ex.getMessage());
        }
    }
}
