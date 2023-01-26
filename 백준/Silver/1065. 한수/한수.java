import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		for(int i = 1; i <= n; i ++) {
			int one = 0, ten = 0, hundred = 0;
			if(i <= 99) count++;
			
			else if( i >= 100) {
				one = i % 10;
				hundred = i / 100;
				ten = (i / 10) % 10;
				if(ten - one == hundred - ten) count++;
			}
		}
		System.out.println(count);
	}
}