import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr, ans;
	static boolean[] flag;
	static boolean f;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		ans = new int[n][n];
		flag = new boolean[n];
		for (int i = 0; i < n; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Arrays.fill(flag,false);
				f = false;
				if(dfs(i,j,0)) ans[i][j] = 1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < n; i++) {
			Arrays.stream(ans[i]).forEach(x -> sb.append(x + " "));
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	private static boolean dfs(int start, int end,int count) {
		if(arr[start][end] == 1) 
			return f = true;
		
		for(int i = 0; i < n; i++) {
			if(arr[start][i] == 1 && !flag[i]) {
				flag[i] = true;
				dfs(i,end,count + 1);
			}
		}
		return f;
	}

}