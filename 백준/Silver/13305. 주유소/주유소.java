import java.io.*;
import java.util.*;

public class Main {
	static int[] dir;
	static int[] station;
	static int n,cur = Integer.MAX_VALUE,price = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		// 거리
		dir = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		// 주유소
		station = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		start();
		System.out.println(price);
		
	}
	private static void start() {
		cur = station[0];
		for(int i = 0; i < station.length - 1; i++) {
			if(cur  > station[i]) {
				cur = station[i];
				price += cur * dir[i];
			}
			else{
				price += cur * dir[i];
			}
		}
	}
	
}