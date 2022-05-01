package sp_class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


/*
 * 2.1 List �ǽ�
 * 
 * 		���� ���� ����
 * Kim	80	70	90
 * Lee	95	89	92
 * Park	88	70	94
 * Choi	70	100	92
 * Moon	100	80	93
 * Rho	62	99	88
 * Byun	71	98	77
 * Kang	62	73	81
 * Cho	99	85	66
 * Hong	62	70	92
 * 
 * 1. console.�� PRINT �Է½� �̸��� (��������)���� ���
 * 2. KOREAN, ENGLISH, MATH �Է½� ������ (��������) - ���Ͻ� �������� ���� 
 * 
 *  ArrayList<Grade> al = new ArrayList<Grade>(); 	// ����
 *  al.add(g);										// �߰�
 *  al.remove(index);
 * 
 * 
 * 
 * // console �Է� input 
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
 * String strInput = br.readLine(); //�Է� �� enter
 * 
 * 
 * 
 */

public class BListPrac {
    public static void main(String[] args) throws IOException {
        ArrayList<Grade> al = new ArrayList<Grade>();
       
        try {
            ////////////////////////////////////////////////////////////////
        	// BufferedReader in = new BufferedReader(new FileReader("List_Sample.txt"));
            BufferedReader in = new BufferedReader(new FileReader("D:\\����\\sp�⺻\\2.list_map_queue\\List_Sample.txt"));
            String str;

            while ((str = in.readLine()) != null) {  //�� line �� ����
                String words[] = str.split("\t");
                Grade g = new Grade(words[0],Integer.parseInt(words[1]),Integer.parseInt(words[2]),Integer.parseInt(words[3]));
                al.add(g);
                //al.remove(0);
            }
            in.close();
            ////////////////////////////////////////////////////////////////
        } catch (IOException e) {
            System.err.println(e); // ������ �ִٸ� �޽��� ���
            System.exit(1);
        }
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String strInput = br.readLine();
           
            switch(strInput) {
            case "PRINT": // �̸� �� ���
                Collections.sort(al, (g1, g2) -> g1.getName().compareTo(g2.getName()));
                break;
            case "KOREAN": // ���� ���� �� ���
                // Lambda��
                Collections.sort(al, (g1, g2) -> (g2.getKorean() - g1.getKorean()) == 0 ? g1.getName().compareTo(g2.getName()) : g2.getKorean() - g1.getKorean());                
                break;
            case "ENGLISH": // ���� ���� �� ���
                // Comparator
                Collections.sort(al, new Comparator<Grade>() {

                    @Override
                    public int compare(Grade x, Grade y) {
                        if (y.getEnglish() - x.getEnglish() == 0)
                        {
                            return x.getName().compareTo(y.getName());
                        }
                        else
                        {
                            return y.getEnglish() - x.getEnglish();
                        }
                    }
                   
                });                
                break;
            case "MATH":
                // Comparator
                Collections.sort(al, new sortByMath());                
                break;
			case "QUIT":
				return;
			default:
				break;
            }
           
            for (Grade val : al)
            {
                System.out.println(String.format("%s\t%d\t%d\t%d",val.getName(), val.getKorean(), val.getEnglish(), val.getMath()));
            }                
        }  
    }  
}

// getter setter 

class Grade
{
    private String strName;
    private int Korean;
    private int English;
    private int Math;

    public Grade(String str, int k, int e, int m)
    {
        strName = str;
        Korean = k;
        English = e;
        Math = m;
    }

    public String getName()
    {
        return strName;
    }
    public void setName(String strName)
    {
        this.strName = strName;
    }
    public int getKorean()
    {
        return Korean;
    }
    public void setProjectA(int n)
    {
        Korean = n;
    }
    public int getEnglish()
    {
        return English;
    }
    public void setProjectB(int n)
    {
        English = n;
    }
    public int getMath()
    {
        return Math;
    }
    public void setMath(int n)
    {
        Math = n;
    }
}

class sortByMath implements Comparator<Grade>{
    public int compare(Grade x, Grade y) {
        if (y.getMath() - x.getMath() == 0)
        {
            return x.getName().compareTo(y.getName());
        }
        else
        {
            return y.getMath() - x.getMath();
        }
    }
}