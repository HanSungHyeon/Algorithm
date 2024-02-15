import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[10];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int count = 0;
		for (int i = n - 1; i >= 0; i--) {
			if(k == 0) break;
			
			if(k >= arr[i]) {
				int tmp = k / arr[i];
				count += tmp;
				k -= tmp * arr[i];
			}
		}
		System.out.println(count);
	}

}