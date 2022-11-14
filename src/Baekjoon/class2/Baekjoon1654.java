package Baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1654 랜선 자르기
public class Baekjoon1654 {
    public static void main(String[] args) throws IOException {
        //이분 탐색을 이용한 문제
        //이분 탐색의 대상은 랜선의 길이
        //이분탐색에서의 mid값 = (low + high) / 2
        //입력으로 들어오는 n -> 랜선 갯수
        //갯수가 중복 될 때 중복 요소의 최대 길이
        //ex) 198cm로 자를 때 11개, 199cm -> 11개, 200cm -> 11개 ----> 이중 최대 값은 200
        //uperbound -1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); //가지고 있는 랜선의 갯수
        int n = Integer.parseInt(st.nextToken()); //필요한 랜선의 갯수

        long[] arr = new long[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long max = Arrays.stream(arr).max().getAsLong() + 1;//랜선의 길이가 다 다르기 때문에 max값은 무조건 있으므로 예외처리하지않음
        max += 1;

        long min = 0;

        while (min < max) {
            long mid = (max + min) / 2;
            long count = 0;

            for (int i = 0; i < k; i++) {
                count += arr[i] / mid;
            }

            if(count < n) max = mid;
            else min = mid+1;
        }
        System.out.println(min -1);

    }
}
