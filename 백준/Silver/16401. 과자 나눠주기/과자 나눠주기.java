import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static int m, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

        System.out.println(binarySearch());
    }

    public static long binarySearch() {
        long start = 1;
        long end = arr[arr.length - 1];

        long ans = 0;
        while(start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for(long l : arr) {
                count += (l / mid);
            }
            
            if(count >= m) {
                start = mid + 1;
                ans = Math.max(mid, ans);
            }

            else end = mid - 1;
        }

        return ans;
    }
}
