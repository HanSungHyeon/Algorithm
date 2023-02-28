import java.io.*;
import java.util.*;

public class Solution {
	static boolean[] flag;
	static List<Integer>[] list;
	static int[] result;

	static class Node {
		int node, count;

		public Node(int node, int count) {
			this.node = node;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");

			flag = new boolean[101];
			list = new ArrayList[101];

			for (int i = 1; i <= 100; i++)
				list[i] = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//			System.out.println(arr[42] + " " + arr[41]);
//			System.out.println(Arrays.toString(arr));
			for (int i = 0; i < n; i += 2) {
				int from = arr[i];
				int to = arr[i + 1];

				list[from].add(to);
			}
			bfs(m, 1);

			int max = Arrays.stream(result).max().getAsInt();
			for (int i = result.length - 1; i >= 0; i--)
				if (result[i] == max) {
					sb.append(i + "\n");
					break;
				}
			
//			System.out.println(Arrays.toString(result));
//			System.out.println("------------------------------");
		}
		System.out.println(sb);
	}

	public static void bfs(int node, int count) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(node, count));
		flag[node] = true;
		result = new int[102];
		while (!q.isEmpty()) {
			int n = q.peek().node;
			int c = q.peek().count;
			q.poll();
			result[n] = c;
			for (int i : list[n]) {
				if (!flag[i]) {
					flag[i] = true;
					q.add(new Node(i, c + 1));
				}
			}
		}
	}
}