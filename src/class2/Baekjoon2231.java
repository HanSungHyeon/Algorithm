package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//분해합
public class Baekjoon2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()), result = 0;

        for (int i = 0; i < num; i++) {
            int temp = i;
            int sum = 0;

            while(temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if(sum + i == num) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
