package class2;

import java.io.*;
import java.util.Arrays;

public class Baekjoon2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int[] arr = new int[tc];
        for (int i = 0; i < tc; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        for (int result : arr) {
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
