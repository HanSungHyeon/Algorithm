/*
end자리를 더했을 때
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int[] arr, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		count = new int[100001];
		System.out.println(twoPointer());

	}

	static int twoPointer() {
		int start = 0;
		int end = 0;
		int ans = 0;

		while(start < n && end < n) {
			//k이하
			if(count[arr[end]] < k) {
				//1개 증가
				count[arr[end]]++;
				ans = Math.max(ans, end - start + 1);
				end++;
			}
			//k개 초과해버림
			else {
				//앞에꺼 하나 빼버리고
				count[arr[start]]--;
				start++;
				ans = Math.max(ans, end - start + 1);
			}
		}

		return ans;
	}
}