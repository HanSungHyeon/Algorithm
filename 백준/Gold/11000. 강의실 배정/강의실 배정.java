import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int n;
	//pq에 남은건 강의실 개수
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		for (int i = 0; i < n; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// 시작 시간 기준으로 오름차순 정렬
		// 시작 시간이 같으면 종료시간 기준으로 오름차순 정렬
		Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		
		//배열 정렬 후 가장 빨리 시작하는 강의 시작
		solution(arr[0][1]);
		
		System.out.println(pq.size());
	}
	private static void solution(int end) {
		//강의실 하나 차지
		pq.add(end);
		for(int i = 1; i < n; i++) {
			//다음 강의의 시작 시간이 현재 강의 끝나는 시간 이상일 때
			//같은 강의실 사용
			if(arr[i][0] >= pq.peek()) pq.poll();
			
			//if에 걸렸으면 수업 하나 빠지고 그 자리에 이어서 수업한다고 생각
			//if에 안걸렸으면 새로운 강의실로 수업이 들어간다고 생각
			pq.add(arr[i][1]);
		}
	}
}