import java.io.*;
import java.util.*;

public class Main {
	static int n, q;
	static int[] arr, miss;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		miss = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}

		//실수 횟수 누적
		for(int i = 1; i < n; i++) {
			miss[i] += miss[i - 1];

			if(arr[i] > arr[i + 1]) {
				miss[i]++;
			}
		}
		miss[n] = miss[n - 1];

		StringBuilder sb = new StringBuilder();
		q = Integer.parseInt(br.readLine());
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			sb.append(miss[e - 1] - miss[s - 1]).append("\n");
		}
		System.out.println(sb);
	}
}