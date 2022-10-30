package class1;
//10818 최소, 최대
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        /*문자열 입력 후 input 배열에 삽입*/
        String[] input = br.readLine().split(" "); //20 10 35 30 7 7 10

        /*input 배열 스트림 생성 -> mapToInt로 Int스트림으로 변경 -> 정렬 -> 스트림을 배열로 전환*/
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).sorted().toArray();

        /*정렬된 배열의 0인덱스와 마지막 인덱스 출력*/
        System.out.println(arr[0] + " " + arr[arr.length - 1]);
    }
}
