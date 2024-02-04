import java.io.*;
import java.util.*;

public class Main {
    static int n, s, ans = 0;
    static int[] arr;
    static boolean[] flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        flag = new boolean[n];

        combination(0,0,0);
        System.out.println(ans);
    }

    static void combination(int start, int count, int sum) {
        if(count == n) {
            if(sum == s) ans++;
            return;
        }

        if(count > 0) {
            if(sum == s) ans++;
        }

        for(int i = start; i < n; i++) {
            combination(i + 1, count + 1, sum + arr[i]);
        }
    }
}