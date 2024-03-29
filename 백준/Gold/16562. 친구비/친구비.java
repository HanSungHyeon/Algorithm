import java.io.*;
import java.util.*;

public class Main {
	static int n,m,k;
	static int[] parent, cost, p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		cost = new int[n + 1];
		p = new int[n + 1];
		for(int i = 1; i <= n; i++) parent[i] = i;

		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		//집합 만들기
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			//해당 집합에서 가장 적은 비용 get
			union(a,b);
		}

		int ans = 0;
		//루트 노드가 최소 금액임
		for(int i = 1; i <= n; i++) {
			if(parent[i] == i) {
				ans += cost[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		if(ans <= k) sb.append(ans);
		else sb.append("Oh no");

		System.out.println(sb);
	}
	static int find(int num) {
		if(parent[num] == num) return num;

		return parent[num] = find(parent[num]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		//합칠 때 비용 더 적은 쪽이 루트가 될 수 있게끔
		if(a != b) {
			if(cost[a] > cost[b]) {
				parent[a] = b;
			}
			else parent[b] = a;
		}
	}
}