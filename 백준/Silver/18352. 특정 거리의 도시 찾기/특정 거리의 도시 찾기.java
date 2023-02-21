import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] list;
	static boolean[]flag;
	static int x, n, m, k;
	static Queue<Node> q = new LinkedList<>();
	static List<Integer> ans = new ArrayList<>();
	static class Node {
		int x;
		int r;

		public Node(int x, int r) {
			this.x = x;
			this.r = r;
		}
	}

	public static void bfs(int start) {
		
		q.add(new Node(start, 0));
		flag[start] = true;

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int dir = q.peek().r;
			q.poll();
			if(dir == k) ans.add(x);
			for(int i : list[x]) {
				if(!flag[i]) {
					flag[i] = true;
					q.add(new Node(i,dir + 1));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());


		flag = new boolean[n + 1];
		list = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i ++)
			list[i] = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
		}
		bfs(x);
		
		if(ans.size() == 0)
			System.out.println(-1);
		else {
			ans.stream().sorted().forEach(v -> sb.append(v).append("\n"));
			System.out.println(sb);
		}
		
	}
}