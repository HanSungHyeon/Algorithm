/*
좌표 압축 문제
두 배열이 동일한지 알아보는 문제임
숫자가 서로 다름
좌표 압축으로 줄 세워버림
좌표 압축 방법 :
복사본 두고서 어디있는지 확인
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] arr;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		list = new ArrayList[m];

		for(int i = 0; i < m; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] tmp = Arrays.stream(arr[i]).distinct().sorted().toArray();
			list[i] = new ArrayList<>();
			for(int num : tmp) {
				list[i].add(num);
			}
		}

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = binarySearch(i, arr[i][j]);
			}
		}

		int count = 0;
		for(int i = 0; i < m - 1; i++) {
			for(int j = i + 1; j < m; j++) {
				if(Arrays.equals(arr[i],arr[j])) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	static int binarySearch(int idx, int target) {
		int start = 0;
		int end = list[idx].size() - 1;

		while(start <= end) {
			int mid = (start + end) / 2;
			int cur = list[idx].get(mid);
			//타겟이 현재보다 크면?
			if(cur < target) start = mid + 1;

			else if(cur > target) end = mid - 1;

			else return mid;
		}
		return -1;
	}

}
