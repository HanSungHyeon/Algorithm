import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr, result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		result = new int[m];
		
		p(0);
		System.out.println(sb);
	}

	private static void p(int num) {
		if(num == m) {
			if(isCheck()) {
				for(int i : result) sb.append(i + " ");
				
				sb.append("\n");
			}
			return;
		}
		
		for(int i =0 ; i < n; i++) {
			result[num] = arr[i];
			p(num + 1);
		}
	}
	
	private static boolean isCheck() {
		for(int i =1 ; i< m; i++) 
			if(result[i - 1] > result[i]) return false;	
		
		return true;
	}
		
}