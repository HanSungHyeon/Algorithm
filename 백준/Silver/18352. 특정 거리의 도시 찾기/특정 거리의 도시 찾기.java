import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int num, dist;
		public Node(int num , int dist) {
			this.num = num;
			this.dist = dist;
		}
	}
	static int INF = Integer.MAX_VALUE;
	static int n, m, k, x;
	static int[] dist;
	static List<Node>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		dist = new int[n + 1];
		for(int i = 1 ; i <= n; i++) {
			dist[i] = INF;
			list[i] = new ArrayList<>();
		}

		for(int i =0 ; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(new Node(to, 1));
		}
		dijkstra(x);

		int ans = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			if(dist[i] == k) {
				ans++;
				sb.append(i).append("\n");
			}
		}
		if(ans == 0) sb.append(-1);
		System.out.println(sb);
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while(!pq.isEmpty()) {
			int cur = pq.peek().num;
			int d = pq.peek().dist;
			pq.poll();

			if(d != dist[cur]) continue;

			for(Node next : list[cur]) {
				if(dist[next.num] > d + next.dist) {
					dist[next.num] = d + next.dist;
					pq.add(new Node(next.num, dist[next.num]));
				}
			}
		}
	}
}