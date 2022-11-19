import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		int[] date = {31,28,31,30,31,30,31,31,30,31,30,31};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		
		for(int i = 1; i <= tc; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			StringBuilder sb = new StringBuilder("#" + i + " ");
			int sum =0;
			if(input[0] == input[2]) {
				sb.append(date[input[0] - 1] - input[1] + 1);
			}
			else {
				for(int j =input[0] - 1; j < input[2] - 1; j++) { //7 12 -> 6 11
					 sum += date[j];
				}
				sb.append(sum - input[1] + 1 + input[3]);
			}
			System.out.println(sb);
		}
	}
}
