import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Map<String, Integer> map = new HashMap<>();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count = 0;

		for (int i = 0; i < n; i++)
			map.put(br.readLine(), 1);

		for (int i = 0; i < m; i++) {
			try {
				if (map.get(br.readLine()) == 1)
					count++;
			} catch (NullPointerException e) {
			}

		}
		System.out.println(count);
	}
}