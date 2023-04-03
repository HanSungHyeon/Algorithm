import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		long[] arr = new long[n];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		long start = 1;
		long end = Arrays.stream(arr).max().getAsLong();

		while(start <= end) {
			long mid = (start + end) / 2;

			int count = 0;
			for (long i : arr) {
				count += (i / mid);
			}

			if (count < m) {
				end = mid - 1;
			}
			else if(m <= count) {
				start = mid + 1;
			}
		}
		System.out.println(start - 1);
	}
}