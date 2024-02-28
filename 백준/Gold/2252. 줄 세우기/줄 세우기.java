/*
줄 세우기
A B가 입력으로 주어짐
A가 B 앞에 서야함
앞 : 1 뒤 3
앞 : 2 뒤 3
그래프로 그렸을 때
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static List<Integer>[] list;
	static int[] degree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		degree = new int[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			degree[to]++;
		}
		topological();
		System.out.println(sb);
	}

	static void topological() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0) q.add(i);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for (int i : list[cur]) {
				degree[i]--;
				if (degree[i] == 0) q.add(i);
			}
		}
	}
}