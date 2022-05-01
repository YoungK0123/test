package sp_class;



/*
 * 3.process �ǽ�
 * 
 * Thread 2���� ���� �� , main �Լ��� Thread2������ ���ÿ� 0���� 9���� ��� ����Ͽ����� ���� �� �� �ְ� ���� �տ��� 
 * main thread1 thread2 ǥ�� �Ͻÿ� 
 * 
 * 
 * class ThreadClass extends Thread { // 'Thread' Class�� ���
 * 
 */

class ThreadClass extends Thread { // 'Thread' Class�� ��ӹ޴´� 
    String thread_name; 
    public ThreadClass(String name) { 
        this.thread_name = name; 
    } 

    public void run() { 
        for(int i=0; i<10; i++) { 
            System.out.println(thread_name+i); 
            try { 
                sleep(10); 
            } catch (InterruptedException e) { e.printStackTrace(); } 
        } 
    } 
} 

public class CThreadSample { 
    public static void main(String[] args) throws InterruptedException { 
        ThreadClass tc1 = new ThreadClass("[Thread1] ");
        ThreadClass tc2 = new ThreadClass("[Thread2] ");
        tc1.start();  //����
        tc2.start();

        for (int i=0; i<10; i++)
        {
        	System.out.println("[Main] "+i);
        	Thread.sleep(10);  // ���� ���� ���� �����尡 ������ �и��� ���� �޸�(�Ͻ������� ���� ����)��
        }
        
        tc1.join(); //�� �����尡 ���� ������ ���
        tc2.join();
    } 
}