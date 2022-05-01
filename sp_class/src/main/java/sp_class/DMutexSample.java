package sp_class;

import java.util.concurrent.locks.ReentrantLock;


/*
 * 4. Mutex(��ȣ����)�ǽ� 1
 * 
 * mutex�� ����Ͽ�, main�� 2���� thread �Լ����� ������ ���� 1~30���� ���ڸ� ����ϰ� �Ͻÿ�
 * 
 * ���
 * [Main]
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
 * [Thread1] 
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
 * [Thread2]
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 
 * 
 * static ReentrantLock lock = new ReentrantLock();
 * 
 * lock.lock();
 * lock.unlock();
 * 
 * class ThreadClass_mutex extends Thread {
 *  public void run() { 
    	lock.lock();  // �ش� �ּ� �Ͽ� ��� Ȯ�� �ϱ� 
    
    	try {
    		PrintNums(thread_name);
    	}
    	finally {
    		lock.unlock();
    	}
    } 
    }
 * 
 * 
 */

class ThreadClass_mutex extends Thread { // 'Thread' Class�� ��ӹ޴´� 
	
	static ReentrantLock lock = new ReentrantLock();
	
    String thread_name; 
    public ThreadClass_mutex(String name) { 
        this.thread_name = name; 
    } 

    public void run() { 
    	lock.lock();  // �ش� �ּ� �Ͽ� ��� Ȯ�� �ϱ� 
    
    	try {
    		PrintNums(thread_name);
    	}
    	finally {
    		lock.unlock();
    	}
    } 
    
    static void PrintNums(String str)
    {
    	int i;
    	
    	System.out.println(str);
    	
    	for (i=1; i<=30; i++)
    	{
    		System.out.print(i+" ");
    	}	
    	System.out.println();
    }
} 

public class DMutexSample { 
    public static void main(String[] args) throws InterruptedException { 
    	ThreadClass_mutex tc1 = new ThreadClass_mutex("[Thread1] ");
    	ThreadClass_mutex tc2 = new ThreadClass_mutex("[Thread2] ");
        tc1.start(); 
        tc2.start();

        ThreadClass_mutex.lock.lock(); //�ּ� ó��
    	try {        
    		ThreadClass_mutex.PrintNums("[Main]");
    	}
    	finally
    	{
    		ThreadClass_mutex.lock.unlock(); //�ּ� ó��
    	}
        
        tc1.join(300);
        //tc1.join(3000);  //3s�ڿ� thread ���� 
        tc2.join();
    } 
}