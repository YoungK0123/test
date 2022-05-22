package com.lgcns.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class RunManager {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		new RunManager().start();

	}

	public void start() throws Exception {

		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(8080);
		server.addConnector(http);
		
		
		ServletHandler servlethandler = new ServletHandler();
		
		servlethandler.addServletWithMapping(httpServlet.class, "/*");
		server.setHandler(servlethandler);
		
		server.start();
		server.join();
		

	}

}
