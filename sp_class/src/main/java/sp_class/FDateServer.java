package sp_class;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


/*
 * 6.��Ʈ��ũ soket �ǽ� 1
 * 
 * clinet���� server�� �����ϸ� server�� ���� ��¥�� �ð��� client�� �����ϰ� 
 * client �� ���� ���� ���� ����Ͻÿ�  
 *
 * //����
 * ServerSocket listener = new ServerSocket(9090); //9090��Ʈ�� socket ���� �� ��� 
 *
 *try {
            while (true) {
                Socket socket = listener.accept(); //clinet�� ����ö����� ����� ���� ���� socket�� �Ҵ�
                try {
                    PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
 * 
 * 
 * 
 * //��¥ DATE
 *  Date().toString()
 * 
 */

public class FDateServer {
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        try {
            while (true) {
                Socket socket = listener.accept(); //clinet�� ����ö����� ����� ���� ���� socket�� �Ҵ�
                try {
                    PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString() + "Test0");
                    out.println("TEST1");
                    out.println("TEST2");
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
}