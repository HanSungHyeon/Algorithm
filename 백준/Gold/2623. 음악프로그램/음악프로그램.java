/*
위상 정렬
순서 정하기가 불가능할 경우가 존재함
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static List<Integer>[] list;
	static int[] degree;

	static List<Integer> ans = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		degree = new int[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();


		for (int i = 0; i < m; i++) {
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			for (int j = 1; j < arr.length - 1; j++) {
				list[arr[j]].add(arr[j + 1]);
				degree[arr[j + 1]]++;
			}
		}
		topological();
		StringBuilder sb = new StringBuilder();
		if (ans.size() != n) sb.append(0);
		else {
			for (int i : ans) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

	static void topological() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0) q.add(i);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			ans.add(cur);
			for (int i : list[cur]) {
				degree[i]--;
				if (degree[i] == 0) q.add(i);
			}
		}
	}
}