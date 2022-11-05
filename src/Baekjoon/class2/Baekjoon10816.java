package Baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Baekjoon10816 {
    public static void main(String[] args) throws IOException { //해시맵을 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //1차 작업
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N; i++) {
            if(!map.containsKey(arr[i])) //해당하는 키값이 없다면
                map.put(arr[i],1); //key = 입력받은 수  value = 갯수
            else    //해당 키 값이 있다면?
                map.put(arr[i], map.get(arr[i]) + 1);   //키값의 벨류 + 1 -> 갯수 증가 느낌
        }

        //수 비교
        int M = Integer.parseInt(br.readLine());
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i : arr2) {
            if(map.containsKey(i)){ //key값이 map에 있다면
                sb.append(map.get(i)).append(" ");
            }
            else    //없다면
                sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}
