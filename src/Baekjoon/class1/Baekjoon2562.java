package Baekjoon.class1;

import java.util.Scanner;

public class Baekjoon2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0,line = 0;

        for(int i = 1; i <= 9; i++){
            int input = sc.nextInt();
            if(num < input) {
                num = input;
                line = i;
            }
        }
        System.out.println(num);
        System.out.println(line);
    }
}
