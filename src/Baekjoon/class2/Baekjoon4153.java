package Baekjoon.class2;

import java.io.*;
import java.util.Arrays;
//4153 직각삼각형
public class Baekjoon4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            /*입력 받은 문자열을 스트림 배열로 변환 -> IntStream으로 변환 -> 정렬 -> 배열로 변환*/
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            StringBuilder sb= new StringBuilder();
            if(arr[0] + arr[1] == 0)
                break;
            /*0번 인덱스 제곱 + 1번 인덱스 제곱 = 2번 인덱스 제곱*/
            else if(Math.pow(arr[0],2) + Math.pow(arr[1],2) == Math.pow(arr[2],2))
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}
