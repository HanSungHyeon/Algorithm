import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//본인 기준으로 3개 뒤에 있는거 더함
public class Main {
    public static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int num = Integer.parseInt(br.readLine());
            memo = new int[num + 1];
            System.out.println(roop(num));
        }
    }

    public static int roop(int num) {
        if (num == 0) return memo[0] = 0;
        else if (num == 1) return memo[1] = 1;
        else if (num == 2) return memo[2] = 2;
        else if (num == 3) return memo[3] = 4;
        else
            return memo[num] = roop(num - 1) + roop(num - 2) + roop(num - 3);
    }
}