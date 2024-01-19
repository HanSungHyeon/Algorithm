import java.io.*;
import java.util.*;

public class Main {
    static int[] pick;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pick = new int[m];

        combination(1, 0);
        System.out.println(sb);
    }

    public static void combination(int start, int count) {
        if(count == m) {
            for(int i : pick) sb.append(i).append(" ");
            sb.append("\n");

            return;
        }

        for(int i = start; i <= n; i++) {
            pick[count] = i;
            combination(i + 1, count + 1);
        }
    }
}