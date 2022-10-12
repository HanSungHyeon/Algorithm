package class2;
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
        int gcd = GCD(num1, num2);

        System.out.println(gcd);
        System.out.println(num1 * num2 / gcd); //최소공배수

    }
    //최대공약수
    public static int GCD(int num1, int num2) {
        while (num2 != 0) {
            int remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }
        return num1;
    }
}