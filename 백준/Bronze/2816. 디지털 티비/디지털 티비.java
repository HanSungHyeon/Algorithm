/*
* 그냥 자리만 바꾸는 문제였음
* */

import java.io.*;
import java.util.*;

class Main {
	static String[] arr;
	static int n, cur;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new String[n];

		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}

		cur = 0;
		//타겟 찾음
		find("KBS1");
		//0번으로 끌어롤림
		replace("KBS1", 0);
		find("KBS2");
		replace("KBS2", 1);

		System.out.println(sb);
	}
	static void find(String t) {
		while(!arr[cur].equals(t)) {
			cur++;
			sb.append(1);
		}
	}

	static void replace(String t, int idx) {
		while(!arr[idx].equals(t)) {
			swap(cur, cur - 1);
			cur--;
			sb.append(4);
		}
	}
	static void swap(int a, int b) {
		String tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
