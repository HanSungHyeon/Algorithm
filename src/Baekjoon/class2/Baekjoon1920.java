package Baekjoon.class2;

import java.io.*;
import java.util.Arrays;

public class Baekjoon1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int target : arr2) {
            int result = 0;
            if(Arrays.binarySearch(arr1,target) >= 0)
                result = 1;
            else
                result = 0;
            bw.write(String.valueOf(result) + '\n');
        }
        bw.flush();
        bw.close();
    }
}

/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        int[] arr1 = Arrays.stream(input1).mapToInt(Integer::parseInt).sorted().toArray();

        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        int[] arr2 = Arrays.stream(input2).mapToInt(Integer::parseInt).toArray();

        for (int target : arr2) {
            int low = 0, high = arr1.length - 1,  result = 0;
            while (high >= low) {
                int mid = (low + high) / 2;
                if (arr1[mid] == target) {
                    result = 1;
                    break;
                } else if (arr1[mid] > target) { //중간 요소가 타겟보다 큰 경우 -> 왼쪽 배열 탐색 -> high 축소
                    high = mid - 1;
                } else                          //중간 요소가 타겟보다 작은 경우 -> 오른쪽 배열 탐색 -> low 상승
                    low = mid + 1;
            }
            bw.write(String.valueOf(result) + '\n');
        }
        bw.flush();
        bw.close();*/