import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        hanoi(num, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb.toString());
    }

    public static void hanoi(int num, int left, int mid, int right) {
        count++;
        if (num == 1) {
            sb.append(left).append(" ").append(right).append("\n");
            return;
        }
        hanoi(num - 1, left, right, mid);
        sb.append(left).append(" ").append(right).append("\n");
        hanoi(num - 1, mid, left, right);
    }
}