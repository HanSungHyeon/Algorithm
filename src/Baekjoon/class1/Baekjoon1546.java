package Baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" "); //점수

        /*String 배열을 정렬된 double형 배열로 전환*/
        double[] arr = Arrays.stream(input).mapToDouble(Double::parseDouble).sorted().toArray();

        /*배열의 맨 마지막 요소 = 최댓값*/
        double max = arr[arr.length - 1];

        /*조작한 점수를 넣을 배열 생성*/
        double[] newArr = new double[arr.length];

        /*(입력 받은 점수 / 최댓값) x 100 -> ex) 40 / 80 x 100 = 50*/
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = (arr[i] / max) * 100;
        }

        /*newArr스트림 생성 -> 스트림의 평균 값 구하기-> 구한 평균 값을 double형으로 변환*/
        double result = Arrays.stream(newArr).average().getAsDouble();

        System.out.println(result);
    }
}
