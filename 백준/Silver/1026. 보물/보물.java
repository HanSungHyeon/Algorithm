import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Integer> a = new LinkedList<>();
		List<Integer> b = new LinkedList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a.add(Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			b.add(Integer.parseInt(st.nextToken()));

		Collections.sort(a);
		Collections.sort(b, Collections.reverseOrder());

		int sum = 0;
		for (int i= 0; i < n; i++) {
			sum += a.get(i) * b.get(i);
		}
		System.out.println(sum);

	}
}