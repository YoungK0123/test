package test;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

/*
 * 8.http �ǽ�
 * client���� server �� http://127.0.0.1:8080/requestDate �� ��û�ϰ�, 
 * server�� ���� ��¥ �ð��� ���� method GET���
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
