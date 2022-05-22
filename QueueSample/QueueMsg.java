package com.lgcns.test;

import java.util.ArrayList;
import java.util.List;

public class QueueMsg {

	private int size;
	private int count = 0; // »£√‚ index

	private List<String> listMsg;
	private boolean boo;

	// = new ArrayList<String>();

	public void createQueue(int size, List<String> queue) {
		this.size = size;
		this.listMsg = queue;

	}

	public boolean inputQueueMsg(String msg) {

		if (listMsg.size() == size) {
			boo = false;
		} else {
			boo = true;
			listMsg.add(msg);
		}

		return boo;

	}

	public String[] getQueueMsg(String queNM) {
		String[] res = new String[2];

//		System.out.println("count1 : " + res.length + " : " + count);

		if (listMsg.size() > 0 && listMsg.size() > count) {
			res[0] = Integer.toString(count);
			res[1] = listMsg.get(count);
			count++;
//			System.out.println("count2 : " + res.length + " : " + count);
		}else {
			res[0] = "-1";
			res[1] = "No Message";
		}

		return res;
	}
	
	public void outputFailMsg(int msgID) {
		
		count --;
		//String preStr = listMsg.get(msgID);
		//listMsg.add(count, preStr);
		
	
		
		
	}

	public String outputQueueMsg(int msgID) {

		String ret = "";

		if (listMsg.size() > 0) {
			//ret = listMsg.remove(msgID);
			ret = listMsg.remove(0);
		}

		return ret;

	}

}
