/*
가장 많이 나온 문자열들 조합해서
문자열 하나 맹그러 버림
만들어진 문자열의 해밍디스턴스를 구해야함
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        char[][] arr = new char[n][m];

        for(int i = 0; i < n; i++) arr[i] = br.readLine().toCharArray();

        String ans = "";
        for(int j = 0; j < m; j++) {
            int[] tmp = new int[26];
            for(int i = 0; i < n; i++) {
                char c = arr[i][j];
                tmp[c -'A']++;
            }
            int idx = 0;
            int max = 0;
            for(int i = 0; i < 26; i++) {
                if(max < tmp[i]) {
                    max = tmp[i];
                    idx = i + 65;
                }
            }
            ans += (char)idx;
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(ans.charAt(j) != arr[i][j]) count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ans).append("\n").append(count);
        System.out.println(sb);
    }
}