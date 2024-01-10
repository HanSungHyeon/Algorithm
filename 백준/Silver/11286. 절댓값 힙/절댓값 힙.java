import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2))
					return o1 - o2;
				
				return Math.abs(o1) - Math.abs(o2);
			}});
		
		int n = Integer.parseInt(br.readLine());

		for(int i = 0 ; i< n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(pq.isEmpty() && num == 0) 
				sb.append(0).append('\n');
			
			else if(num == 0) 
				sb.append(pq.poll()).append('\n');
			
			else 
				pq.add(num);
			
		}
		System.out.println(sb);
	}
}