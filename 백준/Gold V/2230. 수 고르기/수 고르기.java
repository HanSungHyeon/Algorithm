import java.io.*;
import java.util.*;

public class Main {
    static int n, m, min = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        twoPointer();

        System.out.println(min);
    }
    static void twoPointer() {
        int start = 0;
        int end = 0;

        while(start < n && end < n) {
            if(arr[end] - arr[start] >= m) {
                min = Math.min(min, arr[end] - arr[start]);
                start++;
            }
            else
                end++;
        }
    }
}
