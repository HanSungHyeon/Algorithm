import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        int pay = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String d = st.nextToken();
            int c = Integer.parseInt(st.nextToken());

            if(d.equals("jinju"))
                pay = c;

            arr[i] = c;
        }
        int count = 0;
        for(int i : arr) {
            if(i > pay) count++;
        }

        System.out.println(pay);
        System.out.println(count);
    }
}
