package fudan.plus1.Handler;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jettison.JettisonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import fudan.plus1.Persistence.PersistenceUser;

/**
 * Created by billlai on 14/十二月/2016.
 */
public class Core {
    // Modify the uri here
    private static final String uriAddr = "http://localhost:8080/";

    private static final URI BASE_URI = URI.create(uriAddr);

    public static void main(String[] args) {
        try {
            System.out.println("Plus 1 core:");

            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, createApp(), false);
            PersistenceUser.getInstance().buildUserList();
            PersistenceUser.getInstance().buildCounterList();
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    server.shutdownNow();
                }
            }));
            server.start();

            System.out.println(String.format("Application started.%nStop the application using CTRL+C"));

            Thread.currentThread().join();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ResourceConfig createApp() {
        return new ResourceConfig()
                .register(new JettisonFeature())
                .packages("fudan.plus1.Handler");
    }
}
