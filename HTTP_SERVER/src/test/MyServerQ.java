package test;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletHandler;

public class MyServerQ {

	public static void main(String[] args) throws Exception {
		new MyServerQ().start();
	}

	public void start() throws Exception {
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(8080);
		server.addConnector(http);

		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(MyServletQ.class, "/mypath");
		server.setHandler(servletHandler);

		server.start();
		server.join();
	}
}
