import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static boolean[] flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		flag = new boolean[n + 1];

		System.out.println(twoPointer());
	}
	static long twoPointer() {
		int start = 0;
		int end = 0;
		long count = 0;
		while(start < n) {
			while(end < n && !flag[arr[end]]) {
				//방문처리하고 다음 요소 확인
				flag[arr[end++]] = true;
			}
			//중복된 거 미방문처리
			flag[arr[start]] = false;
			//중복되지 않은 경우 카운팅
			//연속된 수들임
			count += (end - start);
			start++;
		}
		return count;
	}
}
