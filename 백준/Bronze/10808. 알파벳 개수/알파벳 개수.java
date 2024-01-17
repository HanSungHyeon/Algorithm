import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        int[] ans = new int[26];

        for(int i = 0 ; i < arr.length; i++) {
            ans[arr[i] - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(ans).forEach(i -> sb.append(i).append(" "));
        System.out.println(sb);
    }
}