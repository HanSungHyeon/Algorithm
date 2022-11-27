import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine()); //1이상 들어옴
        dp = new int[input + 1];

        dp[0] = dp[1] = 0;
        
        //재귀x -> 너무 오래걸림
        //반복문 접근
        //dp[idx]에 값 할당 후 최종 출력
        for (int idx = 2; idx <= input; idx++) {
            dp[idx] = dp[idx - 1] + 1; // -1 start
            if(idx % 2 == 0) dp[idx] = Math.min(dp[idx], dp[idx / 2] + 1); //-1 start와 /2 start 중 최솟값
            if(idx % 3 == 0) dp[idx] = Math.min(dp[idx], dp[idx / 3] + 1); //21번의 최솟값과 /3 start 중 최솟값
        }
        System.out.println(dp[input]);
    }
}