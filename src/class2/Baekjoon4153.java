package class2;
//4153 직각삼각형
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String[] str = br.readLine().split(" ");
            int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr); //맨 마지막 요소 -> arr[2] = 가장 큰 값
            if(arr[0] + arr[1] == 0)
                break;
            else if(Math.pow(arr[0],2) + Math.pow(arr[1],2) == Math.pow(arr[2],2))
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}
