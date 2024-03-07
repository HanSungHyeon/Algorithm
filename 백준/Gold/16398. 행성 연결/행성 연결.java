/*
행성 <= 1000
플로우 관리 비용 <= 100000000

 */

import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int from, to, edge;
		public Node(int from, int to, int edge) {
			this.from =from;
			this.to = to;
			this.edge = edge;
		}
	}
	static int n;
	static List<Node> list = new ArrayList<>();
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		parent = new int[n];
		for(int i = 0; i < n; i++) parent[i] = i;

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < n; j++) {
				list.add(new Node(i, j, Integer.parseInt(st.nextToken())));
			}
		}
		list.sort((o1, o2) -> o1.edge - o2.edge);

		long ans = 0;
		int count = 0;
		for(Node node : list) {
			if(union(node.from, node.to)) {
				ans += node.edge;
				count++;
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