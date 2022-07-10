package test;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletHandler;

/*
 * 8. https 실습 - server
 * http 8080 port 로 Jetty ServerConnector(WAS) 가 구동
 * 
 * sample 이 주어짐 
 * 
 * servletHandler.addServletWithMapping(MyServlet.class, "/*");
 * 만 체크 하면 될듯
 * >> /*으로 모두 인식 
 * >> /A , /B로 별도의 servlet으로 만들어서 구분해서 만들면 될 듯 
 * 
 * 
 * sample로 주어짐 
 * test 
 * 0710
 * multi port 
 * 
 * 
 */



public class MyServer {

	public static void main(String[] args) throws Exception {
		new MyServer().start();
	}

	public void start() throws Exception {
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(8080);
		server.addConnector(http);
		
		//0710 - port 8089
		ServerConnector http2 = new ServerConnector(server);
		http2.setHost("127.0.0.1");
		http2.setPort(8089);
		server.addConnector(http2);

		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(MyServlet.class, "/*");
		server.setHandler(servletHandler);

		server.start();
		server.join();
	}
}
