import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int start = 0;
		int end = 0;
		int sum = arr[start];
		int count = 0;

		while (start < n) {
			if (sum < m) {
				end++;
				if (end >= n) break;
				sum += arr[end];
			} else if (sum == m) {
				count++;
				sum -= arr[start++];
			} else
				sum -= arr[start++];
		}
		System.out.println(count);
	}
}