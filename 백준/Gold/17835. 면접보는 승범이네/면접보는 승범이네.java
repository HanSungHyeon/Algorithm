/*
다익스트라
문제 입력 역방향으로 세팅
단방향
애초에 반대로 입력 받아오고
면접장 수만큼 돌려버림
도시 <= 100,000
도로 개수 <= 500,000
도로 길이 <= 100,000
면접장 <= 도시
도로 개수가 50만이고 전부 길이는 10만이라면
83%?????????????????
 */
import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int node;
		long edge;
		public Node(int node, long edge) {
			this.node = node;
			this.edge = edge;
		}
	}
	static int n,m,k;
	static long INF = Long.MAX_VALUE;
	static long[] dist;
	static List<Node>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dist = new long[n + 1];
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			dist[i] = INF;
			list[i] = new ArrayList<>();
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());

			list[from].add(new Node(to, edge));
		}

		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int start = Integer.parseInt(st.nextToken());
			dijkstra(start);
		}

		//면접장까지 거리가 가장 먼 도시
		//여러 개면은 가장 작은 번호
		StringBuilder sb = new StringBuilder();
		long max = Arrays.stream(dist).max().getAsLong();
		for(int i = 1; i <= n; i++) {
			if(dist[i] == max) {
				sb.append(i).append("\n");
				break;
			}
		}
		sb.append(max);
		System.out.println(sb);
	}
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.edge, o2.edge));
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while(!pq.isEmpty()) {
			int cur = pq.peek().node;
			long edge = pq.peek().edge;
			pq.poll();

			if(dist[cur] != edge) continue;

			for(Node next : list[cur]) {
				if(dist[next.node] > dist[cur] + next.edge) {
					dist[next.node] = dist[cur] + next.edge;
					pq.add(new Node(next.node, dist[next.node]));
				}
			}
		}
	}
}