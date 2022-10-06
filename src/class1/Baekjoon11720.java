package class1;

import java.util.Scanner;

public class Baekjoon11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int tc = sc.nextInt();
        String N = sc.next();


        for(int i = 0; i < tc; i++){
            result += N.charAt(i)-'0';
        }
        System.out.println(result);
    }
}
