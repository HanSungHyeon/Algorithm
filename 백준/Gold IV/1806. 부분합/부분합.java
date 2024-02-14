/*
부분합
연속 된 수를 더했을 떄 m을 넘겨야댐
m넘는 수 중에서 길이가 가장 짧은거
길이 따로 저장 해둠
합이 m은 넘는디 길이 안넘으면 걍 넘어가버림
근데 m을 더하는 그 과정이 순회를 해야하지 않나?
-> 투포인터 O(N)이고 다 더한다고 치면은 O(N) 또 돌아야함
그럼 O(N^2)
합계를 미리 들고 있어야함
end 밀면서 sum 더한 값 그래도 들고 가고 길이도 + 1
start 밀면서 sum 더한 값에서 지꺼 빼고 길이 -1 시켜버림
그럼 부분합 유지 가능
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n, s, sum = 0, len = Integer.MAX_VALUE;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		twoPointer();
		if (len == Integer.MAX_VALUE) len = 0;
		System.out.println(len);
	}

	static void twoPointer() {
		int start = 0;
		int end = 0;
		sum = arr[start];
		while (start < n && end < n) {
			if (sum >= s) {
				len = Math.min(len, end - start + 1);
				sum -= arr[start];
				start++;
			} else {
				end++;
				if (end >= n) break;
				sum += arr[end];

			}
		}
	}
}