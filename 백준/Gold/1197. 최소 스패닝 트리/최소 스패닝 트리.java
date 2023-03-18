import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int from, to, cost;

		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node node) {
			return this.cost - node.cost;
		}

	}

	static int v, e;
	static List<Node> list = new ArrayList<>();
	static int[] parents;

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;

		parents[b] = a;
		return true;
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;

		return parents[a] = find(parents[a]);
	}

	// 부모
	private static void makeSet() {
		for (int i = 1; i <= v; i++)
			parents[i] = i;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		parents = new int[v + 1];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list.add(new Node(from, to, cost));
		}
		Collections.sort(list);

		makeSet();

		int ans = 0;

//		for (Node node : list) {
//			if (find(node.from) != find(node.to)) {
//				ans += node.cost;
//				union(node.from, node.to);
//			}
//		}
		
		int count = 0;
		for (Node node : list) {
			if (union(node.from, node.to)) {
				ans += node.cost;
				count++;
			}
			if(count == v - 1) break;
		}

		System.out.println(ans);
	}
}