/*
*
* */

import java.io.*;
import java.util.*;

class Main {
	static class Node {
		int s, num;
		public Node(int s, int num) {
			this.s = s;
			this.num = num;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Node> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		int sum = 0;

		for(int i = 1; i <= 8; i++) {
			int s = Integer.parseInt(br.readLine());
			list.add(new Node(s, i));
		}

		list.sort((o1, o2) -> o2.s - o1.s);
		for(int i = 0; i < 5; i++) {
			list2.add(list.get(i).num);
			sum += list.get(i).s;
		}
		sb.append(sum).append("\n");

		list2.sort((o1, o2) -> o1 - o2);
		for(int num : list2) {
			sb.append(num + " ");
		}

		System.out.println(sb);
	}
}
