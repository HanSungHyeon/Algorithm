import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[1] == o2[1]) return o1[0] - o2[0];

			return o1[1] - o2[1];

		});

		int count = 1;
		int endTime = arr[0][1];

		for (int i = 1; i < n; i++) {
			if (arr[i][0] >= endTime) {
				endTime = arr[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}