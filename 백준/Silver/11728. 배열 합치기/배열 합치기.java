/*
* 정렬되어있는 두 배열 A, B
* 두 배열 합치고 정렬
* 1.5
*
* n, m <= 1,000,000
* 1000000000
* */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine(), " ");
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine(), " ");
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		list.sort((o1, o2) -> o1 - o2);

		StringBuilder sb = new StringBuilder();
		for(int i : list) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
