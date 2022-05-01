package test;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

/*
 * 8.http 실습
 * client에서 server 에 http://127.0.0.1:8080/requestDate 로 요청하고, 
 * server는 현재 날짜 시각을 응답 method GET사용
 * 
 * 
 * HttpClient httpClient = new HttpClient();
 * httpClient.start();
 * ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8080/requestDate").method(HttpMethod.GET).send();
 * contentRes.getContentAsString()
 * 
 */

public class DateClient {

	public static void main(String[] args) throws Exception {
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8080/requestDate").method(HttpMethod.GET)
				.send();
		System.out.println(contentRes.getContentAsString());
	}
}
