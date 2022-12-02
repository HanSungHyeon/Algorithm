import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//11727 2 * n 타일링2
public class Main {
    public static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException {
        //n = (n - 1) + (n - 2) * 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= input; i++)
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;

        System.out.println(dp[input]);
    }
}