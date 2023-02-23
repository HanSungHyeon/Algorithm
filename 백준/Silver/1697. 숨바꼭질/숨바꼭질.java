import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int v;
		int time;

		public Node(int v, int time) {
			this.v = v;
			this.time = time;
		}
	}

	static List<Integer>[] list;
	static boolean[] flag;
	static int n, k, ans = 0,tmp = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		if(n > k) tmp = n;
		else tmp = k;
		list = new ArrayList[tmp + 2];
		flag = new boolean[tmp + 2];
		for (int i = n; i <= tmp + 1; i++)
			list[i] = new ArrayList<>();
		
		bfs(n);
		System.out.println(ans);
	}

	public static void bfs(int node) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(node, 0));
		flag[node] = true;

		while (!q.isEmpty()) {
			int v = q.peek().v;
			int t = q.peek().time;
			q.poll();
//			System.out.println("v:" + v + " t:" + t);
			if (v == k) {
				ans = t;
				break;
			}

			if (v + 1 <= tmp + 1 && !flag[v + 1]) {
				flag[v + 1] = true;
				q.add(new Node(v + 1, t + 1));
			}
			if (v - 1 >= 0 && !flag[v - 1]) {
				flag[v - 1] = true;
				q.add(new Node(v - 1, t + 1));
			}
			if (v * 2 <= tmp + 1 && !flag[v * 2]) {
				flag[v * 2] = true;
				q.add(new Node(v * 2, t + 1));
			}
		}
	}
}