import java.io.*;
import java.util.*;

public class Main {
	static int v, e, start;
	static List<Node>[] list;
	static boolean[] flag;
	static int[] distance;

	static class Vertex implements Comparable<Vertex> {
		int n;
		int w;

		public Vertex(int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.w - o.w;
		}
	}
	
	static class Node{
		int to;
		int weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	private static void dijkstra() {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start, 0));
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		while (!pq.isEmpty()) {
			int cur = pq.peek().n;
			pq.poll();

			if (flag[cur])
				continue;

			flag[cur] = true;

			for(Node node : list[cur]) {
				int to = node.to;
				int weight = node.weight;
				if(!flag[to] && to != 0) {
					distance[to] = Math.min(distance[to],distance[cur] + weight);
					pq.offer(new Vertex(to,distance[to]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		start = Integer.parseInt(br.readLine());
		flag = new boolean[v + 1];
		list = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++)
			list[i] = new ArrayList<>();

		distance = new int[v + 1];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new Node(to,weight));
		}
		dijkstra();
//		System.out.println(Arrays.toString(distance));
		for (int i = 1; i <= v; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				sb.append("INF");
			else
				sb.append(distance[i]);
			sb.append("\n");
		}

		System.out.println(sb);
	}

}