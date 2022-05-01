package sp_class;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.*;
/*
 *  json �ǽ�1
 *  https://github.com/google/gson jar ���� �ٿ� �� lib ��� 
 *  project ��Ŭ�� property > java build path
 *  
 *  
 *   ���� �Ʒ� �������� json ���� ����
 *  {
 *   "name":"spiderman",
 *   "age":45,
 *   "married":true,
 *   "specialty":{"martial art","gun"},
 *   "vaccine":{"1st":"done","2nd":"expected","3rd":null},  //Object ����
 *   "children":[{"name":"spidergirl","age":10},{"name":"spiderboy","age", 8}], //Array ����
 *   "address", null
 *   }
 *   
 *   ��: 
 *   {"name":"spiderman","age":45,"married":true,"specialty":["martial art","gun"],"vaccine":{"1st":"done","2nd":"expected","3rd":null},"children":[{"name":"spiderboy","age":10},{"name":"spidergirl","age":8}],"address":null}
 *   
 *  // �⺻  "name":"spiderman", 
 *  JsonObject jsonObj = new JsonObject();
 *  jsonObj.addProperty("name", "spiderman");
 *  
 *  //"specialty":{"martial art","gun"},
 *  JsonArray jsonArr = new JsonArray();
 *  jsonArr.add("martial art");
 *  jsonObj.add("specialty", jsonArr);
 *  
 *  
 *  //"vaccine":{"1st":"done","2nd":"expected","3rd":null},  //Object ����
 *  JsonObject jsonObj2 = new JsonObject();
 *  jsonObj2.addProperty("1st", "done");
 *  jsonObj2.addProperty("1st", "done");
 *  jsonObj.add("vaccine", jsonObj2);
 *   
 *  //"children":[{"name":"spidergirl","age":10},{"name":"spiderboy","age", 8}], //Array ����
 *  JsonArray jsonArr2 = new JsonArray();
 *	jsonObj2 = new JsonObject();
 *	jsonObj2.addProperty("name", "spiderboy");
 *	jsonObj2.addProperty("age", 10);
 *	jsonArr2.add(jsonObj2);
 *		
 *	jsonObj2 = new JsonObject();
 *	jsonObj2.addProperty("name", "spidergirl");
 *	jsonObj2.addProperty("age", 8);
 *	jsonArr2.add(jsonObj2);
 *   
 *   
 *   
 *  // null 
 *  jsonObj.add("address", null);
 *  
 *  
 *  
 *  //���� ���� 
 *  Writer writer = new FileWriter("D:\\����\\sp�⺻\\7.json\\sample.json")
 *  Gson gson = new GsonBuilder().serializeNulls().create();
 *  gson.toJson(jsonObj, writer);
 *  
 *  
 *  	 
 */

public class GJsonSolve1 {

	public static void main(String[] args) {
		JsonObject jsonObj = new JsonObject();  //�ʱ� ���� 
		jsonObj.addProperty("name", "spiderman"); //
		jsonObj.addProperty("age", 45);
		jsonObj.addProperty("married", true);
		
		JsonArray jsonArr = new JsonArray();
		jsonArr.add("martial art");
		jsonArr.add("gun");
		jsonObj.add("specialty", jsonArr);
		
		JsonObject jsonObj2 = new JsonObject();
		jsonObj2.addProperty("1st", "done");
		jsonObj2.addProperty("2nd", "expected");
		jsonObj2.add("3rd", null);		
		jsonObj.add("vaccine", jsonObj2);
	
		JsonArray jsonArr2 = new JsonArray();
		jsonObj2 = new JsonObject();
		jsonObj2.addProperty("name", "spiderboy");
		jsonObj2.addProperty("age", 10);
		jsonArr2.add(jsonObj2);
	
		jsonObj2 = new JsonObject();
		jsonObj2.addProperty("name", "spidergirl");
		jsonObj2.addProperty("age", 8);
		jsonArr2.add(jsonObj2);

		jsonObj.add("children", jsonArr2);
		
		jsonObj.add("address", null);
		
		//file �б� ���� 
		
		try (Writer writer = new FileWriter("D:\\����\\sp�⺻\\7.json\\sample.json")) {
		    Gson gson = new GsonBuilder().serializeNulls().create();
		    gson.toJson(jsonObj, writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
