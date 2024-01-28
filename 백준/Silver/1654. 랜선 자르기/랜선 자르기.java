import java.io.*;
import java.util.*;

public class Main {
    static int[] line;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        line = new int[k];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++) {
            line[i] = Integer.parseInt(br.readLine());
            max = Math.max(line[i], max);
        }

        System.out.println(binarySearch(1, max));
    }

    public static long binarySearch(long start, long end) {
        long ans = 0;
        while(start <= end) {
            long mid = (start + end) / 2;

            long count = 0;
            for(int i : line) count += (i / mid);

            if(count >= n) {
                ans = Math.max(mid, ans);
                start = mid + 1;
            }

            else end = mid - 1;
        }
        return ans;
    }
}