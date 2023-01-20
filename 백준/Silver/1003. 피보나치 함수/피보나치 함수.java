import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] dp = new int[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] result = dp(n);
            System.out.println(result[0] + " "  + result[1]);
        }
    }

    public static int[] dp(int num){
        if(num == 0) return dp[0];
        else if (num == 1) return dp[1];
        else if(dp[num][0] !=0 && dp[num][1] != 0) return dp[num];
        else {
            int[] dp1 = dp(num - 1);
            int[] dp2 = dp(num - 2);
            return dp[num] = new int[]{dp1[0] + dp2[0],dp1[1] + dp2[1]};
        }
    }
}