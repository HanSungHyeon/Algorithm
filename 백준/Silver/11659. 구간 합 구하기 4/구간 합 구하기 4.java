import java.io.*;
import java.util.*;

public class Main {
	static int[] d;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1];
		d = new int[arr.length + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
			
		sum();
		
		for (int z = 0; z < m; z++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			sb.append(cal(i,j) + "\n");
		}
		System.out.println(sb);
	}
	
	public static void sum() {
		d[1] = arr[1];
		
		for(int i = 1; i < arr.length; i++) 
			d[i] = arr[i] + d[i - 1];
	}
	
	public static int cal(int i, int j) {
		return d[j] - d[i - 1];
	}
}