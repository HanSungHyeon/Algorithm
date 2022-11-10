package Baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int movie = 666;
        int count = 1;

        while (count != input) {
            movie++;

            if (String.valueOf(movie).contains("666"))
                count++;
        }
        System.out.println(movie);
    }
}
