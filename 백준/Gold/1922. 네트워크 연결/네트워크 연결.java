/*
컴퓨터 연결 비용을 최소로 해야함
최소신장트리
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
	static int n, m;
	static int[] parent;
	static List<Node> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		for(int i = 1; i <= n; i++) parent[i] = i;

		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			list.add(new Node(from, to, edge));
		}
		list.sort((o1, o2) -> o1.edge - o2.edge);

		int sum = 0;
		for(Node node : list) {
			if(union(node.from, node.to)) {
				sum += node.edge;
			}
		}
		System.out.println(sum);
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