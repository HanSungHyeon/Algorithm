package Baekjoon.class2;

import java.io.*;
import java.util.Arrays;

public class Baekjoon2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int[] arr = new int[tc];
        for (int i = 0; i < tc; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.stream(arr).sorted().forEach(value -> sb.append(value).append("\n"));

        System.out.println(sb);
    }
}
