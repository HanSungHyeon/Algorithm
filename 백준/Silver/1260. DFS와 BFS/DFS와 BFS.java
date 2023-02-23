import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] list;
	static boolean[] flag;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		flag = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			list[to].add(from);
		}
		for (int i = 1; i <= n; i++)
			Collections.sort(list[i]);
		dfs(v);
		sb.append("\n");
		flag = new boolean[n + 1];
		bfs(v);
		System.out.println(sb);
	}

	public static void dfs(int node) {
		flag[node] = true;
		sb.append(node + " ");

		for (int i : list[node]) {
			if (!flag[i])
				dfs(i);
		}
	}
	public static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		flag[node] = true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			sb.append(v + " ");
			
			for(int i : list[v]) {
				if(!flag[i]) {
					flag[i] = true;
					q.add(i);
				}
			}
		}
	}
}