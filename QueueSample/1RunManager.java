package com.lgcns.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RunManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> listMsg = new ArrayList<String>();

		/*
		 * listMsg.add("1"); listMsg.add("2"); listMsg.add("3");
		 * 
		 * System.out.println(listMsg.get(0)); listMsg.remove(0);
		 * 
		 * System.out.println(listMsg.get(0));
		 */

		Scanner sc = new Scanner(System.in);

		while (true) {
			String line = sc.nextLine();
			String[] words = line.split(" ");

			String cmd = words[0];

			switch (words[0]) {
			case "SEND":
				// String msg = words[1];
				listMsg.add(words[1]);
				break;

			case "RECEIVE":

				if (listMsg.size() > 0) {
					System.out.println(listMsg.remove(0));
				}

				break;

			default:
				break;
			}

		}

	}

}
