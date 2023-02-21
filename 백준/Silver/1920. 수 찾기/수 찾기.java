import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens())
			sb.append(binarySearch(a, Integer.parseInt(st.nextToken()))).append("\n");
		System.out.println(sb);
	}

	public static int binarySearch(int[] arr, int find) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (arr[mid] < find)
				start = mid + 1;
			else if (find < arr[mid])
				end = mid - 1;
			else
				return 1;
		}
		return 0;
	}
}