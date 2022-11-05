package Baekjoon.class1;
//8958 OX퀴즈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            String str = br.readLine();
            /*score = 최종 결과, count = 'O'가 연속된 횟수*/
            int score = 0, count = 0;

            for(int j = 0; j < str.length(); j++){
            /*O가 연속 될 경우 count를 계속 증가 시키면서 score에 더함*/
                if(str.charAt(j) == 'O')
                    count++;
                else
                    count = 0;
                score += count;
            }
            System.out.println(score);
        }
    }
}