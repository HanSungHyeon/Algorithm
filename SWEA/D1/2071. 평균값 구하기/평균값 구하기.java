import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            sb = new StringBuilder("#" + i + " ");
            double result = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).average().getAsDouble();
            System.out.println(sb.append((int) Math.round(result)));
        }
    }
}