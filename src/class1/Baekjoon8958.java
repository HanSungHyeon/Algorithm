package class1;
//8958 OX퀴즈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            String str = br.readLine();
            int score = 0, count = 0;
            for(int j = 0; j < str.length(); j++){
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