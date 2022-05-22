package com.lgcns.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class RunManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// List<String> listMsg;

		LinkedHashMap<String, QueueMsg> queues = new LinkedHashMap<String, QueueMsg>();

		Scanner sc = new Scanner(System.in);

		while (true) {
			String line = sc.nextLine();
			String[] words = line.split(" ");

			String cmd = words[0];
			String queueNM;
			int size;

			switch (words[0]) {
			case "CREATE":

				queueNM = words[1];
				size = Integer.parseInt(words[2]);
				List<String> listMsg = new ArrayList<String>();

				// queues
				QueueMsg qm = new QueueMsg();
				qm.createQueue(size, listMsg);

				if (queues.containsKey(queueNM)) {
					System.out.println("Queue Exist");
				} else {
					queues.put(queueNM, qm);
				}

				// listMsg

				break;

			case "SEND":
				// String msg = words[1];
				queueNM = words[1];
				if (!queues.get(queueNM).inputQueueMsg(words[2])) {
					System.out.println("Queue Full");
				}

				break;

			case "RECEIVE":
				
				queueNM = words[1];
				/*
				if(!queues.containsKey(queueNM)) {
					System.out.println("");
				}
				*/
				
				System.out.println(queues.get(queueNM).outputQueueMsg(queueNM));
				

				break;

			default:
				break;
			}

		}

	}

}
