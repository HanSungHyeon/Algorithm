import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = 1;
		while (tc < 11) {
			int dump = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			while (dump-- > 0) {
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				int maxIdx = 0;
				int minIdx = 0;
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] > max) {
						max = arr[i];
						maxIdx = i;
					}
					if (arr[i] < min) {
						min = arr[i];
						minIdx = i;
					}
				}
				arr[maxIdx]--;
				arr[minIdx]++;
			}
			int result = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();

			sb.append("#" + tc + " " + result + "\n");
			tc++;
		}

		System.out.println(sb);
	}
}