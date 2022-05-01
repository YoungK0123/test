package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.*;

/*
 * 8. https 실습 - server
 * http 8080 port 로 Jetty ServerConnector(WAS) 가 구동
 * 
 * 
 * public class MyServlet extends HttpServlet
 * 
 * protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 * 
 * 
 * protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 * 
 *  //inputstream 입력 
 * BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));
 *   String buffer;//알아 두어야 함 key
 *   while ((buffer = input.readLine()) != null) {
 *     	printWriter.print(buffer);
 *    }        
 * 
 * 
 * 
 * 
 * //폴더 directory 생성
 * File destFolder = new File("./OUTPUT");
 * if(!destFolder.exists()) {
 * 	    destFolder.mkdirs();\
 * }
 * 
 * 
 */



public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Request : "+ req.getRequestURL());
		
		res.setStatus(200);
		res.getWriter().write(new Date().toString());
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Request : "+ req.getRequestURL());
		////////////////////////////////////////////////
		File destFolder = new File("./OUTPUT");
		if(!destFolder.exists()) {
		    destFolder.mkdirs(); 
		}
		
		LocalTime currentTime = LocalTime.now();
		String fname = String.format("./OUTPUT/%02d%02d%02d.json", currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond());
	    PrintWriter printWriter = new PrintWriter(new FileWriter(new File(fname)));
	    
	    
	    //inputstream 입력 
        BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));
        
        String buffer;//알아 두어야 함 key
        while ((buffer = input.readLine()) != null) {
        	printWriter.print(buffer);
        }        
		input.close();		
		printWriter.close();
		/////////////////////////////////////////////////
		
		res.setStatus(200);
		res.getWriter().write(fname + " saved!");
	}
}
