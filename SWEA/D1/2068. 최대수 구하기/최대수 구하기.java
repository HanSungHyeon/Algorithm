import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 3; i++) {
            sb = new StringBuilder("#" + i + " ");
            int result = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).max().getAsInt();
            System.out.println(sb.append(result));
        }
    }
}