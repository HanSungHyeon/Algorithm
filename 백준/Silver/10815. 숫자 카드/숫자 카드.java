import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] cardsA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i : cardsA)
			map.put(i, 1);

		int m = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) 
			sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()) ,0) + " "); 
		
		System.out.println(sb);
	}
}