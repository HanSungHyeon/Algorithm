import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] degree;
	static List<Integer>[] list;
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
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			degree[to]++;
		}
		topological();
		System.out.println(sb);
	}

	static void topological() {
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0) pq.add(i);
		}

		while (!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur).append(" ");

			for (int i : list[cur]) {
				degree[i]--;
				if (degree[i] == 0) pq.add(i);
			}
		}
	}
}