package Baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//ACM 호텔
public class Baekjoon10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            /*H = 가로(최대 호수) w = 세로(최대 층수) n = n번째 손님
            * yy = 타겟 층수 xx = 타겟 호수*/
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            /*타겟 층수yy = n번째 손님 % 최대 층수
            * ex) 5번째 손님 -> 5층 -> 5 % 6 = 5
            *     4번째 손님 -> 4층 -> 4 % 6 = 4
            *타겟 호수xx = n번째 손님 / 최대 층수
            * ex) 6번째 손님 -> 6 / 6 = 1호
            *     12번째 손님 -> 12 / 6 = 2호*/
            int yy = N % H, xx = N / H;

            /*예외 6번째 손님 -> 6층 -> 6 % 6 = 0 -> 나머지가 0인 경우 -> 타겟 층수 = 최대 층수*/
            if(yy == 0)
                yy = H;

            /*예외 5번째 손님 1호 -> 5/ 6 = 0 -> 0 + 1 = 1호
            *     13번째 손님 3호 -> 13 / 6 = 2 -> 2 + 1 = 3호
            * --> 손님이 꼭대기 층수에 머무르지 않는 경우 (6의 배수 번째 손님이 아닌 경우) -> 몫에 + 1*/
            else
                xx += 1;

            System.out.println(yy * 100 + xx);
        }
    }
}
