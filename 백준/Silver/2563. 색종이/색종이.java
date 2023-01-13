import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] borad = new boolean[100][100];
        int result = 0;
		int input = Integer.parseInt(br.readLine());

		while (input-- > 0) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			for (int i = num1; i < num1 + 10; i++) {
				for (int j = num2; j < num2 + 10; j++) {
                    if(!borad[i][j]){
                        borad[i][j] = true;
                        result++;
                    }
				}
			}
		}
		System.out.println(result);
	}
}