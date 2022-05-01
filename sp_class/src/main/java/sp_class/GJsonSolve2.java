package sp_class;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;


/*
 * json �ǽ� 2
 * 
 * �տ��� ���� sample json�� �̿��Ͽ�, ���
 * name:spiderman(45)
 * name:spidergirl(8)
 * 
 * 
 * Gson gson = new Gson();  
 * JsonReader reader = new JsonReader(new FileReader(filePath));
 * JsonObject jsonObj = gson.fromJson(reader, JsonObject.class);
 *  
 * JsonArray jsonArr = jsonObj.get("children").getAsJsonArray();
 * 
 * //�⺻ json "name":"spiderman" ȣ��
 * String name = jsonObj.get("name").getAsString();
 * JsonArray jsonArr = jsonObj.get("children").getAsJsonArray();
 * 
 * 
 * // ó�� children�� jsonArray�� ȣ�� > JsonObject�� 
 * //"children":[{"name":"spidergirl","age":10},{"name":"spiderboy","age", 8}],
 * JsonArray jsonArr = jsonObj.get("children").getAsJsonArray();
 * JsonObject jsonObj2 = jsonArr.get(1).getAsJsonObject();
 * name = jsonObj2.get("name").getAsString();
 * 
 * 
 * 
 * 
 * >>������ ���� object key : value ���·� ����� �۾� 
 * 
 * boolean bo =  jsonObj.get("married").getAsBoolean();
 * 
 * 
 */

public class GJsonSolve2 {

	public static void main(String[] args) {
		String filePath = "D:\\����\\sp�⺻\\7.json\\sample.json"; 
		try {
			Gson gson = new Gson();  
			JsonReader reader = new JsonReader(new FileReader(filePath)); //���� ȣ��
			JsonObject jsonObj = gson.fromJson(reader, JsonObject.class);

			//�⺻ json "name":"spiderman" ȣ��
			String name = jsonObj.get("name").getAsString();
			int age = jsonObj.get("age").getAsInt();
			System.out.println("name:"+name + "("+age+")");
			
			
			//"children":[{"name":"spidergirl","age":10},{"name":"spiderboy","age", 8}],
			// ó�� children�� jsonArray�� ȣ�� > JsonObject�� 
			JsonArray jsonArr = jsonObj.get("children").getAsJsonArray();
			JsonObject jsonObj2 = jsonArr.get(1).getAsJsonObject();
			name = jsonObj2.get("name").getAsString();
			age = jsonObj2.get("age").getAsInt();
			System.out.println("name:"+name + "("+age+")");
			
			boolean bo =  jsonObj.get("married").getAsBoolean();
			
			System.out.println("married:"+bo );
					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
