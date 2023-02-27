import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr,d = {{1,0},{-1,0},{0,1},{0,-1}};
	static int n, count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//하얀색 천 2차원 배열 생성
		arr = new int[101][101];
		//스카프의 개수 입력
		n = Integer.parseInt(br.readLine());
		
		//스카프 입력
		for(int t = 0 ; t < n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//검은색 스카프의 왼쪽 변과 흰색 천 왼쪽의 거리
			int c = Integer.parseInt(st.nextToken());
			//검은색 스카프의 아래쪽 변과 흰색 천 아래의 거리
			int r = Integer.parseInt(st.nextToken());

			//천에 스카프 표시
			for(int i = r; i < r + 10; i++) {
				for(int j = c; j < c + 10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		//정답
		int ans = 0;
		
		//둘레가 맞을 경우 ans를 한개씩 추가
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0;  j < arr.length; j++) {
				if(arr[i][j] == 0) {
					if(isCheck(i, j)) {
						ans += count;
					}
				}
				
			}
		}
		System.out.println(ans);
		//print();
	}
	
	public static void print() {
		for(int i = 0; i< arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	//0과 맞닿은 부분은 둘레라고 가정하여 true 반환
	public static boolean isCheck(int x, int y) {
		if(arr[x][y] ==0) {
			count = 0;
			for(int a =0 ; a < d.length; a++) {
				int dx = x + d[a][0];
				int dy = y + d[a][1];
				
				if(dx < 0 || dy < 0 || dx >= arr.length || dy >= arr.length)
					continue;
				
				if (arr[dx][dy] == 1) {
					count++;
				}
			}
		}
		if(count > 0) return true;
		return false;
	}
}