package sp_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/*
 * 6.��Ʈ��ũ soket �ǽ� 2
 * Dataserver�� ���� ���� 
 * 
 * 
 * Socket s = new Socket("127.0.0.1", 9090);
 * s.getInputStream() // socket���� ���� ���� ��� 
 * 
 * BufferedReader input =
            new BufferedReader(new InputStreamReader(s.getInputStream()));
 * 
 * 
 */


public class FDateClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 9090);
        BufferedReader input =
            new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        System.out.println(answer);   //��¥ �ð� return
    }
}