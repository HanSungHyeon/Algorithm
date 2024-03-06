/*
n <= 2000
자기 자신은 제외
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(binarySearch(arr[i], i)) ans++;
		}
		System.out.println(ans);

	}
	static boolean binarySearch(long target, int idx) {
		int start = 0;
		int end = n - 1;
		while(start < end) {
			long num = arr[start] + arr[end];

			//더한 값이 타겟보다 작다면?
			if(num < target) start++;

			else if(num > target) end--;

			else {
				if(start == idx) start++;

				else if(end == idx) end--;

				else return true;
			}
		}
		return false;
	}

}