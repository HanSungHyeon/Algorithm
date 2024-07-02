import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1000002];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr[s]++;
			arr[e + 1]--;
		}

		//값 누적
		for(int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}

		int q = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < q; i++) {
			int time = Integer.parseInt(st.nextToken());
			sb.append(arr[time]).append("\n");
		}
		System.out.println(sb);
	}
}