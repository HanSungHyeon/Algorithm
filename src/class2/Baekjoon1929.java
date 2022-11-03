package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N + 1];

        for(int i = 2; i <= N; i++){
            if(arr[i])
                continue;

            if(i>= M)
                sb.append(i).append("\n");

            for(int j = i + i; j<= N; j+=i)
                arr[j] = true;
        }
        System.out.println(sb);
    }
}
