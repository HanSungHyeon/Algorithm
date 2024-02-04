import java.io.*;
import java.util.*;
//조합
public class Main {
    static int[] arr, pick;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            arr = new int[n];
            pick = new int[6];

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            combination(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void combination(int start, int count) {
        if(count == 6) {
            for(int i : pick) sb.append(i).append(" ");

            sb.append("\n");
            return;
        }

        for(int i = start; i < n; i++) {
            pick[count] = arr[i];
            combination(i + 1, count + 1);
        }
    }
}