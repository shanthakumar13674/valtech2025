package servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class LoadConfigListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("First Piece of Code that will be Executed ....");
		System.out.println("Loading ... Config .... done ....");
		System.out.println("Creating Database Connection Pools ....");
		ServletContext application = sce.getServletContext();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Closing all Database Connections in the Connection Pools ....");
	}
	
}
