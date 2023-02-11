import java.io.*;
import java.util.*;

public class Main {
	static int[] flag;
	static List<Integer>[] list;
	static int count = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		list = new LinkedList[node + 1];
		flag = new int[node + 1];

		for (int i = 0; i <= node; i++)
			list[i] = new LinkedList<>();

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			list[to].add(from);
		}
		for (int i = 0; i < node; i++)
			Collections.sort(list[i]);

		dfs(start);

		for(int i = 1; i < flag.length; i++)
			System.out.println(flag[i]);
	}

	public static void dfs(int node) {
		flag[node] = count++;

		for (int i : list[node]) {
			if (flag[i] == 0)
				dfs(i);
		}
	}
}