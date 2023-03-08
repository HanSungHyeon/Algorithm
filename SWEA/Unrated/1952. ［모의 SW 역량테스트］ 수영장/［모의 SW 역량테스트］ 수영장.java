import java.io.*;
import java.util.*;

public class Solution {
	static int[] price, month;
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<= tc; i++) {
			price = new int[4];
			price = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			month = new int[12];
			month = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			ans = Integer.MAX_VALUE;
			
			sol(0,0);
			ans = Math.min(ans,price[3]);
			sb.append("#" + i + " " + ans + "\n");
		}
		System.out.println(sb);
		
	}
	private static void sol(int idx,int sum) {
		if(idx >= 12) {
			ans = Math.min(sum,ans);
			return;
		}
		
		
		//1일권 - 10원
		sol(idx + 1, sum + (month[idx] * price[0]));
		//한달권 - 40원
		sol(idx + 1, sum + price[1]);
		//3달권 - 100원
		sol(idx + 3, sum + price[2]);
		
	}
}