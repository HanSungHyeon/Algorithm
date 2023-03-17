import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = new int[(int) (Math.pow(10, 6) + 1)];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        int ans = dp(n);

        System.out.println(ans);
    }

    private static int dp(int num) {
        if (num == 1) return dp[num];

        if (num == 2) return dp[num];

        if (num == 3) return dp[num];

        //이전에 계산이 된 적 있는 값이라면
        if (dp[num] > 0) return dp[num];

        //이전에 연산된 적 없는 값이라면
        int minus1 = Integer.MAX_VALUE, divide2 = Integer.MAX_VALUE, divide3 = Integer.MAX_VALUE;
        if (num % 3 == 0) divide3 = dp(num / 3) + 1;

        if (num % 2 == 0) divide2 = dp(num / 2) + 1;

        minus1 = dp(num - 1) + 1;

        int ans = Math.min(minus1, divide2);

        ans = Math.min(ans, divide3);

        return dp[num] = ans;

    }
}