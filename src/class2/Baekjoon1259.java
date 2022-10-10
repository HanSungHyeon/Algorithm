package class2;

//1259 펠린드롬수
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringBuilder sb = new StringBuilder(br.readLine());
            //String str = sb.toString();
            //String reverseStr = sb.reverse().toString();

            if(sb.toString().equals("0"))
                break;
            else if(sb.toString().equals(sb.reverse().toString()))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}