import java.io.*;
import java.util.*;

public class Main {
    static boolean[] flag;
    static int[] pick;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        flag = new boolean[n + 1];
        pick = new int[m];

        permutation(0);
        System.out.println(sb);
    }

    public static void permutation(int num) {
        if(num == m) {
            for(int i : pick) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!flag[i]) {
                flag[i] = true;
                pick[num] = i;
                permutation(num + 1);
                flag[i] = false;
            }
        }
    }
}