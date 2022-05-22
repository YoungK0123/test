package com.lgcns.test;

import java.util.ArrayList;
import java.util.List;

public class QueueMsg {

	private int size;

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

	public String outputQueueMsg(String msg) {

		String ret = "";

		if (listMsg.size() > 0) {
			ret = listMsg.remove(0);
		}

		return ret;

	}

}
