import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int l = 0; // 왼쪽
		int r = n - 1; // 오른쪽

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

		int sum = Integer.MAX_VALUE;
		int a = 0, b = 0;
		while (l < r) {
			// 두 수의 합이 0에 최대한 가깝게
			int num = arr[l] + arr[r];

			// 양수면 값을 줄여야함 -> 오른쪽을 안쪽으로 당김
			if (num > 0) {
				if (Math.abs(sum) > Math.abs(num)) {
					sum = num;
					a = arr[l];
					b = arr[r];
				}
				r--;
			}
			// 음수면 값을 늘려야함 -> 왼쪽을 안쪽으로 당김
			else if (num <= 0) {
				if (Math.abs(sum) > Math.abs(num)) {
					sum = num;
					a = arr[l];
					b = arr[r];
				}
				l++;
			}
		}
		System.out.println(a + " " + b);
	}
}