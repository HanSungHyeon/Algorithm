/*
0 -> 합집합
1 -> 같은 집합인지 확인
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for(int i = 1; i <= n; i++) parent[i] = i;

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int check = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(check == 0) union(a,b);
			else {
				if(find(a) == find(b)) sb.append("YES");
				else sb.append("NO");
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static int find(int num) {
		if(parent[num] == num) return num;

		return parent[num] = find(parent[num]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if(a != b) parent[b] = a;
	}

}