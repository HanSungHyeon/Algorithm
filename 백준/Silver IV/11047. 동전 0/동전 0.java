/*
K원을 만드는데 필요한 동전 개수의 최솟값 출력
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			ans += (k / arr[i]);
			k %= arr[i];
		}
		System.out.println(ans);
	}
}
