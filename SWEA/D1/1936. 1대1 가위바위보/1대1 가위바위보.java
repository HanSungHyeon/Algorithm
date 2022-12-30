import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (input[0] - input[1] == -2) sb.append("A");
        else if (input[1] - input[0] == -2) sb.append("B");
        else if (input[0] > input[1]) sb.append("A");
        else sb.append("B");

        System.out.println(sb);
    }
}