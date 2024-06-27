import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int num, edge;
		public Node(int num, int edge) {
			this.num = num;
			this.edge = edge;
		}
	}
	static int n, max = 0, start;
	static List<Node>[] list;
	static boolean[] flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];

		for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();

		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());

			list[from].add(new Node(to, edge));
			list[to].add(new Node(from, edge));
		}

		if(n != 1) {
            flag = new boolean[n + 1];
			dfs(1, 0);

			flag = new boolean[n + 1];
			max = 0;
			dfs(start, 0);
        }
        
		System.out.println(max);
	}

	static void dfs(int num, int sum) {
		//이미 방문한 곳이면 돌아감
		if(flag[num]) return;
		
		flag[num] = true;
		if(max < sum) {
			max = sum;
			start = num;
		}

		for(Node node : list[num]) {
			dfs(node.num, sum + node.edge);
		}
	}
}