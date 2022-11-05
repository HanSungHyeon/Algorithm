package Baekjoon.class1;
//3052 나머지
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*Set -> 중복을 허용하지 않음*/
        HashSet<Integer> set = new HashSet<Integer>();

        /*입력 받은 수를 42로 나눈 나머지를 set에 저장*/
        for(int i = 0; i < 10; i++){
            int num = Integer.parseInt(br.readLine());
            set.add(num % 42); //{1 4 5 6 7} = 크기 = 5
        }
        /*set의 크기 출력*/
        System.out.println(set.size());
    }
}
