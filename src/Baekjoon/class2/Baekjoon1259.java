package Baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//1259 펠린드롬수
public class Baekjoon1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            /*문자열을 입력해서 StringBuilder sb 변수에 넣음*/
            StringBuilder sb = new StringBuilder(br.readLine());
            /*equals를 쓰기 위해 StringBuilder를 String 타입으로 변환
            * 0 -> 루프 종료
            * 기존 문자열 == 뒤집은 문자열 -> yes*/
            if(sb.toString().equals("0"))
                break;

            else if(sb.toString().equals(sb.reverse().toString())) //1321==1231-> false
                System.out.println("yes");

            else
                System.out.println("no");
        }
    }
}