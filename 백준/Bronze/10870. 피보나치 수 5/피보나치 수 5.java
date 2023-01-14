import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		memo = new int[num +1];
		
		System.out.println(fibonacci(num));
	}
	public static int fibonacci(int num) {
		if(num == 0) return memo[num] = 0;
		
		if(num == 1) return memo[num] = 1;
		
		if(memo[num] > 0) return memo[num];
		
		return memo[num] = fibonacci(num - 1) + fibonacci(num -2);
	}
}