package sp_class;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 *  6.��Ʈ��ũ soket �ǽ� 1
 *  ������ �����Ͽ�, ������ �����ϴ� ���α׷��� ���� 
 *  client�� ���� ���� �Ϸ� �� ����
 *  server�� ������ ���� �Ϸ� �� ����
 *  Server�� 'QUIT' �Է� �� ������ ���� 
 * 
 * 
 * Socket socket = null;
 * DataOutputStream os = null;
 * 
 * socket = new Socket("127.0.0.1", 27015);
 * os = new DataOutputStream(socket.getOutputStream());
 * 
 * 
 * directory �� file list
 * File directory = new File("./6.socket/6.ClientFiles");
 * File[] fList = directory.listFiles();
 * for (File file : fList) {
 * 
 *  //������ close 
 * finally {
 * 	if (os != null) { os.close(); }
 * 	if (socket != null) { socket.close(); }	
 * }
 * 
 */

public class FFileClient {
    public static void main(String[] args) throws IOException {
		Socket socket = null;
		DataOutputStream os = null;
		try {
			socket = new Socket("127.0.0.1", 27015);
			os = new DataOutputStream(socket.getOutputStream());
			
			byte[] buffer = new byte[4096];
			int length;
			
			// get all the files from a directory
			//File directory = new File("./ClientFiles");
			//File directory = new File("D:\\����\\sp�⺻\\6.socket\\ClientFiles");

			File directory = new File("./6.socket/6.ClientFiles");
			File[] fList = directory.listFiles();
			for (File file : fList) {
				if (file.isFile()) {
					// �����̸� ���� 
					os.writeUTF(file.getName());
					// ����ũ�� ����
					os.writeInt((int) file.length());
					
					FileInputStream is = null;
					try {
						is = new FileInputStream(file.getPath());
						while ((length = is.read(buffer)) != -1) {
							// ���ϳ��� ����
							os.write(buffer, 0, length);
						}
					} finally {
						if (is != null) { is.close(); }
					}	
				}
			}
			System.out.println("Sent All Files.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) { os.close(); }
			if (socket != null) { socket.close(); }
		}
    }   
}