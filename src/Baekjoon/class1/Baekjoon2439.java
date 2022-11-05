package Baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for(int i = 1; i <= num; i++){ //5번 반복  i = 1
            System.out.printf(" ".repeat(num - i));
            System.out.printf("*".repeat(i));
            System.out.println();
        }
    }
}
