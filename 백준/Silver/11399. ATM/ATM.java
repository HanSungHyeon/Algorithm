import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

		int sum = 0;
		int tmp = 0;
		for (int i : arr) {
			tmp += i;
			sum += tmp;
		}
		System.out.println(sum);
	}
}