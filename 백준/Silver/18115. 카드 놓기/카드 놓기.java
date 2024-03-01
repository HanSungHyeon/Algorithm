import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Deque<Integer> dq = new ArrayDeque<>();

		int num = 1;
		for (int i = n - 1; i >= 0; i--) {
			int card = arr[i];

			switch (card) {
				case 1:
					dq.addFirst(num);
					break;
				case 2: {
					int tmp = dq.pollFirst();
					dq.addFirst(num);
					dq.addFirst(tmp);
				}
				break;
				case 3:
					dq.addLast(num);
					break;
			}
			num++;
		}
		StringBuilder sb = new StringBuilder();
		while (!dq.isEmpty()) {
			sb.append(dq.poll()).append(" ");
		}
		System.out.println(sb);
	}
}