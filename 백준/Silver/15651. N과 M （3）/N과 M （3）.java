import java.io.*;
import java.util.*;

public class Main{
	public static int[] arr;
	public static int n;
	public static int m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m + 1];
		recur(0);
		System.out.println(sb);
	}
	public static void recur(int num) {
		if(num == m) {
			for(int i = 0; i < m; i++)
				sb.append(arr[i] + " ");
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			arr[num] = i;
			recur(num + 1);
		}
	}
}