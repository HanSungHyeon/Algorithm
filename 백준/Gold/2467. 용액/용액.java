/*
두 수를 더한 값이 양수면 end 땡김
두 수를 더한 값이 음수면 start 땡김
 */

import java.io.*;
import java.util.*;

public class Main {
	static long min = Long.MAX_VALUE, l, r;
	static int n;
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

		binarySearch();
		System.out.println(l + " " + r);

	}
	static void binarySearch() {
		int start = 0;
		int end = arr.length - 1;

		while(start < end) {
			long sum = arr[start] + arr[end];

			 if(Math.abs(min) > Math.abs(sum)) {
				 min = sum;
				 l = arr[start]; r = arr[end];
			 }

			 if(sum > 0) end--;
			 else if(sum < 0) start++;
			 else break;
		}
	}
}