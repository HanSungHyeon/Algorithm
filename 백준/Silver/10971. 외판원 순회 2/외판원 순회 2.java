import java.io.*;
import java.util.*;

public class Main {
	static int n,ans = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		flag = new boolean[n];
		for (int i = 0; i < n; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		dfs(0,0,0);
		System.out.println(ans);
	}
	
	private static void dfs(int idx, int depth, int sum) {
		//System.out.println("idx : " + idx + " depth : "+ depth + " sum : " + sum);
		if(depth == n) {
			
			ans = Math.min(ans,sum);
			return;
		}
		
		if(sum >= ans) return;
		
		//다시 원래의 도시로 되돌아감
		if(depth == n - 1) {
			if(arr[idx][0] > 0)
				dfs(0,depth + 1, sum + arr[idx][0]);
			else return;
		}
			
			
		
		for(int i = 0 ; i < n; i++) {
			if(arr[idx][i] == 0) continue;
			if(!flag[i]) {
				flag[idx] = true;
				dfs(i,depth + 1, sum + arr[idx][i]);
				flag[idx] = false;
			}
		}
	}
}