import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[] paper = { 0, 5, 5, 5, 5, 5 }; // 색종이 갯수 편의상 index 맞춰줌
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[10][10];

		for (int i = 0; i < 10; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		back(0,0,0);
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		
	}

	// 받아온 크기의 색종이를 붙일 수 있는 지 확인
	private static boolean isCheck(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(i < 0 || j < 0 || i > 9 || j > 9 || arr[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	// 색종이 제거
	private static void out(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) { 
				arr[i][j] = 1;
			}
		}
		paper[size]++; //색종이 다시 주머니로
	}

	// 색종이 붙임
	private static void in(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				arr[i][j] = 0;
			}
		}
		paper[size]--; //해당 색종이 소모
	}

	private static void back(int x, int y,int num) {
		//(9,9)까지 다 보고 다음 재귀 탔을 때
		if(x == 9 && y == 10) {
			ans = Math.min(ans,num);
			return;
		}
		
		//열 밖으로 나가면 다음 행 0열로 이동
		if(y == 10) { 
			back(x + 1 ,0, num);
			return;
		}
		/*
		 * 최소 갯수를 구해야 함 일단 큰 거 부터 확인해봄
		 */
		if (arr[x][y] == 1) {
			for (int i = 5; i > 0; i--) {
				// 색종이 여유분이 있고 붙일 수 있으면
				if (isCheck(x, y, i) && paper[i] > 0) {
					in(x,y,i);
					back(x,y + 1,num + 1);
					out(x,y,i);
				}
			}
		}
		else back(x, y + 1,num);
	}
}