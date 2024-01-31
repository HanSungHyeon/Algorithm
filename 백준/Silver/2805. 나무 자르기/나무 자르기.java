import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static long max = 0, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        long ans = parametricSearch();
        System.out.println(ans);
    }

    static long parametricSearch() {
        long start =1;
        long end = max;

        while(start <= end) {
            long mid = (start + end) / 2;

            long count = 0;
            for(int i : arr) {
                if(mid >= i) continue;
                count += (i - mid);
            }

            if(count >= m) start = mid + 1;
            else end = mid - 1;
        }
        return end;
    }
}
