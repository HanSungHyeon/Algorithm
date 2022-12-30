import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int result = 0;

        for (int i = 0; i < input.length; i++)
            result += input[i];

        System.out.println(result);
    }
}