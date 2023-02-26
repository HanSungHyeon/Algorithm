import java.io.*;
import java.util.*;

public class Solution {
	static int ans, n;
	static int[] arr, result;
	
	public static boolean isCheck(int num) {
		char[] tmp = String.valueOf(num).toCharArray();
		
		for(int i = 1; i < tmp.length; i++) {
			if(tmp[i - 1] > tmp[i])
				return false;
		}
		return true;
	}
	
	public static void c(int num,int start) {
		if(num == 2) {
			if(isCheck(result[0] * result[1])) 
				ans = Math.max(ans, result[0] * result[1]);
			
			return;
		}
		for(int i = start; i < n; i++) {
			result[num] = arr[i];
			c(num + 1, i + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			result = new int[2];
			ans = -1;
			arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			c(0,0);
			
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}