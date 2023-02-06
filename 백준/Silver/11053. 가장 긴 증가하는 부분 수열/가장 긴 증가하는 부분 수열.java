import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		d = new int[arr.length];
		d[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				int max = Integer.MIN_VALUE;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && d[j] > max) {
						max = d[j];
						d[i] = d[j] + 1;
//						System.out.println(d[i]);
					}
				}
			} else {
				int max = Integer.MIN_VALUE;
				int count = 0;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && d[j] > max) {
						max = d[j];
						d[i] = d[j] + 1;
					}
					else count++;
					
					if(count == i) d[i] = 1;
				}
			}
		}
		//System.out.println(Arrays.toString(d));
		System.out.println(Arrays.stream(d).max().getAsInt());
	}
}