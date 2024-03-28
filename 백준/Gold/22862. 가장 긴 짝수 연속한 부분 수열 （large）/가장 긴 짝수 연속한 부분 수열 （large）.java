import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		System.out.println(twoPointer());
	}
	static int twoPointer() {
		int start = 0;
		int end = 0;
		int len = 0;
		int cnt = 0;

		if(arr[end] % 2 == 1) cnt = 1;
		
		while(start < n && end < n) {
			//제거 가능한 갯수
			if(cnt <= k) {
				len = Math.max(len, end - start + 1 - cnt);
				end++;
				if(end < n && !isEven(end)) cnt++;
			}
			
			//제거 불가능한 갯수
			else {
				if(!isEven(start)) cnt--;
				start++;
			}
		}
		return len;
	}
	//짝수 -> true
	static boolean isEven(int idx) {
		return arr[idx] % 2 == 0;
	}
}