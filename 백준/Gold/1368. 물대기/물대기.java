/*

 */
import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int from, to, edge;
		public Node(int from, int to, int edge) {
			this.from = from;
			this.to = to;
			this.edge = edge;
		}
	}
	static int n;
	static int[] parent, water;
	static List<Node> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		parent = new int[n + 2];
		for(int i = 1; i <= n + 1; i++) parent[i] = i;

		for(int i = 1; i <= n; i++) {
			list.add(new Node(i, parent.length - 1, Integer.parseInt(br.readLine())));
		}

		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				int edge = Integer.parseInt(st.nextToken());
				if(i == j) continue;
				list.add(new Node(i, j, edge));
			}
		}
		list.sort((o1, o2) -> o1.edge - o2.edge);

		int ans = 0;
		int count = 0;
		for(Node node : list) {
			if(union(node.from, node.to)) {
				ans += node.edge;
			}
			if(count == n - 1) break;
		}
		System.out.println(ans);
	}

	static int find(int num) {
		if(parent[num] == num) return num;

		return parent[num] = find(parent[num]);
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if(a == b) return false;

		parent[b] = a;
		return true;
	}
}