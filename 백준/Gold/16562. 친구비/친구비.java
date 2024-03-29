import java.io.*;
import java.util.*;

public class Main {
	static class F {
		int idx, cost;
		public F(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
	static int n,m,k, tmp;
	static boolean[] flag;
	static List<F> f = new ArrayList<>();
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		flag = new boolean[n + 1];
		tmp = k;

		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1; i <= n; i++) {
			f.add(new F(i, Integer.parseInt(st.nextToken())));
		}

		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			list[to].add(from);
		}

		f.sort((o1,o2) -> o1.cost - o2.cost);

		int count = 0;
		for(F friend : f) {
			if(friend.cost <= k && !flag[friend.idx]) {
				count += bfs(friend.cost, friend.idx);
			}
		}
		StringBuilder sb = new StringBuilder();
		if(count == n) sb.append(tmp - k);
		else sb.append("Oh no");
		System.out.println(sb);
	}
	static int bfs(int cost, int idx) {
		Queue<Integer> q = new LinkedList<>();
		flag[idx] = true;
		k -= cost;
		int count = 1;
		q.add(idx);

		while(!q.isEmpty()) {
			int cur = q.poll();

			for(int num : list[cur]) {
				if(flag[num]) continue;

				flag[num] = true;
				q.add(num);
				count++;
			}
		}
		return count;
	}
}