package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2798 블랙잭
public class Baekjoon2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cards = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int result = 0;

        /*카드를 String 배열로 입력 받은 후 int배열로 변환*/
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        /*중복되지 않게 각 for문 마다 카드를 뽑음*/
        for (int a = 0; a < cards - 2; a++) {
            for (int b = a + 1; b < cards - 1; b++) {
                for (int c = b + 1; c < cards; c++) {
                    int sum = arr[a] + arr[b] + arr[c];
                    /*카드의 합이 입력 받은 M을 넘지 않고
                    * 이전 카드의 합보다 크다면*/
                    if(sum <= num && sum > result)
                        result = sum;
                }
            }
        }
        System.out.println(result);
    }
}
