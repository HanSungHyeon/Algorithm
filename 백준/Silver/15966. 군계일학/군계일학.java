import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		HashMap<Integer, Integer> map = new HashMap<>();

		int max = 0;
		for (int i = 0; i < n; i++) {
			int current = arr[i];
			// 현재 값의 바로 이전 값이 map에 있다면, 이전 값의 최대 길이 + 1, 없다면 1
			map.put(current, map.getOrDefault(current - 1, 0) + 1);
			max = Math.max(max, map.get(current));
		}
		System.out.println(max);
	}
}