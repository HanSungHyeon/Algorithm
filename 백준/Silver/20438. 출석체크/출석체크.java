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

		//출석 안한 사람 전부 더함
		int[] noCheck = new int[n + 3];
		for(int i = 3; i< noCheck.length; i++) {
			noCheck[i] = noCheck[i - 1];
			if(arr[i] == 0) noCheck[i]++;
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			sb.append(noCheck[e] - noCheck[s - 1]).append("\n");
		}
		System.out.println(sb);
	}
}