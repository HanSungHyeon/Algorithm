import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int a = 1; a <= tc; a++) {
			double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).sorted().toArray();
			double sum = 0;
			for (int i = 1; i < arr.length - 1; i++) {
				sum += arr[i];
			}
			System.out.println("#" + a + " " + Math.round(sum / (arr.length - 2)));

		}
	}
}