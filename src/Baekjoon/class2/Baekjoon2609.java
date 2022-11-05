package Baekjoon.class2;
//2609 최소공배수 최대공약수
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1  = Integer.parseInt(st.nextToken());
        int num2  = Integer.parseInt(st.nextToken());
        int num3 = num1, num4 = num2;

        /*최대공약수 구하는 공식*/
        while (num4 != 0) {
            int remainder = num3 % num4;
            num3 = num4;
            num4 = remainder;
        }

        System.out.println(num3); //최대 공약수
        System.out.println(num1 * num2 / num3); //최소공배수

    }
}