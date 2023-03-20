import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static List<Integer>[] list;
	static boolean[] flag;
	
	private static void dfs(int node) {
		flag[node] = true;
		
		for(int i : list[node]) {
			if(!flag[i]) dfs(i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		flag = new boolean[n + 1];
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 0 ; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		int ans = 0;
		for(int i = 1; i <= n; i++) {
			if(!flag[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
}