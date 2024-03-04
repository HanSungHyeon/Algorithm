import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int from, to;

		public Node(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	static int n, m;
	static int[] parent;
	static List<Node> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parent = new int[n + 1];
			list = new ArrayList<>();
			for(int i = 1; i <= n; i++) parent[i] = i;

			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				list.add(new Node(from, to));
			}
			int count = 0;
			for(Node node : list) {
				if(union(node.from, node.to)) {
					count++;
				}
				if(count == n - 1) break;
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
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