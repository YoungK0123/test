package sp_class;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


/*
 * 2.2 QUEUE �ǽ� 2
 * 
 *  LinkedHashMap<Integer, List<String>> hashMsg ���� ���� 
 *  
 *  //Enqueue �϶� arraylist���� listMsg(0)="A" listMsg(1)=message �Է� 
 * List<String> listMsg = new ArrayList<String>();
 * listMsg.add("A"); // status : available  	
 * listMsg.add(msg); // message        
 * hashMsg.put(seqNo++, listMsg);
 * 
 * 
 * //���� ÷�� key ���
 * int key = (int)hashMsg.keySet().iterator().next();
 * 
 * //key���� msg ���
 * hashMsg.get(key).get(1)  >> arraylist.get(1) 
 * 
 *  //����
 *  hashMsg.remove(key);
 * 
 */

public class BMsgQueue {
    private int size;
    private int seqNo;

    // id - (status, msg)
    private LinkedHashMap<Integer, List<String>> hashMsg; 

    public BMsgQueue(int size)
    {
        this.size = size;
        this.seqNo = 0;
        hashMsg = new LinkedHashMap<Integer, List<String>>();
    }

    public String MsgEnqueue(String msg)
    {
        if (hashMsg.size() == size)
            return "Queue Full";

        List<String> listMsg = new ArrayList<String>();
        listMsg.add("A"); // status : available  �ѹ� get �ѵڿ� �ι� �ٽ� get �� �� ���� 
        listMsg.add(msg); // message
        hashMsg.put(seqNo++, listMsg);

        return "Enqueued";
    }

    public String MsgDequeue()
    {
        if (hashMsg.size() == 0)
            return "Queue Empty";

        int key = (int)hashMsg.keySet().iterator().next();
        
        //System.out.println("test : " + hashMsg.keySet() + " : "+hashMsg.keySet().iterator() + " : "+(int)hashMsg.keySet().iterator().next());
        String res = hashMsg.get(key).get(1) + "(" + key + ")";

        hashMsg.remove(key);

        return res;
    }

    
    public String MsgGet()
    {
        if (hashMsg.size() > 0)
            for(Integer key : hashMsg.keySet())
            {
                if (hashMsg.get(key).get(0).equals("A"))
                {
                	List<String> val = hashMsg.get(key);
                	val.set(0, "U");
                    hashMsg.put(key, val); 
                    return val.get(1) + "(" + key + ")";
                }
            }

        return "No Msg";
    }

    public String MsgSet(int id)
    {
        if (hashMsg.size() > 0)
        {
            if (hashMsg.containsKey(id))
            {
                hashMsg.get(id).set(0, "A");  
                return "Msg Set";
            }
        }

        return "Set Fail";
    }

    
    // DEL Q1 1 
    // queues.get(name).MsgDel(id)
    
    public String MsgDel(int id)
    {
        if (hashMsg.size() > 0)
        {
            if (hashMsg.containsKey(id))
            {
                hashMsg.remove(id);
                return "Deleted";
            }
        }

        return "Not Deleted";
    }
}
