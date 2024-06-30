import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[1000001];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			arr[x] = g;
		}

		//누적된 값 구하기
		for(int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}

		int ans = arr[arr.length - 1];
		if(k < arr.length) ans = slide();

		System.out.println(ans);
	}
	static int slide() {
		int sum  = 0;
		for(int i = 0; i < arr.length; i++) {
			if(i + k > arr.length - 1) {
				sum = Math.max(sum, arr[arr.length - 1] - arr[i - k - 1]);
			} else if(i <= k) { //
				sum = Math.max(sum, arr[i + k]);
			} else {
				sum = Math.max(sum, arr[i + k] - arr[i - k - 1]);
			}
		}
		return sum;
	}
}