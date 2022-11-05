package Baekjoon.class2;

import java.io.*;

//2839 설탕배달
public class Baekjoon2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int count5 = input / 5;
        int remainder = input % 5;

        if(remainder == 0)
            System.out.println(count5);
        else if(remainder == 1 && count5 >= 1)
            System.out.println(count5 - 1 + 2);
        else if(remainder == 2 && count5 >= 2) //r = 2 -> 12 //
            System.out.println(count5 - 2 + 4);
        else if(remainder == 3)
            System.out.println(count5 + 1);
        else if(remainder ==4 && count5 >= 1) //r = 4 -> 9
            System.out.println(count5 - 1 + 3);
        else
            System.out.println(-1);
    }
}
