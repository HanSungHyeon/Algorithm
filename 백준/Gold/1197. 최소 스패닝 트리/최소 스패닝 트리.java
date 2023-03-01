import java.io.*;
import java.util.*;

public class Main {
	static int v, e;
	static int[] p; 
	static Edge[] edgeList;
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int line;
		public Edge(int from , int to, int line) {
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

		StringTokenizer st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		p = new int[v];
		edgeList = new Edge[e];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(a,b,c);
		}
		long ans = getMST();
		System.out.println(ans);
	}
	
	private static long getMST() {
		makeSet();
		Arrays.sort(edgeList);
		
		int count = 0;
		long cost = 0;
		for(Edge edge : edgeList) {
			int from = edge.from;
			int to = edge.to;
			int line = edge.line;
			
			boolean result = union(from,to);
			
			if(result) {
				cost += line;
				count++;
			}
			
			if(count == v - 1) break;
		}
		return cost;
	}
	
	private static void makeSet() {
		for(int i = 0; i < v; i++) 
			p[i] = i;
	}
	
	private static int find(int a) {
		if(a == p[a]) return a;
		
		return p[a] = find(p[a]); 
	}
	
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return false;
		
		p[rootB] = rootA;
		return true;
	}
}