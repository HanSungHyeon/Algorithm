import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            for (int i = 1; i < arr[0]; i++) {
                for (int j = i + 1; j < arr[0]; j++) {
                    if ((Math.pow(i, 2) + Math.pow(j, 2) + arr[1]) % (i * j) == 0)
                        count++;
                }
            }
            System.out.println(count);
        }
    }
}