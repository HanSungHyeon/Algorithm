import java.io.*;
import java.util.*;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= tc; t++) {
            int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            int[] init = new int[arr.length];
            int count =0;
 
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == init[i])
                    continue;
                else {
                    init[i] = arr[i];
                    for (int j = i + 1; j < init.length; j++) 
                        init[j] = init[i];
                    count++;
                }
            }
            sb.append("#" + t + " " + count + "\n");
        }
        System.out.println(sb);
    }
}