package pro.aloginov.revoluttest;

import com.google.inject.Guice;
import com.google.inject.Stage;
import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.util.EnumSet;

public class App {

    public static void main(String[] args) throws Exception {
        Guice.createInjector(
            Stage.PRODUCTION,
            new AppServletModule()
        );
        
        Server server = new Server(8088);

        ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        context.addFilter(GuiceFilter.class, "/*", EnumSet.<javax.servlet.DispatcherType>of(javax.servlet.DispatcherType.REQUEST, javax.servlet.DispatcherType.ASYNC));
        context.addServlet(DefaultServlet.class, "/*");

        ErrorHandler errorHandler = new ErrorHandler();
        errorHandler.setShowStacks(false);
        context.setErrorHandler(errorHandler);

        server.start();
        server.join();
    }
}
