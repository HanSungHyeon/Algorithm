package Baekjoon.class2;

import java.io.*;
import java.util.*;
//11050 이항 계수1
public class Baekjoon11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        /*이항 계수 공식
         * n! / r!(n-r)!
         * 이항 계수에서 분모가 0일 경우 최종 값은 항상 1
         *try 사용 이유 : 어떤 수를 0으로 나누었을 경우 arithmeticexception / by zero 에러 발생
         *해당 에러를 예외 처리 */
        try {
            System.out.println(factorial(n, n) / (factorial(k, k) * factorial(n - k, n - k)));
        }catch (Exception e){
            System.out.println(1);
        }
    }
    /*n! 을 처리하기 위한 메서드*/
    public static int factorial(int num,int result) {
        if(num == 1 || num == 0) return result;

        return factorial(num - 1,result * (num - 1));
    }
}
