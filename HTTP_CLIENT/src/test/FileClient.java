package test;

import java.io.File;
import java.nio.ByteBuffer;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/*
 * 8.http 실습 2 
 * 
 *  client의 file folder 'INPUT'에 있는 file list을 
 *  http server에 접속하여, json의 형태로 저장 
 *  
 *  method post > 즉 server에 POST servlet이 있어야 함 
 *  
 *  
 *  Request request = httpClient.newRequest("http://127.0.0.1:8080/fileList").method(HttpMethod.POST)
 *  
 *  
 *  //header
 *  request.header(HttpHeader.CONTENT_TYPE, "application/json");
 *  //content
 *  request.content(new StringContentProvider(strFileList,"utf-8"));
 *  //응답값 저장 
 *  ContentResponse contentRes = request.send();
 *  
 *  //상대 경로
 *  File directory = new File("./Input");
 *  
 *  contentRes.getContentAsString() //string 출력
 * 
 */



public class FileClient {

	public static void main(String[] args) throws Exception  {
		String strFileList = getFileList();
		
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		Request request = httpClient.newRequest("http://127.0.0.1:8080/fileList").method(HttpMethod.POST);
		request.header(HttpHeader.CONTENT_TYPE, "application/json");
		request.content(new StringContentProvider(strFileList,"utf-8"));
		ContentResponse contentRes = request.send();
		System.out.println(contentRes.getContentAsString());		
		httpClient.stop();
	}
	
	private static String getFileList() {
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
        File directory = new File("./Input");   // client 프로젝트 안에 경로에 있거나 별도의 풀경로 설정 
		jo.addProperty("Folder", "Input");
        JsonArray jarr = new JsonArray();
        File[] fList = directory.listFiles();
        for (File file : fList) {
        	jarr.add(file.getName());
        }		
        jo.add("FILES", jarr);
        
        String res = jo.toString();
        return res; 
	}
}
