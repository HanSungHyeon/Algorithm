import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			sb.append(num - 1).append("\n");
			int tmp = Integer.parseInt(st.nextToken());
			for(int i = 0; i < tmp; i++) {
				st = new StringTokenizer(br.readLine());
			}
		}
		System.out.println(sb);

	}
}