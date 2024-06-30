import java.io.*;
import java.util.*;

public class Main {
	static int n, k, q, m;
	static int[] arr;
	static boolean[] sleep;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 3];
		sleep = new boolean[50001];

		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < k; i++) {
			int sleepIdx = Integer.parseInt(st.nextToken());
			sleep[sleepIdx] = true;
		}

		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < q; i++) {
			int student = Integer.parseInt(st.nextToken());

			if(sleep[student]) continue;

			int num = 1;
			for(int j = student; j < arr.length; j = student * num) {
				if(!sleep[j]) {
					arr[j]++;
				}
				num++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			int count = 0;
			for(int j = s; j <= e; j++) {
				if(arr[j] == 0) count++;
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}