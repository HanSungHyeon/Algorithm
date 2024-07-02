/*
* 동굴을 세워서 생각
* */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[] arr = new int[h + 1];

		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(i % 2 == 0) {
				arr[0]++;
				arr[num]--;
			} else {
				arr[h - num]++;
				arr[h]--;
			}
		}

		int min = Integer.MAX_VALUE;
		for(int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
			if(i != h) {
				min = Math.min(min, arr[i]);
			}
		}

		int count = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] == min) count++;
		}
		System.out.println(min + " " + count);
	}
}