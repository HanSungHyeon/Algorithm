import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int input = Integer.parseInt(br.readLine());
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] arr2 = Arrays.stream(arr).distinct().sorted().toArray();
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < arr2.length; i++) map.put(arr2[i], i);
		
		for(int el : arr) sb.append(map.get(el)).append(" ");
		
		System.out.println(sb);
	}
}
