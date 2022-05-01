package test;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletHandler;

/*
 * 8. https �ǽ� - server
 * http 8080 port �� Jetty ServerConnector(WAS) �� ����
 * 
 * sample �� �־��� 
 * 
 * servletHandler.addServletWithMapping(MyServlet.class, "/*");
 * �� üũ �ϸ� �ɵ�
 * >> /*���� ��� �ν� 
 * >> /A , /B�� ������ servlet���� ���� �����ؼ� ����� �� �� 
 * 
 * 
 * sample�� �־��� 
 * test
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

		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(MyServlet.class, "/*");
		server.setHandler(servletHandler);

		server.start();
		server.join();
	}
}
