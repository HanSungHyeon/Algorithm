package Baekjoon.class2;

import java.io.*;
import java.util.*;
//1978 소수찾기
public class Baekjoon1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int result = 0;
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < tc; i++) {
            int count = 0;

            /*소수 : 자기 자신과 1을 약수로 가짐
            * 1부터 자기 자신까지 순회하며 나누었을 때 약수가 2개라면
            * 소수로 판단*/
            for (int j = 1; j <= arr[i]; j++) {
                if(arr[i] % j == 0) count++;
            }

            if(count == 2) result +=1;
        }

        System.out.println(result);
    }
}
