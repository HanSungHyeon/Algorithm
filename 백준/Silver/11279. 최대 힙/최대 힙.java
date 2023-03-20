import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 입력으로 0이 들어오면 가장 큰 값 제거
		 * 아니면 배열 삽입
		 * 우선순위큐 사용 -> 정렬조건 내림차순
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num != 0) pq.add(num);
				
			else {
				if(pq.isEmpty()) sb.append(0 + "\n");
				
				else sb.append(pq.poll()).append("\n");
			}
		}
		System.out.println(sb);
	}
}