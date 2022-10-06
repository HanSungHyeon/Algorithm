package class1;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] arr = new int[tc];

        for(int i = 0; i < tc; i++){
            int num = sc.nextInt();
            arr[i] = num;
        }
        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[arr.length - 1]);
    }
}
