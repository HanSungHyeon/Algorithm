package Baekjoon.class1;

import java.util.Scanner;

//2675 문자열 반복
public class Baekjoon2675 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt(); //전체적인 반복횟수 testcase

        for(int i = 0; i < tc; i++){ //tc만큼 반복
            int num = sc.nextInt(); //2
            String text = sc.next(); //abc
            String[] arr = text.split("");  //문자열 하나씩 잘라서 배열에 박음 ex) ABC -> [A,B,C]
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < arr.length; j++){   //{a,b,c} = 3번 반복
                sb.append(arr[j].repeat(num)); //arr[1] = a.repeat(2) ->aabbcc
            }
            System.out.println(sb); //aaabbbccc
        }
    }
}