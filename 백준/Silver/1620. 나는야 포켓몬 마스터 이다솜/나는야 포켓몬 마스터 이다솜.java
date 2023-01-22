import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		 
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] arr =new String[n +1];
        Map<String, Integer> map = new HashMap<>();
		
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			map.put(str,i);
			arr[i] = str;
		}

		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			try {
				int cast = Integer.parseInt(input);
				sb.append(arr[cast] + "\n");

			} catch (Exception e) {
				sb.append(map.get(input) + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}