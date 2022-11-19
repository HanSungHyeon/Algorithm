import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-" };
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int students = Integer.parseInt(st.nextToken());
			int studentNum = Integer.parseInt(st.nextToken());
			double find = 0.0;
			Double[] arr = new Double[students];
			for(int i = 0; i < students; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				arr[i] = a * 0.35 + b *0.45 + c *0.2;
				if(studentNum - 1 == i) find = arr[i];
			}
			Arrays.sort(arr,Collections.reverseOrder());
			
			int rank = 0;
			for(int i =0 ; i <arr.length; i++) {
				if(arr[i] == find)
					rank = i / (students /10);
			}
			System.out.println("#" + t + " " + grade[rank]);
			
		}
	}
}