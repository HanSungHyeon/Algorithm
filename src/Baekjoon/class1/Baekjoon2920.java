package Baekjoon.class1;

//2920 음계
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2920 {
    public static void main(String[] args) throws IOException {
        String[] asc = {"1","2","3","4","5","6","7","8"};
        String[] desc = {"8","7","6","5","4","3","2","1"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        /*앞의 배열과 뒤의 배열이 같을 경우*/
        if(Arrays.equals(asc,arr))
            System.out.println("ascending");
        else if(Arrays.equals(desc,arr))
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}