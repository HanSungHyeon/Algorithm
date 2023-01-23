import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] stairs;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        stairs = new int[num + 1];
        dp = new int[num + 1];

        for (int i = 1; i <= num; i++)
            stairs[i] = Integer.parseInt(br.readLine());

        System.out.println(solution(num));
    }

    public static int solution(int num) {
        if(num == 1)
            return dp[num] = stairs[num];
        else if(num == 2)
            return dp[num] = stairs[num] + stairs[num - 1];
        else if (num == 3)
            return dp[num] = Math.max(stairs[num - 1],stairs[num - 2]) + stairs[num];
        else if (dp[num] > 0)
            return dp[num];
        else
            return dp[num] = Math.max(solution(num - 2), solution(num - 3) + stairs[num - 1]) + stairs[num];
    }
}