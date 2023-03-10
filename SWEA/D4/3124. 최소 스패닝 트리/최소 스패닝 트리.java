import java.io.*;
import java.util.*;

public class Solution {
	static int[] parents;
	static int v, e;
	static Edge[] edgeList;

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int line;

		public Edge(int from, int to,int line) {
			this.from = from;
			this.to = to;
			this.line = line;
		}

		@Override
		public int compareTo(Edge o) {
			return this.line - o.line;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			parents = new int[v];
			edgeList = new Edge[e];
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());

				edgeList[i] = new Edge(a, b, c);
			}
			makeSet();
			sb.append("#" + t + " " + getMST() + "\n");
			
		}
		System.out.println(sb);
	}

	public static long getMST() {
		long cost = 0;
		int count = 0;
		
		Arrays.sort(edgeList);

		for (Edge edge : edgeList) {
			int from = edge.from;
			int to = edge.to;
			int line = edge.line;
			
			if (count == v - 1) break;

			if (union(from, to)) {
				count++;
				cost += line;
			}
		}
		return cost;
	}

	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB)
			return false;

		parents[rootB] = rootA;
		return true;
	}

	public static int find(int num) {
		if (num == parents[num])
			return num;

		return parents[num] = find(parents[num]);
	}

	public static void makeSet() {
		for (int i = 0; i < v; i++) {
			parents[i] = i;
		}
	}
}