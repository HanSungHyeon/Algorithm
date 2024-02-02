import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static boolean[] flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        flag = new boolean[n + 1];
        Arrays.fill(flag, true);
        flag[0] = false;
        flag[1] = false;

        int ans = isPrime();
        System.out.println(ans);
    }

    static int isPrime() {
        int count = 0;
        for(int i = 2; i <= n; i++) {
            if(flag[i]) {
                flag[i] = false;
                count++;
                if(count == k) return i;
                for(int j = i * i; j <= n; j += i) {
                    if(flag[j]) {
                        flag[j] = false;
                        count++;
                        if(count == k) return j;
                    }
                }
            }
        }
        return 0;
    }
}