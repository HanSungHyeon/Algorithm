import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        while (true) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(input[0] == 0 && input[1] == 0 && input[2] ==0) break;
            StringBuilder sb = new StringBuilder("Case ");
            count ++;

            int result = input[2] / input[1] * input[0];
            int reminder = input[2] % input[1];

            if(reminder > input[0]) reminder = input[0];

            sb.append(count).append(": ").append(result + reminder);
            System.out.println(sb);
        }
    }
}
