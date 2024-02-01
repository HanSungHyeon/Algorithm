import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] d = new int[n];
        int max = 1;

        for(int i = 0; i < n; i++) {
            d[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
            max = Math.max(max, d[i]);
        }
        System.out.println(max);
    }
}