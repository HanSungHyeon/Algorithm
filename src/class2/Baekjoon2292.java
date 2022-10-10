package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2292 벌집
public class Baekjoon2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int count =1, num = 1;

        if(input == 1)
            System.out.println(1);

        else{
            while(input > num){
                num += (count * 6);
                count++;
            }
            System.out.println(count);
        }
     }
}
//1 1칸          - 1칸
//2 ~ 7 2칸 차이  - 6칸
//8 ~ 19 3칸 차이 - 12칸
//20 ~ 37 4칸 차이 - 18칸
//38 ~ 61 5칸 차이 - 24칸
//62 ~ 91 6칸 차이 - 30칸
//92 ~ 91 + 36    - 36칸
//계차수열

/*
* 시작 = 1 도착 13
* 1 + 6 = 7
* 7 + 6 = 13
*
* */