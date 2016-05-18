import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.InetSocketAddress;

public class Launcher {
    public static void main(String[] args) throws Exception {
        Server server = new Server(new InetSocketAddress("localhost", 8765));

        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setResourceBase("src/ee/devclub");
        webapp.setParentLoaderPriority(true);
        webapp.setServer(server);

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setResourceBase("webapp");

        HandlerList handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[] { webapp, resourceHandler });
        server.setHandler(handlerList);
        server.start();
    }
}
