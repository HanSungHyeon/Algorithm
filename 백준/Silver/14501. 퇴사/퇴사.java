import java.io.*;
import java.util.*;

public class Main {
	static int n, ans = Integer.MIN_VALUE;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		
		for(int i = 0; i < n; i++) 
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
		
		recursion(0, 0);
		System.out.println(ans);
	}
	
	private static void recursion(int idx, int sum) {
		//System.out.println("idx : " + idx + " sum : " + sum);
		//할 수 있는 상담 다 했을 때
		if(idx == n) {
			ans = Math.max(ans,sum);
			return;
		}
		
		//상담 기간을 벗어나는 경우
		if(idx > n) return;
		
		//상담이 끝나자마자 바로 다음 상담 진행
		recursion(idx + arr[idx][0], sum + arr[idx][1]);
		//한턴 쉬고 진행
		recursion(idx + 1, sum);
	}
	private static void print() {
		for(int i = 0 ; i < n; i++)
			System.out.println(Arrays.toString(arr[i]));
	}
}