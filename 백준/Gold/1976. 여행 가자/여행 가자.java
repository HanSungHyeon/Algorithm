/*
1 - 2
2 - 1, 2 - 3
3 - 2
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		for(int i = 1; i <= n; i++) parent[i] = i;
		int m = Integer.parseInt(br.readLine());

		for(int i = 1; i <= n; i++) {
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] == 1) union(i, j + 1);
			}
		}
		boolean flag = true;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int num = Integer.parseInt(st.nextToken());
		while(st.hasMoreTokens()) {
			if(find(num) != find(Integer.parseInt(st.nextToken()))) {
				flag = false;
				break;
			}
		}
		String ans = "NO";
		if(flag) ans = "YES";
		System.out.println(ans);
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