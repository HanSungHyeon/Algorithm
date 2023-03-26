import java.io.*;
import java.util.*;

public class Main {
	static int[] arr, clone;
	static int n;
	static StringBuilder sb = new StringBuilder();
	static HashMap<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		// 원본 배열
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// 배열 깊은 복사 후 오름차순 정렬
		clone = arr.clone();
		Arrays.sort(clone);

		compression();
		
		print();
	}
	private static void print() {
		for(int i : arr) {
			sb.append(map.get(i)).append(" ");
		}
		System.out.println(sb);
	}
	
	/*
	 * 좌표 압축
	 */
	private static void compression() {
		int rank = 0;
		map.put(clone[0], rank);

		for (int i = 1; i < n; i++) {
			if(clone[i - 1] != clone[i]) 
				rank++;
			map.put(clone[i],rank);
		}
	}
}