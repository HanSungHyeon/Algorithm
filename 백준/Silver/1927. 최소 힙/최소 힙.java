import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num != 0)
				add(num);
			else
				print(num);
		}
		System.out.println(sb);
	}

	private static void add(int num) {
		pq.add(num);
	}

	private static void print(int num) {
		if (pq.isEmpty())
			sb.append(0 + "\n");

		else
			sb.append(pq.poll() + "\n");
	}
}