import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int node,edge;
		public Node(int node, int edge) {
			this.node = node;
			this.edge = edge;
		}
	}
	static int n;
	static List<Node>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();
		 
		for(int i = 0 ; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,edge));
			list[to].add(new Node(from,edge));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i =0 ;i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(k,start) + "\n");
		}
		System.out.println(sb);
	}
	private static int bfs(int k, int start) {
		boolean[] flag = new boolean[n + 1];
		flag[start] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		int count = 0;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(Node n : list[node]) {
				if(!flag[n.node] && n.edge >= k) {
					flag[n.node] = true;
					count++;
					q.add(n.node);
				}
			}		
		}
		return count;
	}
}