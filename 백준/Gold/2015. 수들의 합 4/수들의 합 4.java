/*
* s ~ e 부분합 -> sum[e] - sum[s - 1]
* s ~ e 부분합 = k -> sum[e] - sum[s - 1] = k
* 즉 -> sum[e] - k = sum[s - 1]
* */
import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());


		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = arr[i - 1] + num;
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		long count = 0;
		for (int i = 1; i <= n; i++) {
			if(map.containsKey(arr[i] - k)) {
				count += map.get(arr[i] - k);
			}
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		System.out.println(count);
	}
}