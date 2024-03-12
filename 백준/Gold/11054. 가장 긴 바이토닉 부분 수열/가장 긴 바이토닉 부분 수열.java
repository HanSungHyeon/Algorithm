/*
LIS LDS 각각 구하고 합침
합칠 때 자기 자신도 포함되어 있기 때문에 -1
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr, lis, lds;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		lis = new int[n]; lds = new int[n];

		//lis
		for(int i = 0; i < n; i++) {
			lis[i] = 1;
			lds[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
		}
		//lds
		for(int i = n - 1; i >= 0; i--) {
			lds[i] = 1;
			for(int j = n - 1; j > i; j--) {
				if(arr[i] > arr[j]) {
					lds[i] = Math.max(lds[i], lds[j] + 1);
				}
			}
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			int num = lis[i] + lds[i] - 1;
			max = Math.max(num, max);
		}
		System.out.println(max);

	}
}