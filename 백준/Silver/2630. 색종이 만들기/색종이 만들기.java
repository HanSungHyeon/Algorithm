import java.io.*;
import java.util.*;

public class Main {
	static int n,count0 = 0,count1 = 0;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i = 0; i < n; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		divide(0,0,n);
		
		System.out.println(count0);
		System.out.println(count1);
	}
	
	/**
	 * 종이 분할
	 * 4개 분면으로 분할
	 * 현재 종이가 전부 같은 색일 경우 return하고 더 이상 재귀를 태우지 않음
	 * @param x - row 시작위치
	 * @param y - column 시작위치
	 * @param size - 길이
	 */
	private static void divide(int x, int y, int size) {
		//같은 색이라면 색 확인하고 해당 색 개수 올림
		if(isCheck(x,y,size)) {
			if(arr[x][y] == 1) count1++;
			else count0++;
			
			return;
		}
		
		//분할 - 현재 사이즈 / 2
		int mid = size / 2;
		
		//좌측 상단
		divide(x, y, mid);
		//우측 상단
		divide(x, y + mid, mid);
		//좌측 하단
		divide(x + mid, y, mid);
		//우측 하단
		divide(x + mid, y + mid, mid);
	}
	
	/**
	 * 현재 종이가 전부 같은 색인지 판단
	 * 첫번째 칸의 색과 나머지 칸의 색을 비교
	 * @param x - row
	 * @param y - col
	 * @param size - 현재 종이 사이즈
	 * @return - 같은 색 : true, 다른 색 : false
	 */
	private static boolean isCheck(int x, int y, int size) {
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(arr[x][y] != arr[i][j]) return false;
			}
		}
		return true;
	}
}