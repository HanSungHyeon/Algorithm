import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int time, node;
		public Node(int node, int time) {
			this.time = time;
			this.node = node;
		}
	}

	static int n;
	static int[] degree, times;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		degree = new int[n + 1];
		times = new int[n + 1];
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();

		for (int from = 1; from <= n; from++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			times[from] = time;

			int count = Integer.parseInt(st.nextToken());
			for(int j = 0; j < count; j++) {
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				degree[to]++;
			}
		}
		int ans = topological();
		System.out.println(ans);
	}
	static int topological() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.time - o2.time);
		int num = 0;
		for(int i = 1; i <= n; i++) {
			if(degree[i] == 0) pq.add(new Node(i, times[i]));
		}

		while(!pq.isEmpty()) {
			int cur = pq.peek().node;
			int time = pq.peek().time;
			num = time;
			pq.poll();

			for(int i : list[cur]) {
				degree[i]--;
				if(degree[i] == 0) pq.add(new Node(i,times[i] + time));
			}
		}
		return num;
	}
}