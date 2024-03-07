/*
마을을 두개로 분리하고 싶음

 */
import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int from, to, edge;
		public Node(int from, int to, int edge) {
			this.from = from;
			this.to = to;
			this.edge = edge;
		}
	}
	static int n,m;
	static int[] parent;
	static List<Node> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for(int i = 1; i <= n; i++) parent[i] = i;

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());

			list.add(new Node(from, to, edge));
		}
		list.sort((o1, o2) -> o1.edge - o2.edge);

		long ans = 0;
		int count = 0;
		if(n > 2) {
			for(Node node : list) {
				if(union(node.from, node.to)) {
					ans += node.edge;
					count++;
				}
				if(count == n - 2) break;
			}
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