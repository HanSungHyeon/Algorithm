import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] list;
	static boolean[] flag;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n];

		for (int i = 0; i < n; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			list[to].add(from);
		}
		flag = new boolean[n];
		for (int i = 0; i < n; i++) {
			if(ans != 4) {
				ans = 0;
				dfs(i, 0);
				flag = new boolean[n];
			}
			else break;
		}
		int result = ans == 4 ? 1 : 0; 
		System.out.println(result);
	}

	public static void dfs(int node, int depth) {
		if(depth == 4) {
			ans = 4;
			return;
		}
		
		flag[node] = true;
		for (int i : list[node]) {
			if (!flag[i]) {
				dfs(i, depth + 1);
				flag[i] = false;
				if(ans == 4) return;
			}
		}
	}
}