package Baekjoon.class1;
//2577 숫자의 개수
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int multi = 1;
        int[] arr = new int[10];
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(br.readLine());
            multi *= num;
        }

        String str = String.valueOf(multi);

        for(int i = 0; i < str.length(); i++){
            int idx = Character.getNumericValue(str.charAt(i));
            arr[idx]++;
        }

        for(int result : arr){
            System.out.println(result);
        }
    }
}